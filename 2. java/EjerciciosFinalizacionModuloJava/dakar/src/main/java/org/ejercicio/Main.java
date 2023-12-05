package org.ejercicio;

import org.ejercicio.modelo.Auto;
import org.ejercicio.modelo.Carrera;
import org.ejercicio.modelo.Moto;
import org.ejercicio.modelo.Vehiculo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Auto autoUno = new Auto(130.0, 50.0, 20.0, "PATENTE 098HJ");
        Moto motoUno = new Moto(100.0, 20.0, 12.0, "PATENTE M98HJ");

        Carrera carrera = new Carrera(200.0, 300000.0, "CARRERA 2023", 2, new ArrayList<>());

        carrera.darDeAltaAuto(autoUno);
        carrera.darDeAltaMoto(motoUno);

        System.out.println("El ganador es" + carrera.obtenerGanador());

    }
}