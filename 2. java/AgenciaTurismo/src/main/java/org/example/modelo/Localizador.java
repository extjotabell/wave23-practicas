package org.example.modelo;

import org.example.interfaces.Modelo;

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

    public void calcularTotal() {
        if (reservas.size() >= 2){
            this.total = reservas.stream().mapToDouble(Reserva::getPrecio).sum() * 0.95;
            System.out.println("Descuento aplicado");
            return;
        }
        this.total = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
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
