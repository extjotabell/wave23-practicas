package org.example;
import org.example.clases.Garaje;
import org.example.clases.Vehiculo;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = List.of(
                new Vehiculo("Ford", "Fiesta", 1000.0),
                new Vehiculo("Ford", "Focus", 1200.0),
                new Vehiculo("Ford", "Explorer", 2500.0),
                new Vehiculo("Fiat", "Uno", 500.0),
                new Vehiculo("Fiat", "Cronos", 1000.0),
                new Vehiculo("Fiat", "Torino", 1250.0),
                new Vehiculo("Chevrolet", "Aveo", 1250.0),
                new Vehiculo("Chevrolet", "Spin", 2500.0),
                new Vehiculo("Toyota", "Fortuner", 3000.0),
                new Vehiculo("Renault", "Logan", 950.0)
        );

        Garaje garaje = new Garaje(1,vehiculos);

        System.out.println("Lista de Vehiculos ordanada por precio");
        garaje.getVehiculos().stream()
                .sorted((x, x2) -> x.getCosto().compareTo(x2.getCosto()))
                .forEach(System.out::println);

        System.out.println("Lista de Vehiculos ordanada marca y precio");
        garaje.getVehiculos().stream()
                .sorted((x, x2) -> {
                    int resultado = x.getMarca().compareTo(x2.getMarca());
                    if (resultado == 0) {
                        resultado = x.getCosto().compareTo(x2.getCosto());
                    }
                    return resultado;
                })
                .forEach(System.out::println);

        System.out.println("Lista de Vehiculos con precio no mayor a 1000");
        garaje.getVehiculos().stream()
                .filter(x -> x.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("Lista de Vehiculos con precio mayor o igual a 1000");
        garaje.getVehiculos().stream()
                .filter(x -> x.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("Promedio total de precios de la lista de vehiculos");
        OptionalDouble promedio = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average();

        if (promedio.isPresent()) {
            System.out.println(promedio.getAsDouble());
        } else {
            System.out.println("No hay vehículos en la lista.");
        }
    }
}