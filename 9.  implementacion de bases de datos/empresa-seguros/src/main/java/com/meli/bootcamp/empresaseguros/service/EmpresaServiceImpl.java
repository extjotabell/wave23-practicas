package com.meli.bootcamp.empresaseguros.service;


import com.meli.bootcamp.empresaseguros.dto.VehiculoDto;
import com.meli.bootcamp.empresaseguros.repository.ISiniestroRepo;
import com.meli.bootcamp.empresaseguros.repository.IVehiculoRepo;

import com.meli.bootcamp.empresaseguros.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements IEmpresaService{
    private IVehiculoRepo vehiculoRepo;
    private ISiniestroRepo siniestroRepo;


    public EmpresaServiceImpl(IVehiculoRepo vehiculoRepo, ISiniestroRepo siniestroRepo) {
        this.vehiculoRepo = vehiculoRepo;
        this.siniestroRepo = siniestroRepo;
    }

    @Override
    public List<String> findByPatente() {
        return vehiculoRepo.findByPatente();
    }

    @Override
    public List<?> findByPatenteMarca() {
        return vehiculoRepo.findByPatenteMarca();
    }

    @Override
    public List<VehiculoDto> findByCurrentYear() {
        return vehiculoRepo.findByCurrentYear(java.time.Year.now().getValue())
                .stream()
                .map(vehiculo -> Mapper.mapToVehiculoDto(vehiculo))
                .collect(Collectors.toList());
    }

    @Override
    public List<?> findByPMM() {
        return siniestroRepo.findByPMM();
    }

    @Override
    public List<VehiculoDto> findAll() {
        return vehiculoRepo.findAll()
                .stream()
                .map(vehiculo -> Mapper.mapToVehiculoDto(vehiculo))
                .collect(Collectors.toList());
    }
}
