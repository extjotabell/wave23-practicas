import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>(List.of(
                new Vehiculo("Ford", "Fiesta", 1000.0),
                new Vehiculo("Ford", "Focus", 1200.0),
                new Vehiculo("Ford", "Explorer", 2500.0),
                new Vehiculo("Fiat", "Uno", 500.0),
                new Vehiculo("Fiat", "Cronos", 1000.0),
                new Vehiculo("Fiat", "Torino", 1250.0),
                new Vehiculo("Chevrolet", "Aveo", 1250.0),
                new Vehiculo("Chevrolet", "Spin", 2500.0),
                new Vehiculo("Toyota", "Corola", 1200.0),
                new Vehiculo("Toyota", "Fortuner", 3000.0),
                new Vehiculo("Renault", "Logan", 950.0)
        ));

        Garaje garaje = new Garaje(1, vehiculos);
        System.out.println("\nOrdenados por costo\n");

        vehiculos.sort((a, b) -> a.getCosto().compareTo(b.getCosto()));
        vehiculos.forEach(System.out::println);

        System.out.println("\nOrdenados por marca y por costo\n");
        vehiculos.sort((a, b) -> {
            int comparacion = a.getMarca().compareTo(b.getMarca());
            if (comparacion == 0) {
                return a.getCosto().compareTo(b.getCosto());
            }
            return comparacion;
        });
        vehiculos.forEach(System.out::println);

        System.out.println("\nVehiculos con precio menor o igual a 1000\n");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).forEach(System.out::println);

        System.out.println("\nVehiculos con precio mayor a 1000\n");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() > 1000).forEach(System.out::println);

        System.out.print ("\nPromedio de costo de los vehiculos: ");
        System.out.println(vehiculos.stream().mapToDouble(a -> a.getCosto()).average().stream().findFirst().getAsDouble());
    }
}
