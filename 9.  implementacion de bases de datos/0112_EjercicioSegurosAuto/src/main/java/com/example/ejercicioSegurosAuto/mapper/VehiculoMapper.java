package com.example.ejercicioSegurosAuto.mapper;

import com.example.ejercicioSegurosAuto.dto.response.VehiculoPatenteMarcaModeloResponseDto;
import com.example.ejercicioSegurosAuto.dto.response.VehiculoPatenteMarcaResponseDto;
import com.example.ejercicioSegurosAuto.dto.response.VehiculoPatenteResponseDto;
import com.example.ejercicioSegurosAuto.model.Vehiculo;

public class VehiculoMapper {

    public VehiculoMapper(){

    }

    public VehiculoPatenteResponseDto mapToVehiculoPatenteReponseDto(Vehiculo vehiculo){
        return new VehiculoPatenteResponseDto(
                vehiculo.getId(),
                vehiculo.getPatente()
        );
    }

    public VehiculoPatenteMarcaResponseDto mapToVehiculoPatenteMarcaResponseDto(Vehiculo vehiculo){
        return new VehiculoPatenteMarcaResponseDto(
                vehiculo.getId(),
                vehiculo.getPatente(),
                vehiculo.getMarca()
        );
    }

    public VehiculoPatenteMarcaModeloResponseDto mapToVehiculoPatenteMarcaModeloResponseDto(Vehiculo vehiculo){
        return new VehiculoPatenteMarcaModeloResponseDto(
                vehiculo.getId(),
                vehiculo.getPatente(),
                vehiculo.getMarca(),
                vehiculo.getModelo()
        );
    }

}
