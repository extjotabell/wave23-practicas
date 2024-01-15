package com.meli.SeguroAutos.service;

import com.meli.SeguroAutos.dto.AccidentRequestDTO;
import com.meli.SeguroAutos.dto.ResponseDTO;
import com.meli.SeguroAutos.repository.AccidentRepository;
import com.meli.SeguroAutos.repository.VehicleRepository;
import com.meli.SeguroAutos.util.mapper.AccidentMapper;
import org.springframework.stereotype.Service;

@Service
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentRepository;

    private final VehicleRepository vehicleRepository;

    public AccidentServiceImpl(AccidentRepository accidentRepository, VehicleRepository vehicleRepository){
        this.accidentRepository = accidentRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public ResponseDTO createAccident(AccidentRequestDTO accidentRequestDTO, Long idVehicle) {

        accidentRepository.save(AccidentMapper.mapToAccident(accidentRequestDTO, vehicleRepository.findById(idVehicle)
                .orElse(null)));
        return new ResponseDTO("The accident has been created.");
    }
}
