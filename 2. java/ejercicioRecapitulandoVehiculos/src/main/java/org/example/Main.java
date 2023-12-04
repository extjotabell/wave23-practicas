package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Garaje garaje = new Garaje(1);

        Vehiculo auto1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo auto2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo auto3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo auto4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo auto5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo auto6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo auto7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo auto8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo auto9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo auto10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo auto11 = new Vehiculo("Renault", "Logan", 950);

        garaje.addVehiculo(auto1);
        garaje.addVehiculo(auto2);
        garaje.addVehiculo(auto3);
        garaje.addVehiculo(auto4);
        garaje.addVehiculo(auto5);
        garaje.addVehiculo(auto6);
        garaje.addVehiculo(auto7);
        garaje.addVehiculo(auto8);
        garaje.addVehiculo(auto9);
        garaje.addVehiculo(auto10);
        garaje.addVehiculo(auto11);

        //Punto 3
       // garaje.getListaVehiculos()
        // .stream()
        // .sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        //Punto 4
        /*Comparator<Vehiculo> compararMarcaCosto = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);

        garaje.getListaVehiculos()
                .stream()
                .sorted(compararMarcaCosto).forEach(System.out::println);*/

        //Punto 5
        //garaje.getListaVehiculos().stream().filter(a -> a.getCosto() < 1000).forEach(System.out::println);
        //garaje.getListaVehiculos().stream().filter(a -> a.getCosto() >= 1000).forEach(System.out::println);
        System.out.println(
                garaje.getListaVehiculos().stream().mapToInt(Vehiculo::getCosto).average()
        );

    }
}