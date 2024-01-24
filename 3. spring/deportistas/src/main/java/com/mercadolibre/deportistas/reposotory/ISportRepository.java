package com.mercadolibre.deportistas.reposotory;

import com.mercadolibre.deportistas.dto.SportDTO;
import com.mercadolibre.deportistas.entity.Sport;

import java.util.List;

public interface ISportRepository {
    List<Sport> findAll();

    List<String> getLevelsBySportName(String name);
}
