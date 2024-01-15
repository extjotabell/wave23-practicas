package com.mercadolibre.companyautoinsurance.services.impl;

import com.mercadolibre.companyautoinsurance.exceptions.ResourceNotFoundException;
import com.mercadolibre.companyautoinsurance.models.dtos.AccidentDTO;
import com.mercadolibre.companyautoinsurance.models.entities.Accident;
import com.mercadolibre.companyautoinsurance.models.entities.Vehicle;
import com.mercadolibre.companyautoinsurance.repositories.IAccidentRepository;
import com.mercadolibre.companyautoinsurance.repositories.IVehicleRepository;
import com.mercadolibre.companyautoinsurance.services.IAccidentService;
import com.mercadolibre.companyautoinsurance.utils.Mapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccidentServiceImpl implements IAccidentService {

    private final IAccidentRepository accidentRepository;
    private final IVehicleRepository vehicleRepository;

    public AccidentServiceImpl(IAccidentRepository eventRepository, IVehicleRepository vehicleRepository) {
        this.accidentRepository = eventRepository;
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Save a new accident, this method verify if the vehicle exist with the id passed in the accidentDTO and then save the accident
     */

    @Override
    @Transactional
    public AccidentDTO saveAccident(AccidentDTO accidentDTO) {
        if (accidentDTO.getVehicleId() == null) {
            throw new IllegalArgumentException("Vehicle id must not be null");
        }
        Accident accident = Mapper.mapToAccident(accidentDTO);
        Vehicle vehicle = vehicleRepository.findById(accidentDTO.getVehicleId())
                .orElseThrow(ResourceNotFoundException::new);
        accident.setVehicle(vehicle);
        accident = accidentRepository.save(accident);
        return Mapper.mapToAccidentDTO(accident);
    }
}
