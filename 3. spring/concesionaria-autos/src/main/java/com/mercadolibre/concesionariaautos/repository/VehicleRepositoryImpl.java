package com.mercadolibre.concesionariaautos.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.concesionariaautos.dto.VehicleDto;
import com.mercadolibre.concesionariaautos.dto.VehiclesDto;
import com.mercadolibre.concesionariaautos.entity.Vehicle;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();
    private Long id;

    @PostConstruct
    private void postConstruct() {
        this.id = 0L;
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicle.setId(id += 1);
        vehicles.add(vehicle);
    }

    @Override
    public Vehicle getById(Long id) throws Exception {
        return vehicles.stream().filter(vehicle -> id.equals(vehicle.getId()))
                .findFirst()
                .orElseThrow(() -> new Exception("No hay un vehículo asignado al id: " + id));
    }

    @Override
    public VehiclesDto getAll() throws Exception {
        if (vehicles.isEmpty()) {
            throw new Exception("No hay vehiculos cargados");
        }
        List<VehicleDto> list = vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();

        return new VehiclesDto(list);
    }

    @Override
    public List<Vehicle> filterByDate(Date since, Date to) throws Exception {
        List<Vehicle> list = vehicles.stream()
                .filter(vehicle -> vehicle.getManufacturingDate().after(since) &&
                        vehicle.getManufacturingDate().before(to))
                .toList();

        if (list.isEmpty()) {
            throw new Exception("No hay vehiculos que cumplan las condiciones");
        }
        return list;
    }

    @Override
    public List<Vehicle> filterByPrice(Double since, Double to) throws Exception {
        List<Vehicle> list = vehicles.stream()
                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to )
                .toList();

        if (list.isEmpty()) {
            throw new Exception("No hay vehiculos que cumplan las condiciones");
        }
        return list;
    }
}
