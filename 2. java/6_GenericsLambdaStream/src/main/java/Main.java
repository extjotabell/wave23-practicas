import java.util.Comparator;

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

        Garaje garaje = new Garaje("1111");
        garaje.agregarVehiculo(vehiculo1);
        garaje.agregarVehiculo(vehiculo2);
        garaje.agregarVehiculo(vehiculo3);
        garaje.agregarVehiculo(vehiculo4);
        garaje.agregarVehiculo(vehiculo5);
        garaje.agregarVehiculo(vehiculo6);
        garaje.agregarVehiculo(vehiculo7);
        garaje.agregarVehiculo(vehiculo8);
        garaje.agregarVehiculo(vehiculo9);
        garaje.agregarVehiculo(vehiculo10);
        garaje.agregarVehiculo(vehiculo11);

        System.out.println("Vehículos ordenados de menor a mayor precio");
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println();

        System.out.println("Vehículos ordenados por marca y luego por precio de menor a mayor");
        garaje.getVehiculos().stream()
                .sorted(
                        Comparator
                                .comparing(Vehiculo::getMarca)
                                .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Vehículos con precio menor a 1000:");
        garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Vehículos con precio mayor o igual a 1000:");
        garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .forEach(System.out::println);
        System.out.println();


        System.out.println("Promedio de costos: " + garaje.getVehiculos().stream().mapToInt(Vehiculo::getCosto).average().orElse(-1));

    }
}
