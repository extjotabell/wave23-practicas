package org.example.Dakar.Clases;

import org.example.Dakar.Enum.TipoCategoria;

import java.util.List;

public class Carrera {

    private double distancia, premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private TipoCategoria tipoCategoria;


    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, TipoCategoria tipoCategoria) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.tipoCategoria = tipoCategoria;
    }

    public void darDeAltaAuto(Auto auto) {
        if (tipoCategoria.equals(TipoCategoria.AUTO)) {
            vehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(Moto moto) {
        if (tipoCategoria.equals(TipoCategoria.MOTO)) {
            vehiculos.add(moto);
        }
    }

    public void definirGanador() {
        Vehiculo ganador;

        for (Vehiculo v : vehiculos) {
            double calculo = (v.getVelocidad() * 1 / 2 * v.getAceleracion()) / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
        }
    }
}
