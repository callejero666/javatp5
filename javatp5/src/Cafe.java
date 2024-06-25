public class Cafe {
    private String tipo;
    private int tiempoDePreparacion;

    public Cafe( String tipo, int tiempoDePreparacion ) {
        this.tipo = tipo;
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(int tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }


}