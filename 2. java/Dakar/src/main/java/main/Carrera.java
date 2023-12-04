package main;

import java.util.*;

public class Carrera {
    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculoList;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void socorrerAuto(String patente) {
        socorristaAuto.socorrer(vehiculoList.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().get());
    }

    public void socorrerMoto(String patente) {
        socorristaMoto.socorrer(vehiculoList.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().get());
    }

    public void determinarGanador(){
        Vehiculo vehiculoGanador = vehiculoList.get(0);
        double calculoGanador = vehiculoGanador.getVelocidad() * 0.5 * vehiculoGanador.getAceleracion() / (vehiculoGanador.getAnguloDeGiro()*(vehiculoGanador.getPeso()-vehiculoGanador.getCantRuedas()* 100));
        for(int i=1;i<vehiculoList.size();i++){
            double aux;
            Vehiculo auxV= vehiculoList.get(i);
            aux = auxV.getVelocidad() * 0.5 * auxV.getAceleracion() / (auxV.getAnguloDeGiro()*(auxV.getPeso()-auxV.getCantRuedas()* 100));
            if(aux>calculoGanador){
                vehiculoGanador = auxV;
                calculoGanador = aux;
            }
        }
        System.out.println("El vehiculo ganador es: " + vehiculoGanador);
    }
    public void eliminarVehiculoConPatente(String patente){
        vehiculoList.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
        System.out.println("Se elimino el vehiculo de patente "+ patente);
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        vehiculoList.remove(vehículo);
    }

    public void darDeAltaAuto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(vehiculoList.size()<this.cantidadVehiculosPermitidos){
            Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculoList.add(auto);
        }else{
            System.out.println("No hay cupo para el auto de patente "+patente);
        }
    }
    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(vehiculoList.size()<this.cantidadVehiculosPermitidos){
            Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculoList.add(moto);
        }else{
            System.out.println("No hay cupo para la moto de patente "+patente);
        }
    }

    public Carrera(double distancia, double premioDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> vehiculoList, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculoList = vehiculoList;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(double premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }
}
