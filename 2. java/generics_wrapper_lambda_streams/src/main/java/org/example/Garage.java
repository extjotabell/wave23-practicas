package org.example;

import java.util.ArrayList;

public class Garage {
    int id;
    ArrayList<Vehiculo> vehiculos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Garage(int id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }
}
