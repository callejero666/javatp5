public class MaquinaCafe extends Thread {
    private String nombre;
    private Cafe cafe;

    public MaquinaCafe(String nombre) {
        this.nombre = nombre;
    }

    public void prepararCafe(Cafe cafe) {
        this.cafe = cafe;
        this.start();
    }

    @Override
    public void run() {
        System.out.println("La máquina " + nombre + " está preparando café " + cafe.getTipo());

        int tiempo = cafe.getTiempoDePreparacion();
        try {
            Thread.sleep(tiempo * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("La máquina " + nombre + " terminó de preparar café " + cafe.getTipo());
        prepararAdicional(cafe);
    }

    private void prepararAdicional(Cafe cafe) {
        
        
        String ingredientes;
        switch (cafe.getTipo().toLowerCase()) {
            case "espresso":
                ingredientes = "Ingredientes de Espresso: Café molido, Agua.";
                break;
            case "capuchino":
                ingredientes = "Ingredientes de Capuchino: Café espresso, Leche caliente, Espuma de leche.";
                break;
            case "latte":
                ingredientes = "Ingredientes de Latte: Café espresso, Leche caliente, Espuma de leche (opcional).";
                break;
            case "americano":
                ingredientes = "Ingredientes de Americano: Café espresso, Agua caliente.";
                break;
            case "cortado":
                ingredientes = "Ingredientes de Cortado: Café espresso, Una pequeña cantidad de leche caliente.";
                break;
            default:
                ingredientes = "Tipo de café no reconocido.";
                break;
        }
        System.out.println("Operación adicional: " + ingredientes);
    }
}
