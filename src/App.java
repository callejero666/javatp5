import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private List<MaquinaCafe> maquinCafeteras;
    private List<Cafe> pedidoCafes;

    public App() {
        maquinCafeteras = new ArrayList<>();
        pedidoCafes = new ArrayList<>();
        inicializarMaquinas();
    }

    private void inicializarMaquinas() {
        for (int i = 1; i <= 3; i++) {
            maquinCafeteras.add(new MaquinaCafe("Maquina " + i));
        }
    }

    private void asignarMaquina(Cafe cafe) {
        if (pedidoCafes.isEmpty()) {
            return;
        }

        boolean asignacionMaquina = false;
        while (!asignacionMaquina) {
            for (MaquinaCafe maquina : maquinCafeteras) {
                if (!maquina.isAlive()) {
                    maquina.prepararCafe(cafe);
                    asignacionMaquina = true;
                    break;
                }
            }
            if (!asignacionMaquina) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n¿Qué café desea pedir?");
            System.out.println("1. Espresso");
            System.out.println("2. Capuchino");
            System.out.println("3. Latte");
            System.out.println("4. Americano");
            System.out.println("5. Cortado");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    pedidoCafes.add(new Cafe("Espresso", generarTiempo(10, 15)));
                    break;
                case 2:
                    pedidoCafes.add(new Cafe("Capuchino", generarTiempo(12, 20)));
                    break;
                case 3:
                    pedidoCafes.add(new Cafe("Latte", generarTiempo(5, 30)));
                    break;
                case 4:
                    pedidoCafes.add(new Cafe("Americano", generarTiempo(25, 30)));
                    break;
                case 5:
                    pedidoCafes.add(new Cafe("Cortado", generarTiempo(10, 20)));
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

            if (opcion >= 1 && opcion <= 5) {
                Cafe ultimoPedido = pedidoCafes.get(pedidoCafes.size() - 1);
                System.out.println("Pedido añadido: Café " + ultimoPedido.getTipo());
                asignarMaquina(ultimoPedido);
            }
        }
        

        System.out.println("Saliendo del programa.");
        scanner.close();
    }

    private int generarTiempo(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}


    
