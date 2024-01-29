package org.example.models;

import socorrista.SocorristaAuto;
import socorrista.SocorristaMoto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        vehiculos = new ArrayList<>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() == cantidadDeVehiculosPermitidos) {
            System.out.println("Ya se han llenado los cupos");
            return;
        }
        vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        System.out.println("Se ha dado de alta el auto");
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() == cantidadDeVehiculosPermitidos) {
            System.out.println("Ya se han llenado los cupos");
            return;
        }
        vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        System.out.println("Se ha dado de alta la moto");
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.remove(vehiculo)) {
            System.out.println("Se ha eliminado el vehiculo");
        } else {
            System.out.println("No se ha eliminado el vehiculo");
        }
    }

    public void eliminarVehiculoConPatente(String patente) {
        eliminarVehiculo(buscarPorPatente(patente));
    }

    public Vehiculo ganador() {
        Vehiculo ganador = null;
        double formulaMax = Double.MIN_VALUE;
        for (Vehiculo vehiculo : vehiculos) {
            double formula = vehiculo.formula();
            if (formula > formulaMax) {
                formulaMax = formula;
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente) {
        Vehiculo vehiculo = buscarPorPatente(patente);
        if (vehiculo == null || vehiculo instanceof Moto) {
            return;
        }
        socorristaAuto.socorrer((Auto) vehiculo);
    }

    public void socorrerMoto(String patente) {
        Vehiculo vehiculo = buscarPorPatente(patente);
        if (vehiculo == null || vehiculo instanceof Auto) {
            return;
        }
        socorristaMoto.socorrer((Moto) vehiculo);
    }

    public Vehiculo buscarPorPatente(String patente) {
        return vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equalsIgnoreCase(patente)).findFirst().orElse(null);
    }
}
