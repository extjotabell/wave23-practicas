import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear lista de vehiculos

        List<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(
            new Vehiculo("Fiesta", "Ford", 1000),
            new Vehiculo("Focus", "Ford", 1200),
            new Vehiculo("Explorer", "Ford", 2500),
            new Vehiculo("Uno", "Fiat", 500),
            new Vehiculo("Cronos", "Fiat", 1000),
            new Vehiculo("Torino", "Fiat", 1250),
            new Vehiculo("Aveo", "Chevrolet", 1250),
            new Vehiculo("Spin", "Chevrolet", 2500),
            new Vehiculo("Corola", "Toyota", 1200),
            new Vehiculo("Fortuner", "Toyota", 3000),
            new Vehiculo("Logan", "Renault", 950)
        ));

        // Ordenar por precio menor a mayor
        System.out.println("---------- Por precio menor a mayor ----------");

        vehiculos.stream()
            .sorted(Comparator.comparingInt(Vehiculo::getPrecio))
            .forEach(System.out::println);

        // Ordenar por marca y luego por precio menor a mayor
        System.out.println("\n---------- Por marca y precio menor a mayor ----------");

        vehiculos.stream()
            .sorted((v1, v2) -> {
                if (v1.getMarca().compareTo(v2.getMarca()) == 0) {
                    return v1.getPrecio().compareTo(v2.getPrecio());
                } else {
                    return v1.getMarca().compareTo(v2.getMarca());
                }
            })
            .forEach(System.out::println);

        // Filtrar por precio menor a 1000 y mayor a 1000

        List<Vehiculo> menores1000 = vehiculos.stream()
            .filter(v -> v.getPrecio() <= 1000)
            .toList();

        List<Vehiculo> mayores1000 = vehiculos.stream()
            .filter(v -> v.getPrecio() > 1000)
            .toList();

        // Impresion de listas filtradas
        System.out.println("\n---------- Precio menor o igual a 1000 ----------");

        menores1000.forEach(System.out::println);

        System.out.println("\n---------- Precio mayor a 1000 ----------");

        mayores1000.forEach(System.out::println);

        // Obtener el promedio de los precios de los vehiculos
        System.out.println("\n---------- Promedio de precios ----------");

        vehiculos.stream()
            .mapToInt(Vehiculo::getPrecio)
            .average()
            .ifPresent(av -> System.out.println("$" + String.format("%.2f", av)));
    }
}
