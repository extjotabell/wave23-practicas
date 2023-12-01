package main;

import java.util.*;

public class Garage {
    private int id;
    List<Vehiculo> vehiculos;

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }
}
