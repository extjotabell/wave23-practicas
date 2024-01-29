public class ReservaBase implements IServicio {
    private String descripcion;
    private Double costo;
    private String servicios;

    public ReservaBase(String descripcion, Double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "ReservaBase{" +
                "descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                '}';
    }

    @Override
    public String obtenerDescripcion() {
        return this.descripcion;
    }

    @Override
    public Double obtenerCosto() {
        return this.costo;
    }

    @Override
    public String servicios() {
        return this.servicios;
    }


}