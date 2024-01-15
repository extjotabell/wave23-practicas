package com.ospina.showroom.servicio.prenda;

import com.ospina.showroom.modelo.dto.request.PrendaRequestDto;
import com.ospina.showroom.modelo.entidad.Prenda;

import java.util.List;

public interface PrendaServicio {

    Long guardarPrenda(PrendaRequestDto prendaRequestDto);

    List<Prenda> obtenerPrendas(String nombre);

    Prenda obtenerPrendaPorCodigo(Long code);

    Prenda actualizarPrenda(Long code, PrendaRequestDto prendaRequestDto);

    void eliminarPrenda(Long code);

    List<Prenda> obtenerPrendasPorTalla(String size);
}
