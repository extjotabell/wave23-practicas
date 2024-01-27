package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Garaje {
    //Ejercicio 1
    private String id;
    private ArrayList<Vehiculo> listaDeVehiculos;

    public Garaje(String id, ArrayList<Vehiculo> listaDeVehiculos) {
        this.id = id;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(ArrayList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}
