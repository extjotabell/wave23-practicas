package org.ejercicio;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>(List.of(
                new Vehiculo("Fiesta", "Ford", 1000),
                new Vehiculo("Focus", "Ford", 1200),
                new Vehiculo("Explorer", "Ford", 2500),
                new Vehiculo("Uno", "Fiat", 500),
                new Vehiculo("Cronos", "Fiat", 1000),
                new Vehiculo("Torino", "Fiat", 1250),
                new Vehiculo("Aveo", "Chevrolet", 1250),
                new Vehiculo("Spin", "Chevrolet", 2500),
                new Vehiculo("Corola", "Toyota", 1200),
                new Vehiculo("Fortuner", "Toyota", 3000),
                new Vehiculo("Logan", "Renault", 950)
        ));

        //3.
        System.out.println("Orden por costo:  ");
        vehiculos.stream().sorted(( v1,v2) -> Integer.valueOf(v1.getCosto()).compareTo(v2.getCosto())).forEach(System.out::println);
        System.out.println();

        //4.
        System.out.println("Orden por costo y marca:  ");
        Comparator<Vehiculo> comparator = Comparator.comparing(Vehiculo::getCosto);
        comparator = comparator.thenComparing(Comparator.comparing(Vehiculo::getMarca));

        List<Vehiculo> ordenadoCostoyMarca = vehiculos.stream().sorted(comparator).collect(Collectors.toList());
        ordenadoCostoyMarca.forEach(System.out::println);
        System.out.println();

        //5.
        System.out.println("-   Vehiculos con costo menor a 1000:");
        vehiculos.stream().filter(v -> v.getCosto() < 1000).forEach(System.out::println);

        System.out.println("-   Vehiculos con costo mayor o igual a 1000:");
        vehiculos.stream().filter(v -> v.getCosto() >= 1000).forEach(System.out::println);

        System.out.println();
        System.out.println("Promedio de costo de vehiculo:");
        OptionalDouble costoPromedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average();
        System.out.printf("%.2f",costoPromedio.getAsDouble());

    }
}