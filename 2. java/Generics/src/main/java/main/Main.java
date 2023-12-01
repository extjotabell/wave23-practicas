package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        Garage garage = new Garage(01, vehiculos);

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        // Ejercicio 3
        List<Vehiculo> vehiculosOrdenadosPorPrecio = vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .toList();
        //vehiculosOrdenadosPorPrecio.forEach(System.out::println);

        // Ejercicio 4
        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio = vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparing(Vehiculo::getCosto)))
                .toList();
        // vehiculosOrdenadosPorMarcaYPrecio.forEach(System.out::println);

        // Ejercicio 5
        double precio = 1000.00;
        List<Vehiculo> vehiculosConPrecioMenorA1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto()<precio)
                .toList();
        //vehiculosConPrecioMenorA1000.forEach(System.out::println);

        List<Vehiculo> vehiculosConPrecioMayorOIgualA1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto()>=precio)
                .toList();
        //vehiculosConPrecioMayorOIgualA1000.forEach(System.out::println);

        OptionalDouble precioPromedio = vehiculos.stream()
                .mapToDouble(v->v.getCosto()).average();
        //System.out.println("Promedio: " + precioPromedio);

    }
}