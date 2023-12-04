package org.example;

public enum TipoDeReserva {
    PAQUETE_COMPLETO("Paquete completo", 1000.00),
    RESERVA_HOTEL("Reserva de hotel", 100.0),
    BOLETO_VIAJE("Boleto de viaje", 100.0),
    COMIDA("Comida", 100.0),
    TRANSPORTE("Transporte", 100.0);

    private final String descripcion;
    private double costo;

    TipoDeReserva (String descripcion, double costo){
        this.descripcion = descripcion;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Tipo de reserva: " +
                 descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
