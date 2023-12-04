package org.example;

import java.util.List;

public class Factura {

    private Cliente cli;
    private List<Item> listaItems;
    private double total;

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Factura(Cliente cli, List<Item> listaItems, double total) {
        this.cli = cli;
        this.listaItems = listaItems;
        this.total = total;
    }
}
