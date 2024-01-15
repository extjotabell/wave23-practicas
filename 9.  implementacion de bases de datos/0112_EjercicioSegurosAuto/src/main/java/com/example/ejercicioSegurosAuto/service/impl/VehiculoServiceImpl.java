package com.example.ejercicioSegurosAuto.service.impl;

import com.example.ejercicioSegurosAuto.dto.response.VehiculoPatenteMarcaModeloResponseDto;
import com.example.ejercicioSegurosAuto.dto.response.VehiculoPatenteMarcaResponseDto;
import com.example.ejercicioSegurosAuto.dto.response.VehiculoPatenteResponseDto;
import com.example.ejercicioSegurosAuto.dto.response.VehiculoTotalSiniestrosResponseDto;
import com.example.ejercicioSegurosAuto.mapper.VehiculoMapper;
import com.example.ejercicioSegurosAuto.repository.IVehiculoRepository;
import com.example.ejercicioSegurosAuto.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoPatenteResponseDto> findPatentes() {
        VehiculoMapper vehiculoMapper = new VehiculoMapper();
        return vehiculoRepository.findPatentes()
                .stream()
                .map(vehiculoMapper::mapToVehiculoPatenteReponseDto)
                .toList();
    }

    @Override
    public List<VehiculoPatenteMarcaResponseDto> findPatentesMarcas() {
        VehiculoMapper vehiculoMapper = new VehiculoMapper();
        return vehiculoRepository.findPatentesMarcas()
                .stream()
                .map(vehiculoMapper::mapToVehiculoPatenteMarcaResponseDto)
                .toList();
    }

    @Override
    public List<VehiculoPatenteResponseDto> findPatenteByCurrentYear() {
        VehiculoMapper vehiculoMapper = new VehiculoMapper();
        return vehiculoRepository.findPatenteByCurrentYear()
                .stream()
                .map(vehiculoMapper::mapToVehiculoPatenteReponseDto)
                .toList();
    }

    @Override
    public List<VehiculoPatenteMarcaModeloResponseDto> findSiniestroGreaterThan10000() {
        VehiculoMapper vehiculoMapper = new VehiculoMapper();
        return vehiculoRepository.findSiniestroGreaterThan10000()
                .stream()
                .map(vehiculoMapper::mapToVehiculoPatenteMarcaModeloResponseDto)
                .toList();
    }

    @Override
    public List<VehiculoTotalSiniestrosResponseDto> findTotalMayor10000() {
        return vehiculoRepository.findTotalMayor10000();
    }
}
