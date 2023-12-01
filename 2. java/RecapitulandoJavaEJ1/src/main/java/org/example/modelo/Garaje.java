package org.example.modelo;

import java.util.List;

public class Garaje {
    private static int id = 0;
    List<Vehiculo> vehiculos;

    public Garaje(List<Vehiculo> vehiculos) {
        id++;
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
