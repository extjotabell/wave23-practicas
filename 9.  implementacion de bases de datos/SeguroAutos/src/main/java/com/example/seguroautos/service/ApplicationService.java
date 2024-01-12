package com.example.seguroautos.service;

import com.example.seguroautos.dto.SinisterDTO;
import com.example.seguroautos.dto.VehicleDTO;
import com.example.seguroautos.dto.VehiclePatentDTO;
import com.example.seguroautos.dto.VehiclePatentModelDTO;
import com.example.seguroautos.dto.VehicleSimpleDTO;
import com.example.seguroautos.dto.VehicleSimpleLossDTO;
import com.example.seguroautos.model.Sinister;
import com.example.seguroautos.model.Vehicle;
import com.example.seguroautos.repository.SinisterRepository;
import com.example.seguroautos.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

  private final SinisterRepository sinisterRepository;
  private final VehicleRepository vehicleRepository;

  public ApplicationService(SinisterRepository sinisterRepository,
      VehicleRepository vehicleRepository) {
    this.sinisterRepository = sinisterRepository;
    this.vehicleRepository = vehicleRepository;
  }

  public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
    ObjectMapper mapper = new ObjectMapper();
    vehicleRepository.save(mapper.convertValue(vehicleDTO, Vehicle.class));
    return vehicleDTO;
  }

  public List<VehicleDTO> getVehicles() {
    ObjectMapper mapper = new ObjectMapper();
    return vehicleRepository.findAll().stream()
        .map(vehicle -> mapper.convertValue(vehicle, VehicleDTO.class))
        .collect(Collectors.toList());
  }

  public SinisterDTO createSinisterToVehicle(SinisterDTO sinisterDTO, Integer vehicleId)
      throws NotFoundException {
    ObjectMapper mapper = new ObjectMapper();

    Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(NotFoundException::new);
    Sinister sinister = mapper.convertValue(sinisterDTO, Sinister.class);

    vehicle.getSinisters().add(sinister);
    sinister.setVehicle(vehicle);
    sinisterRepository.save(sinister);
    vehicleRepository.save(vehicle);
    return sinisterDTO;
  }

  public List<VehiclePatentDTO> getAllPatents(){
    return vehicleRepository.getAllPatents();
  }

  public List<VehiclePatentModelDTO> getAllPatentsModelOrderByYear(){
    return vehicleRepository.getAllPatentsModelOrderByYearProduction();
  }

  public List<VehiclePatentDTO> getAllPatentsVehiclesWithNumberWheelsGreater4(){
    return vehicleRepository.getAllPatentsVehiclesWithNumberWheelsGreater4();
  }

  public List<VehicleSimpleDTO> getAllVehiclesWithSinisterEconomicLossGreaterThan10000(){
    return vehicleRepository.getAllVehiclesWithSinisterEconomicLossGreaterThan10000();
  }

  public List<VehicleSimpleLossDTO> getAllVehiclesWithSinisterEconomicLossGreaterThan10000WithLoss(){
    return vehicleRepository.getAllVehiclesWithSinisterEconomicLossGreaterThan10000WithLoss();
  }
}
