package com.meli.ejercicioSiniestros.utils;

import com.meli.ejercicioSiniestros.dto.SiniestroFullDTO;
import com.meli.ejercicioSiniestros.dto.VehiculoFullDTO;
import com.meli.ejercicioSiniestros.dto.request.SiniestroCreationDTO;
import com.meli.ejercicioSiniestros.dto.request.VehiculoCreationDTO;
import com.meli.ejercicioSiniestros.model.Siniestro;
import com.meli.ejercicioSiniestros.model.Vehiculo;

public class Mapper {
    public static Siniestro mapSiniestroCreationToSiniestro(SiniestroCreationDTO siniestroDto){
        return new Siniestro();
    }
    public static SiniestroFullDTO mapSiniestroToSiniestroCreated(Siniestro siniestro){
        return new SiniestroFullDTO();
    }

    public static SiniestroFullDTO mapSiniestroToSiniestroFull(Siniestro siniestro) {
        return new SiniestroFullDTO();
    }

    public static Vehiculo mapVehiculoCreationToVehiculo(VehiculoCreationDTO vehiculoDto) {
        return new Vehiculo();
    }

    public static VehiculoFullDTO mapVehiculoToVehiculoFull(Vehiculo result) {
        return new VehiculoFullDTO();
    }
}
