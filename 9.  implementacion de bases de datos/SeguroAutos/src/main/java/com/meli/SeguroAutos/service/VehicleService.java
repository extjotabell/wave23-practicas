package com.meli.SeguroAutos.service;

import com.meli.SeguroAutos.dto.ResponseDTO;
import com.meli.SeguroAutos.dto.VehicleRequestDTO;
import com.meli.SeguroAutos.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {

    ResponseDTO createVehicle(VehicleRequestDTO vehicleRequestDTO);

    List<String> findPatentAllVehicles();

}
