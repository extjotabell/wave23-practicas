package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculoList = new ArrayList<>();
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        Carrera carrera = new Carrera(100,100000,"Dakar",3,vehiculoList,socorristaAuto,socorristaMoto);

        System.out.println();

        carrera.darDeAltaAuto(100,100,100,"A1");
        carrera.darDeAltaAuto(80,80,80,"A2");
        carrera.darDeAltaMoto(50,50,50,"M1");
        carrera.darDeAltaMoto(60,60,60,"M2");

        System.out.println();

        carrera.eliminarVehiculo(carrera.getVehiculoList().get(1));

        System.out.println();

        carrera.eliminarVehiculoConPatente("A2");

        System.out.println();

        carrera.determinarGanador();

        System.out.println();

        carrera.socorrerAuto("A1");

        System.out.println();

        carrera.socorrerMoto("M1");

        System.out.println();
    }
}
