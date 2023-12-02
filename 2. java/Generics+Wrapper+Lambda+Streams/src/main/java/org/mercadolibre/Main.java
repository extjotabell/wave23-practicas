package org.mercadolibre;

import org.mercadolibre.model.Vehicle;
import org.mercadolibre.model.Garage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Garage garage = getGarage();

        System.out.println("Lista de vehículos en el garage:");
        garage.toList();

        System.out.println("**********************************");
        System.out.println("Lista de vehículos ordenados por precio en el garage:");
        garage.getVehiclesOrderedByPrice();

        System.out.println("**********************************");
        System.out.println("Lista de vehículos ordenados por marca y por precio en el garage:");
        garage.toListByBrandAndPrice();

        System.out.println("**********************************");
        System.out.println("Lista de vehículos con precio no mayor a 1000 en el garage:");
        garage.toListPriceLessThanThousand();

        System.out.println("**********************************");
        System.out.println("Lista de vehículos con precio mayor o igual a 1000 en el garage:");
        garage.toListPriceGreaterThanOrEqualToThousand();

        System.out.println("**********************************");
        garage.averageTotal();
    }

    private static Garage getGarage() {
        List<Vehicle> vehicles = new ArrayList<>(Arrays.asList(
                new Vehicle("Fiesta", "Ford", 1000),
                new Vehicle("Focus", "Ford", 1200),
                new Vehicle("Explorer", "Ford", 2500),
                new Vehicle("Uno", "Fiat", 500),
                new Vehicle("Cronos", "Fiat", 1000),
                new Vehicle("Torino", "Fiat", 1250),
                new Vehicle("Aveo", "Chevrolet", 1250),
                new Vehicle("Spin", "Chevrolet", 2500),
                new Vehicle("Corola", "Toyota", 1200),
                new Vehicle("Fortuner", "Toyota", 3000),
                new Vehicle("Logan", "Renault", 950)
        ));

        return new Garage(1, vehicles);
    }
}