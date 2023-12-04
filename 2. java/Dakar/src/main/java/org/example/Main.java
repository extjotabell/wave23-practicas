package org.example;

import org.example.modelo.Carrera;
import org.example.modelo.Vehiculo;

public class Main {
    public static void main(String[] args) {


        Carrera carrera = new Carrera(300.0, 5000.0, "Autódromo Ospina", 4);

        carrera.darDeAltaAuto(150.0, 10.0, 30.0, "ABC123");
        carrera.darDeAltaMoto(120.0, 8.0, 25.0, "XYZ789");
        carrera.darDeAltaAuto(200.0, 15.0, 40.0, "QWE456");
        carrera.darDeAltaMoto(100.0, 5.0, 20.0, "IOP852");

        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("IOP852");
        //Deberia soltar error
        carrera.socorrerAuto("XYZ789");


        Vehiculo ganador = carrera.definirGanador();

        if (ganador != null) {
            System.out.println("El ganador es el vehículo con patente: " + ganador.getPatente());
        } else {
            System.out.println("No hay ganador, la carrera está vacía.");
        }
    }

}
