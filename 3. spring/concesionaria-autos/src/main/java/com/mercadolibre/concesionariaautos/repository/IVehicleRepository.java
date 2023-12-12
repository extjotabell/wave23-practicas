package com.mercadolibre.concesionariaautos.repository;

import com.mercadolibre.concesionariaautos.dto.VehiclesDto;
import com.mercadolibre.concesionariaautos.entity.Vehicle;

import java.util.Date;
import java.util.List;

public interface IVehicleRepository {
    void save(Vehicle vehicle);
    Vehicle getById(Long id) throws Exception;
    VehiclesDto getAll() throws Exception;
    List<Vehicle> filterByDate(Date since, Date to) throws Exception;
    List<Vehicle> filterByPrice(Double since, Double to) throws Exception;
}
