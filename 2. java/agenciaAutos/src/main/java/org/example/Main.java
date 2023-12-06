package org.example;

import org.example.model.*;

public class Main {
    public static void main(String[] args) {
        IVehiculo vehiculo1 = new ManillasCromadas(
                new ChapaProtectora(new RinesDeLujo(new VidrioReforzado(new VehiculoBase(100.0,"lanos", "Estandar")))));

        IVehiculo vehiculo2 = new ManillasCromadas(
                new VidrioReforzado(new VehiculoBase(100.0, "corsa", "Estandar")));

        IVehiculo vehiculo3 = new ChapaProtectora(new VehiculoBase(100.0, "cronos", "Estadar"));

        System.out.println("El vehiculo1, tiene precio de " + vehiculo1.getPrecio() + " con accesorios: " + vehiculo1.getAccesorios());
        System.out.println("El vehiculo2, tiene precio de " + vehiculo2.getPrecio() + " con accesorios: " + vehiculo2.getAccesorios());
        System.out.println("El vehiculo3, tiene precio de " + vehiculo3.getPrecio() + " con accesorios: " + vehiculo3.getAccesorios());
    }
}