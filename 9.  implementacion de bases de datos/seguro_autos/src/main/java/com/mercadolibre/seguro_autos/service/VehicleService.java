package com.mercadolibre.seguro_autos.service;

import com.mercadolibre.seguro_autos.dto.VehiclePatentBrandDTO;
import com.mercadolibre.seguro_autos.dto.VehiclePatentBrandModelDTO;
import com.mercadolibre.seguro_autos.dto.VehiclePatentDTO;
import com.mercadolibre.seguro_autos.dto.VehicleWithLostDTO;
import com.mercadolibre.seguro_autos.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    private final VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehiclePatentDTO> getAllPatents() {
        return vehicleRepository.getAllPatents();
    }

    @Override
    public List<VehiclePatentBrandDTO> getPatentsAndBrand() {
        return vehicleRepository.getPatentsAndBrand();
    }

    @Override
    public List<VehiclePatentDTO> getPatentsFilter() {
        return vehicleRepository.getPatentsFilter();
    }

    @Override
    public List<VehiclePatentBrandModelDTO> getVehiclesWithSinisterFilter() {
        return vehicleRepository.getVehiclesWithSinisterFilter();
    }

    @Override
    public List<VehicleWithLostDTO> getSumVehiclesWithSinisterFilter() {
        return vehicleRepository.getSumVehiclesWithSinisterFilter();
    }
}
