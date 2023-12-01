package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public void adicionarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
