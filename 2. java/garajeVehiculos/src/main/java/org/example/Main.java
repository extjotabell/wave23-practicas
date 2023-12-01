package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
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

        Garaje garaje = new Garaje(vehiculos);

        ejecutarEjercicio3(garaje);
        ejecutarEjercicio4(garaje);
        ejecutarEjercicio5(garaje);

    }

    private static void ejecutarEjercicio5(Garaje garaje) {
        System.out.println("-------- Ejercicio 5 --------");
        System.out.println("-------- Menos a 1000 --------");
        garaje.traerVehiculosConPrecioMenorA(1000);
        System.out.println("-------- Mayor o igual a 1000 --------");
        garaje.traerVehiculosConPrecioMayoroIgualA(1000);
        System.out.println("-------- Promedio total --------");
        garaje.traerPromedioTotalDePrecios();
    }

    private static void ejecutarEjercicio4(Garaje garaje) {
        System.out.println("-------- Ejercicio 4 --------");
        garaje.ordenarVehiculosPorMarcaYPrecio();
    }

    private static void ejecutarEjercicio3(Garaje garaje) {
        System.out.println("-------- Ejercicio 3 --------");
        garaje.ordenarVehiculosPorPrecio();
    }
}