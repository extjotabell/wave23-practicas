import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculoList = Arrays.asList(vehiculo1,vehiculo2,vehiculo3,vehiculo4,vehiculo5,vehiculo6,vehiculo7,vehiculo8,vehiculo9,vehiculo10,vehiculo11);

        Garaje garaje = new Garaje(1,vehiculoList);

        //Mostrar lista completa
        garaje.getVehiculoList().stream()
                .forEach(System.out::println);

        //3 - Mostrar lista ordenada de menor a mayor
        System.out.println("Orden precio");
        garaje.getVehiculoList().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        //4 - Mostrar lista ordenada por marca y precio
        System.out.println("Orden marca y precio");
        garaje.getVehiculoList().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        //5 - Mostrar lista precios < 1000
        System.out.println("Precios < 1000");
        garaje.getVehiculoList().stream()
                .filter(vehiculo -> vehiculo.getCosto()<1000)
                .forEach(System.out::println);

        //5 - Mostrar lista precios >= 1000
        System.out.println("Precios >= 1000");
        garaje.getVehiculoList().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);

        //5 - Mostrar lista promedio precios
        System.out.print("Promedio precios: ");
        garaje.getVehiculoList().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Prueba mostrar lista ordenada de mayor a menor");
        garaje.getVehiculoList().stream().sorted(Comparator.comparing(Vehiculo::getCosto).reversed()).forEach(System.out::println);

    }
}
