public class Boletos implements IServicio {
    protected IServicio iServicio;
    private String descripcion;
    private Double costo;
    private String origen;
    private String destino;

    public Boletos(IServicio iServicio, String descripcion, Double costo, String origen, String destino) {
        this.iServicio = iServicio;
        this.descripcion = descripcion;
        this.costo = costo;
        this.origen = origen;
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Boletos{" +
                "iServicio=" + iServicio +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }

    @Override
    public String obtenerDescripcion() {
        return this.iServicio.obtenerDescripcion() + "\n Descripcion boleto: " + this.descripcion + "\n Costo boleto:  " + this.costo + "\n Origen boleto: " + this.origen + "\n Destino boleto: " + this.destino + "\n\n";
    }

    @Override
    public Double obtenerCosto() {
        return this.iServicio.obtenerCosto() + this.costo;
    }

    @Override
    public String servicios() {
        return this.iServicio.servicios() + " Boleto";
    }


}
