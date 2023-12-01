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

        
    }
}
