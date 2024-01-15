package com.example.InsuranceCompany.service;

import com.example.InsuranceCompany.dto.MessageDTO;
import com.example.InsuranceCompany.dto.VehicleDTO;
import com.example.InsuranceCompany.entity.Vehicle;
import com.example.InsuranceCompany.exception.NotFoundException;
import com.example.InsuranceCompany.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{

    @Autowired
    IVehicleRepository repository;

    @Override
    public List<VehicleDTO> getVehicles() {
        List<Vehicle> vehicles = repository.findAll();
        return entityToDTO(vehicles);
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        Vehicle vehicle = verifyVehicleExists(id);
        return mapToDTO(vehicle);
    }

    @Override
    public MessageDTO addvehicle(VehicleDTO vehicle) {
        Vehicle vehicle1 = mapToEntity(vehicle);
        repository.save(vehicle1);
        return new MessageDTO("Vehicle added successfully.");
    }

    @Override
    public VehicleDTO updateVehicle(Long id, VehicleDTO dto) {
        verifyVehicleExists(id);
        repository.save(mapToEntity(dto));
        return dto;
    }

    @Override
    public MessageDTO deleteVehicle(Long id) {
        Vehicle vehicle = verifyVehicleExists(id);
        repository.delete(vehicle);
        return new MessageDTO("Delete vehicle successfully.");
    }

    private Vehicle verifyVehicleExists(Long id){
        Vehicle vehicle = repository.findById(id).orElse(null);
        if(vehicle == null){
            throw new NotFoundException("Vehicle whit ID " + id + " not exists.");
        }
        return vehicle;
    }

    private List<VehicleDTO> entityToDTO(List<Vehicle> vehicles) {
        return vehicles.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private VehicleDTO mapToDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setPatent(vehicle.getPatent());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setYearOfProduction(vehicle.getYearOfProduction());
        dto.setNumberOfWheels(vehicle.getNumberOfWheels());

        return dto;
    }

    private Vehicle mapToEntity(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setPatent(dto.getPatent());
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setYearOfProduction(dto.getYearOfProduction());
        vehicle.setNumberOfWheels(dto.getNumberOfWheels());

        return vehicle;
    }
}
