package com.meli.MiniSeries.utils;

import com.meli.MiniSeries.dto.MiniSerieReqDTO;
import com.meli.MiniSeries.dto.MiniSerieResDTO;
import com.meli.MiniSeries.model.MiniSerie;

public class DTOMapper {

    public static MiniSerieResDTO toDTO(MiniSerie miniSerie) {
        return new MiniSerieResDTO(miniSerie.getId(), miniSerie.getName(), miniSerie.getRating(), miniSerie.getAmountOfAwards());
    }

    public static MiniSerie toModel(MiniSerieReqDTO miniSerieReqDTO) {
        return new MiniSerie(miniSerieReqDTO.getName(), miniSerieReqDTO.getRating(), miniSerieReqDTO.getAmountOfAwards());
    }
}
