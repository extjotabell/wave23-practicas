public class Comida implements IServicio {

    protected IServicio iServicio;
    private String descripcion;
    private Double costo;
    private String tipo;

    public Comida(IServicio iServicio, String descripcion, Double costo, String tipo) {
        this.iServicio = iServicio;
        this.descripcion = descripcion;
        this.costo = costo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "iServicio=" + iServicio +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public String obtenerDescripcion() {
        return this.iServicio.obtenerDescripcion() + "\n Descripcion comida: " + this.descripcion + "\n Costo comida: " + this.costo + "\n Tipo comida: " + this.tipo + "\n\n";
    }


    @Override
    public Double obtenerCosto() {
        return this.iServicio.obtenerCosto() + this.costo;
    }

    @Override
    public String servicios() {
        return this.iServicio.servicios() + " Comida";
    }


}
