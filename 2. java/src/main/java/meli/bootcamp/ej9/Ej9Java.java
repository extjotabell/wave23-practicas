package meli.bootcamp.ej9;

import meli.bootcamp.ej9.garage.Garage;
import meli.bootcamp.ej9.garage.Vehiculo;

/**
 * Ejercicio 9: Generics + Wrapper + Lambda + Streams - Practica Integradora
 */
public class Ej9Java {
  public static void main(String[] args) {
    Garage garage = new Garage();

    garage.agregarVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
    garage.agregarVehiculo(new Vehiculo("Ford", "Focus", 1200));
    garage.agregarVehiculo(new Vehiculo("Ford", "Explorer", 2500));
    garage.agregarVehiculo(new Vehiculo("Fiat", "Uno", 500));
    garage.agregarVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
    garage.agregarVehiculo(new Vehiculo("Fiat", "Torino", 1250));
    garage.agregarVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
    garage.agregarVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
    garage.agregarVehiculo(new Vehiculo("Toyota", "Corola", 1200));
    garage.agregarVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
    garage.agregarVehiculo(new Vehiculo("Renault", "Logan", 950));

    System.out.println("------------------1------------------");
    garage.vehiculosOrdenadosPorPrecio().forEach(System.out::println);

    System.out.println("------------------2------------------");
    garage.vehiculosOrdenadosPorMarcaYPrecio().forEach(System.out::println);

    System.out.println("------------------3------------------");
    garage.vehiculosConPrecioMenorA(1000.0).forEach(System.out::println);

    System.out.println("------------------4------------------");
    garage.vehiculosConPrecioMayorOIgualA(1000.0).forEach(System.out::println);

    System.out.println("------------------5------------------");
    System.out.println(garage.precioPromedio());
  }
}