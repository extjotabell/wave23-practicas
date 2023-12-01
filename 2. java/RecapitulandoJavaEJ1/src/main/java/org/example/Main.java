package org.example;

import org.example.modelo.Garaje;
import org.example.modelo.Vehiculo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = List.of(
                new Vehiculo("Ford", "Fiesta", 1000.0),
                new Vehiculo("Ford", "Focus", 1200.0),
                new Vehiculo("Ford", "Explorer", 2500.0),
                new Vehiculo("Fiat", "Uno", 500.0),
                new Vehiculo("Fiat", "Cronos", 1000.0),
                new Vehiculo("Fiat", "Torino", 1250.0),
                new Vehiculo("Chevrolet", "Aveo", 1250.0),
                new Vehiculo("Chevrolet", "Spin", 2500.0),
                new Vehiculo("Toyota", "Corola", 1200.0),
                new Vehiculo("Toyota", "Fortuner", 3000.0),
                new Vehiculo("Renault", "Logan", 950.0)
        );

        Garaje garaje = new Garaje(vehiculos);

        System.out.println("Vehiculos en el garaje:");
        garaje.getVehiculos().forEach(System.out::println);

        System.out.println();
        System.out.println("Vehiculos ordenados por precio:");
        garaje.getVehiculos().stream()
                .sorted((v1, v2) -> v1.getCosto().compareTo(v2.getCosto()))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Vehiculos ordenados por marca y precio:");
        garaje.getVehiculos().stream()
                .sorted((v1, v2) -> {
                    int resultado = v1.getMarca().compareTo(v2.getMarca());
                    if (resultado == 0) {
                        resultado = v1.getCosto().compareTo(v2.getCosto());
                    }
                    return resultado;
                })
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Vehiculos con precio menor a 1000:");
        garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Vehiculos con precio mayor o igual a 1000:");
        garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Promedio de precios:");
        System.out.println(garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0));

    }
}