package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>(List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)));

        vehiculos.sort((v1, v2) -> Integer.compare(v1.getCosto(), v2.getCosto()));

        vehiculos.sort((v1, v2) -> {
            int compareMarca = v1.getMarca().compareTo(v2.getMarca());
            if (compareMarca == 0) {
                return Integer.compare(v1.getCosto(), v2.getCosto());
            }
            return compareMarca;
        });


        List<Vehiculo> vehiculosMenosDe1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000).toList();

        List<Vehiculo> vehiculosMasDe1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000).toList();

        double promedio = vehiculos.stream()
                .mapToInt(Vehiculo::getCosto)
                .average()
                .orElse(0.0);


        vehiculos.forEach(System.out::println);
        System.out.println("\nPromedio de todos los vehículos: " + promedio);

        System.out.println();
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        int[] array = {5, 3, 2, 8, 1};
        int[] sortedArray = burbuja(array);
        System.out.println(Arrays.toString(sortedArray));

    }

    public static int[] burbuja(int[] array) {
        return Arrays.stream(array).sorted().toArray();
    }
}