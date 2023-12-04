package org.example;

import org.example.socorristas.Socorrista;
import org.example.socorristas.SocorristaAuto;
import org.example.socorristas.SocorristaMoto;
import org.example.vehiculos.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculospermitidos;
    private final List<Vehiculo> vehiculos;
    private final Socorrista<Auto> socorristaAuto;
    private final Socorrista<Moto> socorristaMoto;


    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculospermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculospermitidos = cantidadDeVehiculospermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculospermitidos() {
        return cantidadDeVehiculospermitidos;
    }

    public void setCantidadDeVehiculospermitidos(int cantidadDeVehiculospermitidos) {
        this.cantidadDeVehiculospermitidos = cantidadDeVehiculospermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculospermitidos)
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        else
            System.out.println("Lo sentimos, el cupo esta lleno");
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculospermitidos)
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        else
            System.out.println("Lo sentimos, el cupo esta lleno");
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        boolean eliminado = vehiculos.remove(vehiculo);

        if (!eliminado)
            System.out.println("No se ha encontrado el vehiculo");
    }

    public void eliminarVehiculo(String patente) {
        boolean eliminado = vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));

        if (!eliminado)
            System.out.println("No se ha encontrado el vehiculo");
    }

    public Vehiculo definirGanador() {
        return vehiculos.stream()
            .sorted(Comparator.comparing(Carrera::formulaGanador))
            .toList()
            .getLast();
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> vehiculo = vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();

        if (vehiculo.isPresent() && vehiculo.get() instanceof Auto)
            socorristaAuto.socorrer((Auto) vehiculo.get());
        else
            System.out.println("No se ha encontrado el vehiculo o no es un auto");
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> vehiculo = vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();

        if (vehiculo.isPresent() && vehiculo.get() instanceof Moto)
            socorristaMoto.socorrer((Moto) vehiculo.get());
        else
            System.out.println("No se ha encontrado el vehiculo o no es una moto");
    }

    private static Double formulaGanador(Vehiculo vehiculo) {
        return (vehiculo.getVelocidad() * vehiculo.getAceleracion() / 2) /
               (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }
}
