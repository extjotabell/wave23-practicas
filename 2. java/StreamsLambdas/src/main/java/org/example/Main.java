package org.example;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Auto> lista = new ArrayList<>();
        lista.add(new Auto("Ford","Fiesta",1000));
        lista.add(new Auto("Ford","Focus",1200));
        lista.add(new Auto("Ford","Explorer",2500));
        lista.add(new Auto("Fiat","Uno",500));
        lista.add(new Auto("Fiat","Cronos",1000));
        lista.add(new Auto("Fiat","Torino",1250));
        lista.add(new Auto("Chevrolet","Aveo",1250));
        lista.add(new Auto("Chevrolet","Spin",2500));
        lista.add(new Auto("Toyota","Corola",1200));
        lista.add(new Auto("Toyota","Fortuner",3000));
        lista.add(new Auto("Renault","Logan",950));
        Garage garage = new Garage(1,lista);

        System.out.println("------Lista ordenada del menor a mayor precio-------");
        lista.stream().sorted(Comparator.comparing(Auto::getCosto)).forEach(System.out::println);
        System.out.println(" ");

        System.out.println("------Lista ordenada por marca y del menor a mayor precio-------");
        Comparator<Auto> marca_precio = Comparator.comparing(Auto::getMarca).thenComparing(Auto::getCosto);
        lista.stream().sorted(marca_precio).forEach(System.out::println);
        System.out.println(" ");

        System.out.println("------Lista de autos con costo menor a 1000-------");
        lista.stream().filter(auto ->auto.getCosto()<1000).forEach(System.out::println);
        System.out.println(" ");

        System.out.println("------Lista de autos con costo mayor o igual a 1000-------");
        lista.stream().filter(auto ->auto.getCosto()>=1000).forEach(System.out::println);
        System.out.println(" ");

        System.out.println("------Costo promedio de los autos-------");
        OptionalDouble sum = lista.stream().mapToDouble(Auto::getCosto).average();
        System.out.println(sum);

    }
}