package com.meli.ejercicioSiniestros.service;

import com.meli.ejercicioSiniestros.dto.VehiculoFullDTO;
import com.meli.ejercicioSiniestros.dto.request.VehiculoCreationDTO;
import com.meli.ejercicioSiniestros.model.Vehiculo;
import com.meli.ejercicioSiniestros.repository.IVehiculoRepository;
import com.meli.ejercicioSiniestros.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    private final IVehiculoRepository repository;

    public VehiculoService(IVehiculoRepository repository) {
        this.repository = repository;
    }

    public VehiculoFullDTO createVehiculo(VehiculoCreationDTO vehiculoDto){
        Vehiculo vehiculo = Mapper.mapVehiculoCreationToVehiculo(vehiculoDto);
        Vehiculo result =  repository.save(vehiculo);
        return Mapper.mapVehiculoToVehiculoFull(result);
    }

    public List<VehiculoFullDTO> getAllVehicles(){
        return repository.findAll().stream().map(Mapper::mapVehiculoToVehiculoFull).toList();
    }

    public List<String> getAllPatentes(){
        return repository.getAllVehiculos();
    }

    public List<String[]> getPatenteYMarcaFromVehiculo(){
        return repository.getPatenteYMarcaFromVehiculo();
    }

    public List<String[]> getAllVehiculosWithMoreThanFourWheelsAndFabricatedThisYear(){
        return repository.getAllVehiculosWithMoreThanFourWheelsAndFabricatedThisYear();
    }

    public List<String[]> getVehiculosWithSiniestroCostingMoreThanTenThousand(){
        return repository.getVehiculosWithSiniestroCostingMoreThanTenThousand();
    }
}
