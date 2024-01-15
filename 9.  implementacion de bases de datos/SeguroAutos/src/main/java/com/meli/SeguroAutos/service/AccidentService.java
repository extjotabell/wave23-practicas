package com.meli.SeguroAutos.service;

import com.meli.SeguroAutos.dto.AccidentRequestDTO;
import com.meli.SeguroAutos.dto.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface AccidentService {

    ResponseDTO createAccident(AccidentRequestDTO accidentRequestDTO, Long idVehicle);

}
