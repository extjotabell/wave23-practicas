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

        List<Vehiculo> vehiculos = Arrays.asList(vehiculo1, vehiculo2, vehiculo3, vehiculo4,
                vehiculo5, vehiculo6, vehiculo7, vehiculo8, vehiculo9, vehiculo10,  vehiculo11);

        Garage garage = new Garage(1, vehiculos);


        System.out.println("------Lista Original------");
        ShowList.listDetailed(garage.listaVehiculo);
        System.out.println();

        System.out.println("-------Lista ordenada por precio------");
        garage.listaVehiculo.stream().
                sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("-------Lista ordenada por marca y precio------");
        garage.listaVehiculo.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

       System.out.println();
        System.out.println("-------Lista ordenada por precio no mayor a 1000------");
        garage.listaVehiculo.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);

        System.out.println();
        System.out.println("-------Lista ordenada por precio mayor o igual a 1000------");
        garage.listaVehiculo.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);

        System.out.println();
        System.out.println("-------Promedio total de precios de todos los vehículos------");
        garage.listaVehiculo.stream().mapToDouble(Vehiculo::getCosto).average().stream().forEach(System.out::println);


    }


}
