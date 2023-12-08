package org.example;

import org.example.modelo.Carrera;
import org.example.modelo.Vehiculo;

public class Main {
    public static void main(String[] args) {
        //NUEVA CARRETA
        Carrera carrera = new Carrera(300.0, 1500.0, "Carrera Santiago", 4);
        //ALTA DE VEHICULOS
        carrera.darDeAltaAuto(150.0, 10.0, 30.0, "ABC123");
        carrera.darDeAltaMoto(120.0, 8.0, 25.0, "XYZ789");
        carrera.darDeAltaAuto(200.0, 15.0, 40.0, "QWE456");
        carrera.darDeAltaMoto(100.0, 5.0, 20.0, "IOP852");
        System.out.println("Lista de vehiculos en carreta:" +  carrera.getListaDeVehiculos());

        //SOCORRER
        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("IOP852");
        System.out.println("Lista de vehiculos en carreta:" +  carrera.getListaDeVehiculos());

        //SOCORRER INVALIDO
        carrera.socorrerAuto("XYZ789");

        //ELIMINAR CON PATENTE
        carrera.eliminarVehiculoConPatente("XYZ789");
        System.out.println("Lista de vehiculos en carreta:" +  carrera.getListaDeVehiculos());

        //DEFINIR GANADOR
        Vehiculo ganador = carrera.definirGanador();
        if (ganador != null) {
            System.out.println("El ganador es el vehículo con patente: " + ganador.getPatente());
        } else {
            System.out.println("No hay ganador, la carrera está vacía");
        }
    }
}