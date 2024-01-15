package com.meli.SeguroAutos.util.mapper;

import com.meli.SeguroAutos.dto.AccidentRequestDTO;
import com.meli.SeguroAutos.entity.Accident;
import com.meli.SeguroAutos.entity.Vehicle;

public class AccidentMapper {

    public static Accident mapToAccident(AccidentRequestDTO accidentRequestDTO, Vehicle vehicle){
        Accident accident = new Accident();
        accident.setDateOfAccident(accidentRequestDTO.getDateOfAccident());
        accident.setEconomicLosses(accidentRequestDTO.getEconomicLosses());
        accident.setVehicle(vehicle);
        return accident;
    }

}
