package org.ejercicio.modelo;

import java.util.*;

public class Localizador {
    private List<IServicio> iServicioList;
    private Cliente cliente;
    private Double totalLocalizador;

    public Localizador(List<IServicio> iServicioList, Cliente cliente, Double totalLocalizador) {
        this.iServicioList = iServicioList;
        this.cliente = cliente;
        this.totalLocalizador = totalLocalizador;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "iServicioList=" + iServicioList +
                ", cliente=" + cliente +
                ", totalLocalizador=" + totalLocalizador +
                '}';
    }

    public List<IServicio> getiServicioList() {
        return iServicioList;
    }

    public void setiServicioList(List<IServicio> iServicioList) {
        this.iServicioList = iServicioList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotalLocalizador() {

        return totalLocalizador;
    }

    public void setTotalLocalizador(Double totalLocalizador) {
        this.totalLocalizador = totalLocalizador;
    }
}
