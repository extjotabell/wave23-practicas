package com.example.Showroom.service;

import com.example.Showroom.model.dto.request.NewPrendaDto;
import com.example.Showroom.model.dto.response.BaseResponseDto;
import com.example.Showroom.model.entity.Prenda;

import java.util.List;

public interface IShowroomService {

    BaseResponseDto savePrenda(NewPrendaDto prenda);

    List<Prenda> getAllPrendas();

    Prenda getPrenda(Long code);

    Prenda editPrenda(Long code, Prenda prenda);

    BaseResponseDto removePrenda(Long code);

    List<Prenda> getPrendaTalle(String size);

    List<Prenda> getPrendaNombre(String nombre);
}
