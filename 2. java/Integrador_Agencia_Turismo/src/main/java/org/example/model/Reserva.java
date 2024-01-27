package org.example.model;

public class Reserva implements Model, Decorator {
    private Cliente cliente;
    private double total;
    private String id;
    private TipoReserva tipoReserva;

    public Reserva(String id,Cliente cliente, double total, TipoReserva tipoReserva) {
        this.id=id;
        this.cliente = cliente;
        this.total = total;
        this.tipoReserva=tipoReserva;
    }
    protected Reserva(String id,Cliente cliente, TipoReserva tipoReserva) {
        this.id=id;
        this.cliente = cliente;
        this.tipoReserva=tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String toString() {
        return "Reserva" + '\n' +
                "Cliente: " + cliente + '\n' +
                "Total: " + total + '\n' +
                "Id: " + id + '\n' +
                "Tipo Reserva: " + tipoReserva+ '\n';
    }
}