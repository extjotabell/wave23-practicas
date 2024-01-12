package com.example.seguros.service.accident;

import com.example.seguros.dto.AccidentRequestDTO;
import com.example.seguros.dto.AccidentResponseDTO;
import com.example.seguros.model.Accident;
import com.example.seguros.model.Vehicle;
import com.example.seguros.repository.AccidentRepository;
import com.example.seguros.repository.VehicleRepository;
import com.example.seguros.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentRepository;
    private final VehicleRepository vehicleRepository;

    public AccidentServiceImpl(AccidentRepository accidentRepository, VehicleRepository vehicleRepository) {
        this.accidentRepository = accidentRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void postAccident(AccidentRequestDTO accidentRequestDTO) {
        Vehicle vehicle = vehicleRepository.findById(accidentRequestDTO.getVehicleId()).orElseThrow();
        Accident accident = DTOMapper.mapToAccident(accidentRequestDTO, vehicle);
        accidentRepository.save(accident);
    }

    @Override
    public List<AccidentResponseDTO> findAll() {
        return accidentRepository.findAll().stream().map(DTOMapper::mapToAccidentResponseDTO).toList();
    }
}
