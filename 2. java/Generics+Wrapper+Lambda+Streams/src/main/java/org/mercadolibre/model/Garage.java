package org.mercadolibre.model;

import java.util.Comparator;
import java.util.List;

public class Garage {
    private int id;
    List<Vehicle> vehicles;

    public Garage(int id, List<Vehicle> vehicles) {
        this.id = id;
        this.vehicles = vehicles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void toList() {
        vehicles.forEach(vehicle ->
                System.out.println("Modelo: " + vehicle.getModel() + ", Marca: " +
                        vehicle.getBrand() + ", Costo: " + vehicle.getCost())
        );
    }

    public void getVehiclesOrderedByPrice() {
        vehicles.stream()
                .sorted(Comparator.comparingDouble(Vehicle::getCost))
                .forEach(vehicle ->
                        System.out.println("Modelo: " + vehicle.getModel() + ", Marca: " +
                                vehicle.getBrand() + ", Costo: " + vehicle.getCost())
                );
    }

    public void toListByBrandAndPrice() {
        vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getBrand).thenComparingDouble(Vehicle::getCost))
                .forEach(vehicle ->
                        System.out.println("Modelo: " + vehicle.getModel() + ", Marca: " +
                                vehicle.getBrand() + ", Costo: " + vehicle.getCost())
                );
    }

    public void toListPriceLessThanThousand() {
        vehicles.stream()
                .filter(vehicle -> vehicle.getCost() < 1000.0)
                .forEach(vehicle ->
                        System.out.println("Modelo: " + vehicle.getModel() + ", Marca: " +
                                vehicle.getBrand() + ", Costo: " + vehicle.getCost())
                );
    }

    public void toListPriceGreaterThanOrEqualToThousand() {
        vehicles.stream()
                .filter(vehicle -> vehicle.getCost() >= 1000)
                .forEach(vehicle ->
                        System.out.println("Modelo: " + vehicle.getModel() + ", Marca: " +
                                vehicle.getBrand() + ", Costo: " + vehicle.getCost())
                );
    }

    public void averageTotal() {
        double average = vehicles.stream()
                .mapToDouble(Vehicle::getCost)
                .average()
                .orElse(0);
        System.out.println("Promedio total de precios en el garage: " + String.format("%.2f", average));
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}