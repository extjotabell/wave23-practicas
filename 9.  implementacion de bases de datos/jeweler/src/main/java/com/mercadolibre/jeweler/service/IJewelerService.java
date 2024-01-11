package com.mercadolibre.jeweler.service;

import com.mercadolibre.jeweler.dto.request.JewerlyRequestDTO;
import com.mercadolibre.jeweler.dto.response.JewerlyEditedDTO;
import com.mercadolibre.jeweler.dto.response.JewerlyResponseDTO;
import com.mercadolibre.jeweler.dto.response.MessageDTO;
import com.mercadolibre.jeweler.model.Jewerly;

import java.util.List;

public interface IJewelerService {

    MessageDTO addJewerly(JewerlyRequestDTO jewerlyRequestDTO);
    List<JewerlyResponseDTO> getJewerlys();
    JewerlyEditedDTO updateJewerly(Long id, JewerlyRequestDTO jewerlyRequestDTO);
    MessageDTO deleteJewerly(long id);
    Jewerly findJewerly(long id);
}
