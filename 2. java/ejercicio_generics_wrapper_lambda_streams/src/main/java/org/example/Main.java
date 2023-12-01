package org.example;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage(1, List.of(new Vehiculo("Ford", "Fiesta", 1000),
                                                new Vehiculo("Ford", "Focus", 1200),
                                                new Vehiculo("Ford", "Explorer", 2500),
                                                new Vehiculo("Fiat", "Uno", 500),
                                                new Vehiculo("Fiat", "Cronos", 1000),
                                                new Vehiculo("Fiat", "Torino", 1250),
                                                new Vehiculo("Chevrolet", "Aveo", 1250),
                                                new Vehiculo("Chevrolet", "Spin", 2500),
                                                new Vehiculo("Toyota", "Fortuner", 3000),
                                                new Vehiculo("Renault", "Logan", 950)));
        //Ejercicio 3

        garage.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);

        //Ejercicio 4
        System.out.println();

        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        //Extra por modelo y luego por precio

        System.out.println();

        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getModelo).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        //Ejercicio 5

        System.out.println();
        garage.getVehiculos().stream().filter((v) -> v.getCosto() < 1000).forEach(System.out::println);

        System.out.println();
        garage.getVehiculos().stream().filter((v) -> v.getCosto() >= 1000).forEach(System.out::println);

        System.out.println();
        System.out.println(garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().toString());
    }
}
