package org.supermercado;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> lista;
    private double total;

    public Factura(Cliente cliente, List<Item> lista) {
        this.cliente = cliente;
        this.lista = lista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getLista() {
        return lista;
    }

    public void setLista(List<Item> lista) {
        this.lista = lista;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", lista=" + lista +
                ", total=" + total +
                '}';
    }
}
