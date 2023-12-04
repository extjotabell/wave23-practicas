package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.OptionalDouble;

public class Carrera {
    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private ArrayList<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void altaAuto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        if (vehiculos.size() < cantidadVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
            System.out.println("Se agregó un nuevo auto a la lista");
        } else {
            System.out.println("No hay más lugar en la lista de vehiculos");
        }
    }

    public void altaMoto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        if (vehiculos.size() < cantidadVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
            System.out.println("Se agregó un nuevo auto a la lista");
        } else {
            System.out.println("No hay más lugar en la lista de vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().ifPresent(vehiculoBuscado -> vehiculos.remove(vehiculoBuscado));
    }

    public void socorrerAuto(String patente){
        vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().ifPresent(vehiculoASocorrer -> socorristaAuto.socorrer(vehiculoASocorrer));
    }

    public void socorrerMoto(String patente){
        vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().ifPresent(vehiculoASocorrer -> socorristaMoto.socorrer(vehiculoASocorrer));
    }

    public void definirGanador() {
        Vehiculo vehiculoGanador = vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularScore))
                .orElse(null);

        if (vehiculoGanador != null) {
            System.out.println("El vehículo ganador es: " + vehiculoGanador.getPatente());
        } else {
            System.out.println("No hay vehículos en la carrera.");
        }
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioDolares=" + premioDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                ", socorristaAuto=" + socorristaAuto +
                ", socorristaMoto=" + socorristaMoto +
                '}';
    }
}
