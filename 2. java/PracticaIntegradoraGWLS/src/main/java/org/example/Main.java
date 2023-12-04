package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = listaVehiculos();
        Garaje garaje = new Garaje(1, vehiculos);

        System.out.println("Vehiculos ordenados por precio de menor a mayor:");
        garaje.getListaVehiculos().stream().map(vehiculo -> vehiculo.getCosto()).
                sorted().forEach(System.out::println);

        System.out.println();
        System.out.println("Vehiculos ordenados por marca y precio:");
        garaje.getListaVehiculos().stream().map(vehiculo -> vehiculo.getMarca() + " -> " + vehiculo.getCosto()).
                sorted().forEach(System.out::println);


        System.out.println();
        System.out.println("Vehiculos con precio no mayor a 1000:");
        List<Double> listaCostoMenor = garaje.getListaVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000).map(vehiculo -> vehiculo.getCosto()).collect(Collectors.toList());

        listaCostoMenor.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Vehiculos con precio no mayor a 1000:");
        List<Double> Mil = garaje.getListaVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).map(vehiculo -> vehiculo.getCosto()).collect(Collectors.toList());

        Mil.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Promedio de  precio de vehiculos");
        Double suma = garaje.getListaVehiculos().stream().map(vehiculo -> vehiculo.getCosto()).mapToDouble(Double::doubleValue).average().orElse(0);

        System.out.printf("Promedio = " + suma);


    }

    private static List<Vehiculo> listaVehiculos() {
        List<Vehiculo> listVehiculos = new ArrayList<>();

        listVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        listVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        listVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        listVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        listVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        listVehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        listVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        listVehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        listVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        listVehiculos.add(new Vehiculo("Renault", "Logan", 950));

        return listVehiculos;
    }
}