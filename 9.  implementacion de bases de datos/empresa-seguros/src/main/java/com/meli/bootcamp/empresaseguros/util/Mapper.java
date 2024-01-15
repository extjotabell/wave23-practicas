package com.meli.bootcamp.empresaseguros.util;


import com.meli.bootcamp.empresaseguros.dto.SiniestroDto;
import com.meli.bootcamp.empresaseguros.dto.VehiculoDto;
import com.meli.bootcamp.empresaseguros.entity.Siniestro;
import com.meli.bootcamp.empresaseguros.entity.Vehiculo;

public class Mapper {

    public static Vehiculo mapToVehiculo(VehiculoDto vehiculoDto){
        if(vehiculoDto == null) return null;
        return new Vehiculo(vehiculoDto.getPatente(),vehiculoDto.getMarca(),vehiculoDto.getModelo(),vehiculoDto.getFechaFabricacion(),vehiculoDto.getRuedas());
    }
    public static VehiculoDto mapToVehiculoDto(Vehiculo vehiculo){
        if(vehiculo == null) return null;
        return new VehiculoDto(vehiculo.getPatente(),vehiculo.getMarca(),vehiculo.getModelo(),vehiculo.getFechaFabricacion(),vehiculo.getRuedas());
    }
    public static Siniestro mapToSiniestro(SiniestroDto siniestroDto, Vehiculo vehiculo){
        if(siniestroDto ==null) return null;
        return new Siniestro(siniestroDto.getFecha(),siniestroDto.getPerdida(),vehiculo);
    }
    public static SiniestroDto mapToSiniestroDto(Siniestro siniestro){
        if(siniestro ==null) return null;
        return new SiniestroDto(siniestro.getFecha(),siniestro.getPerdida(),mapToVehiculoDto(siniestro.getVehiculo()));
    }
}
