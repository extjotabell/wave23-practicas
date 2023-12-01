package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = List.of(
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
        );

        Garaje garaje = new Garaje(1, vehiculos);

        System.out.println("Vehiculos ordenados por costo");

        garaje.getVehiculos().stream().
                sorted(Comparator.comparing(Vehiculo::getCosto)).
                forEach(System.out::println);

        System.out.println("Vehiculos ordenados por marca y por costo");

        garaje.getVehiculos().stream().
                sorted((o1, o2) -> o1.getMarca().compareTo(o2.getMarca()) == 0 ?
                        o1.getCosto().compareTo(o2.getCosto()) : o1.getMarca().compareTo(o2.getMarca()))
                .forEach(System.out::println);

        System.out.println("Vehiculos con costo inferior a 1000");

        List<Vehiculo> vehiculosBajaGama = garaje.getVehiculos().stream().
                filter(vehiculo -> vehiculo.getCosto() < 1000).toList();
        vehiculosBajaGama.forEach(System.out::println);

        System.out.println("Vehiculos con costo igual o superior a 1000");

        List<Vehiculo> vehiculosAltaGama = garaje.getVehiculos().stream().
                filter(vehiculo -> vehiculo.getCosto() >= 1000).toList();
        vehiculosAltaGama.forEach(System.out::println);

        OptionalDouble promedio = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average();

        if (promedio.isPresent()) System.out.println("El costo promedio es: " + promedio.getAsDouble());
    }
}