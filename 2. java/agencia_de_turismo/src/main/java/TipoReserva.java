public enum TipoReserva {
    HOTEL("Hotel"),
    BOLETO("Boleto"),
    COMIDA("Comida"),
    TRANSPORTE("Transporte");

    private String tipo;

    TipoReserva(String tipo) { this.tipo = tipo; }
    public String getTipo() { return tipo; }
}
