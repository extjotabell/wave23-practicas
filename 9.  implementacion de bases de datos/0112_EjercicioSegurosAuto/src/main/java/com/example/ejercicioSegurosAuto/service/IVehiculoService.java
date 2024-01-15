package com.example.ejercicioSegurosAuto.service;

import com.example.ejercicioSegurosAuto.dto.response.VehiculoPatenteMarcaModeloResponseDto;
import com.example.ejercicioSegurosAuto.dto.response.VehiculoPatenteMarcaResponseDto;
import com.example.ejercicioSegurosAuto.dto.response.VehiculoPatenteResponseDto;
import com.example.ejercicioSegurosAuto.dto.response.VehiculoTotalSiniestrosResponseDto;

import java.util.List;

public interface IVehiculoService {

    public List<VehiculoPatenteResponseDto> findPatentes();
    public List<VehiculoPatenteMarcaResponseDto> findPatentesMarcas();
    public List<VehiculoPatenteResponseDto> findPatenteByCurrentYear();
    public List<VehiculoPatenteMarcaModeloResponseDto> findSiniestroGreaterThan10000();
    public List<VehiculoTotalSiniestrosResponseDto> findTotalMayor10000();

}
