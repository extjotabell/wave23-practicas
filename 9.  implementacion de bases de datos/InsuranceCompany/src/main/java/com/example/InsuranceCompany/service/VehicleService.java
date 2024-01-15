package com.example.InsuranceCompany.service;

import com.example.InsuranceCompany.dto.*;
import com.example.InsuranceCompany.entity.*;
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
        return vehicles.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
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
        Vehicle vehicle = verifyVehicleExists(id);
        vehicle.setPatent(dto.getPatent());
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setYearOfProduction(dto.getYearOfProduction());
        vehicle.setNumberOfWheels(dto.getNumberOfWheels());
        repository.save(vehicle);
        return mapToDTO(vehicle);
    }

    @Override
    public MessageDTO deleteVehicle(Long id) {
        Vehicle vehicle = verifyVehicleExists(id);
        repository.delete(vehicle);
        return new MessageDTO("Delete vehicle successfully.");
    }

    @Override
    public List<VehiclePatentDTO> getAllPatents() {
        List<VehiclePatent> vehicles = repository.getAllPatents();
        return vehicles.stream()
                .map(this::mapVehiclePatentToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiclePatentBrandDTO> getPatentAndBrandByYearOfManufacture() {
        List<VehiclePatentBrand> vehicles = repository.getPatentAndBrandByYearOfManufacture();
        return vehicles.stream()
                .map(this::mapVehiclePatentBrandToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiclePatentDTO> getPatentByFourWheelsAndManufactureCurrentYear() {
        List<VehiclePatent> vehicles = repository.getPatentByFourWheelsAndManufactureCurrentYear();
        return vehicles.stream()
                .map(this::mapVehiclePatentToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiclePatentBrandModelDTO> getPatentBrandModelByAccidentWithLossGreaterThan10000() {
        List<VehiclePatentBrandModel> vehicles = repository.getPatentBrandModelByAccidentWithLossGreaterThan10000();
        return vehicles.stream()
                .map(this::mapVehiclePatentBrandModelToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiclePatentBrandLossDTO> getVehicleDetailsWithTotalLossGreaterThan10000() {
        List<VehiclePatentBrandLoss> vehicles = repository.getVehicleDetailsWithTotalLossGreaterThan10000();
        return vehicles.stream()
                .map(this::mapVehiclePatentBrandLossToDTO)
                .collect(Collectors.toList());
    }

    private Vehicle verifyVehicleExists(Long id){
        Vehicle vehicle = repository.findById(id).orElse(null);
        if(vehicle == null){
            throw new NotFoundException("Vehicle whit ID " + id + " not exists.");
        }
        return vehicle;
    }

    private VehiclePatentBrandLossDTO mapVehiclePatentBrandLossToDTO(VehiclePatentBrandLoss vehicle){
        VehiclePatentBrandLossDTO vehicleDTO = new VehiclePatentBrandLossDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setPatent(vehicle.getPatent());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setEconomicLoss(vehicle.getEconomicLoss());
        return vehicleDTO;
    }

    private VehiclePatentBrandModelDTO mapVehiclePatentBrandModelToDTO(VehiclePatentBrandModel vehicle){
        VehiclePatentBrandModelDTO vehicleDTO = new VehiclePatentBrandModelDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setPatent(vehicle.getPatent());
        vehicleDTO.setModel(vehicle.getModel());
        return vehicleDTO;
    }

    private VehiclePatentBrandDTO mapVehiclePatentBrandToDTO(VehiclePatentBrand vehicle){
        VehiclePatentBrandDTO vehicleDTO = new VehiclePatentBrandDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setPatent(vehicle.getPatent());
        return vehicleDTO;
    }

    private VehiclePatentDTO mapVehiclePatentToDTO(VehiclePatent vehicle){
        VehiclePatentDTO vehicleDTO = new VehiclePatentDTO();
        vehicleDTO.setPatent(vehicle.getPatent());
        return vehicleDTO;
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
