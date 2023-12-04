package org.ejercicio;

import org.ejercicio.modelo.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ExcepcionCarrera {

        Auto autoUno = new Auto(130.0, 50.0, 20.0, "PATENTE 098HJ");
        Moto motoUno = new Moto(100.0, 20.0, 12.0, "PATENTE M98HJ");

        Carrera carrera = new Carrera(200.0, 300000.0, "CARRERA 2023", 2, new ArrayList<>());

        carrera.darDeAltaAuto(autoUno);
        carrera.darDeAltaMoto(motoUno);

        carrera.getSocorristaAuto().socorrer(autoUno);

        System.out.println("El ganador es: " + carrera.obtenerGanador());
        //Excepcion vehiculo no registrado en la carrera:
        carrera.eliminarVehiculo(new Auto(129.0, 3.4, 9.0,"PATENTE 7483J"));


    }
}