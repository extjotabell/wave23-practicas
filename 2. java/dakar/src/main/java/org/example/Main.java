package org.example;

import org.example.vehiculos.Auto;
import org.example.vehiculos.Moto;
import org.example.vehiculos.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(10000, 1000000, "Dakar", 5);

        carrera.darDeAltaAuto(100, 100, 45, "PAT1");
        carrera.darDeAltaAuto(200, 50, 45, "PAT2");
        carrera.darDeAltaAuto(150, 160, 45, "PAT3");
        carrera.darDeAltaMoto(5110, 100, 45, "PAT4");
        carrera.darDeAltaMoto(70, 120, 45, "PAT5");
        carrera.darDeAltaMoto(40, 100, 45, "PAT6");

        System.out.println("\nVehiculos:");
        carrera.getVehiculos().forEach(System.out::println);

        System.out.println("\nGanador: " + carrera.definirGanador());

        System.out.println("\nSocorriendo vehiculos:");
        carrera.socorrerAuto("PAT5");
        carrera.socorrerMoto("PAT4");
        carrera.socorrerAuto("PAT1");

        System.out.println("\nEliminando vehiculos:");
        carrera.eliminarVehiculo("PAT1");
        carrera.getVehiculos().forEach(System.out::println);
    }
}