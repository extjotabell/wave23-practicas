package com.meli.autos.repository.impl;

import com.meli.autos.entity.Service;
import com.meli.autos.entity.Vehicle;
import com.meli.autos.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {

    private List<Vehicle> vehicles;

    public VehicleRepository(){
        this.loadData();
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    private void loadData() {
        vehicles = new ArrayList<>();
        Service service1 = new Service("2022-01-15", 15000, "Service A");
        Service service2 = new Service("2022-05-20", 25000, "Service B");
        Service service3 = new Service("2022-09-10", 35000, "Service C");


        List<Service> servicesVehicle1 = new ArrayList<>();
        servicesVehicle1.add(service1);
        servicesVehicle1.add(service2);

        List<Service> servicesVehicle2 = new ArrayList<>();
        servicesVehicle2.add(service3);

        Vehicle vehicle1 = new Vehicle(1000,"Toyota", "Camry", LocalDate.parse("2020-01-01"), 20000, 4, 25000.0, "USD", servicesVehicle1, 1);
        Vehicle vehicle2 = new Vehicle(2000,"Honda", "Civic", LocalDate.parse("2019-05-15"), 30000, 4, 22000.0, "USD", servicesVehicle2, 2);
        Vehicle vehicle3 = new Vehicle(3000,"Ford", "Escape", LocalDate.parse("2021-03-20"), 18000, 5, 28000.0, "USD", servicesVehicle1, 1);
        Vehicle vehicle4 = new Vehicle(4000,"Chevrolet", "Malibu", LocalDate.parse("2022-07-05"), 12000, 4, 30000.0, "USD", servicesVehicle2, 1);

        vehicles.addAll(List.of(vehicle1, vehicle2, vehicle3, vehicle4));

    }

}
