package org.bootcamp;

import org.socorristas.Socorrista;
import org.socorristas.SocorristaAuto;
import org.socorristas.SocorristaMoto;
import org.vehiculos.Auto;
import org.vehiculos.Moto;
import org.vehiculos.Vehiculo;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {

    protected double distancia, premioEnDolares;
    protected String nombre;
    protected int cantidadDeVehiculosPermitidos;

    protected final List<Vehiculo> vehiculos;
    protected final Socorrista<Auto> socorristaAuto;
    protected final Socorrista<Moto> socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos){
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
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

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
        else {
            System.out.println("Lo sentimos, el cupo esta lleno.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
        else {
            System.out.println("Lo sentimos, el cupo esta lleno.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        boolean eliminado = vehiculos.remove(vehiculo);
        if (!eliminado){
            System.out.println("No se ha encontrado el vehiculo.");
        }
        else{
            System.out.println("Vehiculo Eliminado de la carrera");
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        boolean eliminado = vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
        if (!eliminado){
            System.out.println("No se ha encontrado el vehiculo.");
        }
        else{
            System.out.println("Vehiculo Eliminado de la carrera");
        }
    }

    public Vehiculo definirGanador(){
        return vehiculos.stream().
                sorted(Comparator.comparing(Carrera::formulaGanador))
                .toList().stream()
                .collect(Collectors.reducing((first, second) -> second))
                .get();
    }

    public void socorrerAuto(String patente){
        Optional<Vehiculo> vehiculo = vehiculos.stream()
                .filter(veh -> veh.getPatente().equals(patente))
                .findFirst();

        if (vehiculo.isPresent() && vehiculo.get() instanceof Auto){
            socorristaAuto.socorrer((Auto) vehiculo.get());
        }
        else{
            System.out.println("No se ha encontrado el vehiculo, o el mismo no es un Auto.");
        }
    }

    public void socorrerMoto(String patente){
        Optional<Vehiculo> vehiculo = vehiculos.stream()
                .filter(veh -> veh.getPatente().equals(patente))
                .findFirst();

        if (vehiculo.isPresent() && vehiculo.get() instanceof Moto){
            socorristaMoto.socorrer((Moto) vehiculo.get());
        }
        else{
            System.out.println("No se ha encontrado el vehiculo, o el mismo no es una Moto.");
        }
    }

    public static Double formulaGanador(Vehiculo vehiculo){
        return (vehiculo.getVelocidad() * vehiculo.getAceleracion() / 2) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

}
