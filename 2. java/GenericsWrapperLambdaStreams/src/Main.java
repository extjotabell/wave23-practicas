import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(new ArrayList<>(List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        )));

        System.out.println("Ejercicio 3");
        // Ejercicio 3
        List<Vehiculo> vehiculosOrdenadosXPrecio = garage.getVehiculos().stream()
                        .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                        .toList();

        for (Vehiculo vehiculo : vehiculosOrdenadosXPrecio) {
            System.out.println(vehiculo.toString());
        }

        // Ejercicio 4
        System.out.println();
        System.out.println("Ejercicio 4");

        List<Vehiculo> copiaVehiculos = new ArrayList<>(garage.getVehiculos());
        copiaVehiculos
                .sort(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparingDouble(Vehiculo::getCosto));

        for (Vehiculo vehiculo : copiaVehiculos) {
            System.out.println(vehiculo.toString());
        }

        // Ejercicio 5
        System.out.println();
        System.out.println("Ejercicio 5");

        System.out.println("Vehículos con valor menor a 1000");
        // Lista de vehiculos con valor menor a 1000
        garage.getVehiculos().stream().filter(x -> x.getCosto() < 1000).forEach(System.out::println);

        System.out.println();
        System.out.println("Vehículos con valor mayor o igual a 1000");
        // Lista de vehiculos con valor mayor a 1000
        garage.getVehiculos().stream().filter(x -> x.getCosto() >= 1000).forEach(System.out::println);

        System.out.println();
        System.out.println("Promedio del valor de los vehículos");
        // Promedio total de precios
        OptionalDouble promedio;
        promedio = garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average();

        if(promedio.isPresent()){
            System.out.println("El promedio es de "+ promedio.getAsDouble());
        }else{
            System.out.println("No se pudo calcular el promedio");
        }
    }
}