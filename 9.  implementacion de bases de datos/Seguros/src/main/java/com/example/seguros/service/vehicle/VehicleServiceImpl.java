package com.example.seguros.service.vehicle;

import com.example.seguros.dto.VehicleRequestDTO;
import com.example.seguros.dto.VehicleResponseDTO;
import com.example.seguros.model.Vehicle;
import com.example.seguros.repository.VehicleRepository;
import com.example.seguros.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void postVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = DTOMapper.mapToVehicle(vehicleRequestDTO);
        vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleResponseDTO> findAll() {
        return vehicleRepository.findAll().stream().map(DTOMapper::mapToVehicleResponseDTO).toList();
    }

    @Override
    public List<String> findAllPatents() {
        return vehicleRepository.findAllPatents();
    }

    @Override
    public List<Object[]> findAllPatentsAndBrand() {
        return vehicleRepository.findAllPatentsAndBrand();
    }

    @Override
    public List<VehicleResponseDTO> findAllByCurrentYear() {
        return vehicleRepository.findAllByCurrentYear(java.time.Year.now().getValue())
                .stream().map(DTOMapper::mapToVehicleResponseDTO).toList();
    }

    @Override
    public List<VehicleResponseDTO> findAllByCostGreaterThan(Double cost) {
        return vehicleRepository.findAllByCostGreaterThan(cost)
                .stream().map(DTOMapper::mapToVehicleResponseDTO).toList();
    }


}
