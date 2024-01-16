package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.response.MessageDTO;
import com.mercadolibre.showroom.dto.PrendaDTO;

import java.util.List;

public interface IPrendaService {
    PrendaDTO addPrenda(PrendaDTO prendaDTO);
    List<PrendaDTO> getAll();
    PrendaDTO getByCode(Integer code);
    PrendaDTO updateByCode(Integer code, PrendaDTO prendaDTO);
    MessageDTO deleteByCode(Integer code);
    List<PrendaDTO> getBySize(Integer size);
    List<PrendaDTO> getByName(String name);
}
