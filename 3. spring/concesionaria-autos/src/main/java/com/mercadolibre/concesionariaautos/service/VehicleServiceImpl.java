package com.mercadolibre.concesionariaautos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.concesionariaautos.dto.VehicleDto;
import com.mercadolibre.concesionariaautos.dto.VehiclesDto;
import com.mercadolibre.concesionariaautos.entity.Vehicle;
import com.mercadolibre.concesionariaautos.repository.VehicleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {
    @Autowired
    VehicleRepositoryImpl repository;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void save(VehicleDto vehicle) throws Exception {
        if (vehicle == null) {
            throw new Exception("No se pudo almacenar el vehiculo");
        }
        repository.save(mapper.convertValue(vehicle, Vehicle.class));
    }

    @Override
    public VehiclesDto filterByDate(Date since, Date to) throws Exception {
        List<VehicleDto> list = repository.filterByDate(since, to).stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();

        return new VehiclesDto(list);
    }

    @Override
    public VehiclesDto filterByPrice(Double since, Double to) throws Exception {
        List<VehicleDto> list = repository.filterByPrice(since, to).stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();

        return new VehiclesDto(list);
    }

    @Override
    public VehicleDto findById(Long id) throws Exception {
        Vehicle vehicle = repository.getById(id);
        return mapper.convertValue(vehicle, VehicleDto.class);
    }
}
