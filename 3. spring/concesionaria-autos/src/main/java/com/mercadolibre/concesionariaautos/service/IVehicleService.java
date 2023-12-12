package com.mercadolibre.concesionariaautos.service;

import com.mercadolibre.concesionariaautos.dto.VehicleDto;
import com.mercadolibre.concesionariaautos.dto.VehiclesDto;

import java.util.Date;

public interface IVehicleService {
    void save(VehicleDto vehicle) throws Exception;
    VehiclesDto filterByDate(Date since, Date to) throws Exception;
    VehiclesDto filterByPrice(Double since, Double to) throws Exception;
    VehicleDto findById(Long id) throws Exception;
}
