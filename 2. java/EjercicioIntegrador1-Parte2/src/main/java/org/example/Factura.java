package org.example;

import java.util.List;

public class Factura {


    private int codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public Factura(int codigo,Cliente cli, List<Item> listaItems) {
        this.codigo = codigo;
        this.cli = cli;
        this.listaItems = listaItems;
        listaItems.forEach(i -> this.total += (i.getCant() * i.getCostoUnitario()));
    }
}
