package org.example;

import java.util.*;

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

        System.out.println("Lista de Vehiculos ordenados de menor a mayor costo.");
        garage.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Lista de Vehiculos ordenados por marca y por costo");
        garage.getVehiculos()
                .stream()
                .sorted((vehiculo1, vehiculo2) -> vehiculo1.getMarca().compareTo(vehiculo2.getMarca()) == 0 ? vehiculo1.getCosto().compareTo(vehiculo2.getCosto()) : vehiculo1.getMarca().compareTo(vehiculo2.getMarca()))
                .forEach(System.out::println);

        System.out.println();

        List<Vehiculo> bajoCosto = garage.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();

        System.out.println();

        List<Vehiculo> altoCosto = garage.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();

        System.out.println("Lista de Vehiculos de coste menor a 1000");
        bajoCosto.stream()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Lista de Vehiculos de coste mayor a 1000");
        altoCosto.stream()
                .forEach(System.out::println);

        System.out.println();

        OptionalDouble promedio = garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average();

        if (promedio.isPresent()){
            System.out.println("El costo promedio de los vehiculos es: " + promedio);
        }
    }
}
