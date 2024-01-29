package org.example.model;

public class Agencia {

    private ReservasRepository reservas;
    private ClientRepository clientes;

    public Agencia() {
        this.reservas = new ReservasRepository();
        this.clientes = new ClientRepository();
    }

    public ReservasRepository getReservas() {
        return reservas;
    }

    public void setReservas(ReservasRepository reservas) {
        this.reservas = reservas;
    }

    public ClientRepository getClientes() {
        return clientes;
    }

    public void setClientes(ClientRepository clientes) {
        this.clientes = clientes;
    }

    public void realizarReserva(Cliente cliente, Reserva reserva){
        Decorator reservaFinal = cliente.agregarReserva(reserva);
        reservas.add(reserva);
        System.out.println(reservaFinal);
    }
}
