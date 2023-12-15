package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.dto.RiskPersonsDto;
import com.mercadolibre.covid19.dto.SymptomDto;
import com.mercadolibre.covid19.dto.SymptomsDto;

public interface ICovid19Service {
    SymptomsDto findAllSymptoms();
    SymptomDto findSymptomByName(String name);
    RiskPersonsDto findRiskPerson();
}
