package com.meli.SeguroAutos.service;

import com.meli.SeguroAutos.dto.ResponseDTO;
import com.meli.SeguroAutos.dto.VehicleRequestDTO;
import com.meli.SeguroAutos.entity.Vehicle;
import com.meli.SeguroAutos.repository.VehicleRepository;
import com.meli.SeguroAutos.util.mapper.VehicleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public ResponseDTO createVehicle(VehicleRequestDTO vehicleRequestDTO) {
        vehicleRepository.save(VehicleMapper.mapToVehicle(vehicleRequestDTO));
        return new ResponseDTO("The vehicle has been created.");
    }

    public List<String> findPatentAllVehicles(){
        return vehicleRepository.findPatentsAllVehicles();
    }
}
