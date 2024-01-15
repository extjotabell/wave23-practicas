package com.mercadolibre.companyautoinsurance.services;

import com.mercadolibre.companyautoinsurance.models.dtos.AccidentDTO;

public interface IAccidentService {

    AccidentDTO saveAccident(AccidentDTO accidentDTO);
}
