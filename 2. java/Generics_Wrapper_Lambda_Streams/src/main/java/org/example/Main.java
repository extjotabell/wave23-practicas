package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 2

        ArrayList<Vehiculo> listaDeVehiculos = new ArrayList<>();

        Vehiculo v1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo v2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo v3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo v4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo v5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo v6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo v7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo v8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo v9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo v10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo v11 = new Vehiculo("Logan", "Renault", 950);

        listaDeVehiculos.add(v1);
        listaDeVehiculos.add(v2);
        listaDeVehiculos.add(v3);
        listaDeVehiculos.add(v4);
        listaDeVehiculos.add(v5);
        listaDeVehiculos.add(v6);
        listaDeVehiculos.add(v7);
        listaDeVehiculos.add(v8);
        listaDeVehiculos.add(v9);
        listaDeVehiculos.add(v10);
        listaDeVehiculos.add(v11);

        Garaje garajeCool = new Garaje("1", listaDeVehiculos);

        //Ejercicio 3
        System.out.println("Ejercicio 3");
        garajeCool.getListaDeVehiculos().sort(
                (vehiculo1, vehiculo2) -> Integer.compare(vehiculo2.getCosto(), vehiculo1.getCosto()));
        for(Vehiculo vehiculo: garajeCool.getListaDeVehiculos()){
            System.out.println(vehiculo.toString()  );
        };
        System.out.println();

        //Ejercicio 4
        System.out.println("Ejercicio 4");
        garajeCool.getListaDeVehiculos().sort(
                Comparator.comparing(Vehiculo::getMarca));
        for(Vehiculo vehiculo: garajeCool.getListaDeVehiculos()){
            System.out.println(vehiculo.toString());
        };
        System.out.println();

        //Ejercicio 5
        System.out.println("Ejercicio 5");
        System.out.println("Autos con costo menor a 1000: ");
        garajeCool.getListaDeVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);
        System.out.println("Autos con costo mayor o igual a 1000: ");
        garajeCool.getListaDeVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);
        System.out.printf("El promedio de los precios es: %.2f", garajeCool.getListaDeVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());

    }
}
