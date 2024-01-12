package org.ejercicio.surehql.service;

import org.ejercicio.surehql.model.dto.BrandDTO;
import org.ejercicio.surehql.model.dto.ModelDTO;
import org.ejercicio.surehql.model.dto.PatentDTO;
import org.ejercicio.surehql.model.dto.SinisterDTO;

import java.util.List;

public interface ISureService {
    List<PatentDTO> getPatents();

    List<BrandDTO> getPatentsAndBrand();

    List<PatentDTO> getPatentsFilter();

    List<ModelDTO> getModelFilteredSinister();

    SinisterDTO getModelFilteredSinisterSum();
}
