public class Transporte implements IServicio{
    protected IServicio iServicio;
    private String descripcion;
    private Double costo;

    public Transporte(IServicio iServicio, String descripcion, Double costo) {
        this.iServicio = iServicio;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "iServicio=" + iServicio +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                '}';
    }

    @Override
    public String obtenerDescripcion() {
        return this.iServicio.obtenerDescripcion() + "\n Descripcion transporte: " + this.descripcion + "\n Costo transporte: " + this.costo;
    }

    @Override
    public Double obtenerCosto() {
        return this.iServicio.obtenerCosto() + this.costo;
    }

    @Override
    public String servicios() {
        return this.iServicio.servicios() + " Transporte";
    }

}