package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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


        List<Vehiculo> listaVehiculosOrdenada = garage.getVehiculos().stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .collect(Collectors.toList());

        List<Vehiculo> listaVehiculosOrdenada2 = garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());

        List<Vehiculo> listaVehiculosFiltrada = garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000.0)
                .collect(Collectors.toList());

        List<Vehiculo> listaVehiculosFiltrada2 = garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000.0)
                .collect(Collectors.toList());

        double promedioPrecios = garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println(listaVehiculosOrdenada);
        System.out.println(listaVehiculosOrdenada2);
        System.out.println(listaVehiculosFiltrada);
        System.out.println(listaVehiculosFiltrada2);
        System.out.println(promedioPrecios);
    }
}
