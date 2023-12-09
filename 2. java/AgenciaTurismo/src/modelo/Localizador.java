package modelo;

import interfaces.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Localizador implements Modelo {

    private String id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private Double total;

    public Localizador(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public void calcularTotal(Double descuento) {
        double descuentoFinal = 1 - descuento;
        this.total = reservas.stream().mapToDouble(Reserva::getPrecio).sum() * descuentoFinal;
    }

    public boolean tieneTipoReserva(TipoReserva tipoReserva) {
        return this.reservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == tipoReserva);
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return "\nLocalizador{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                '}';
    }
}
