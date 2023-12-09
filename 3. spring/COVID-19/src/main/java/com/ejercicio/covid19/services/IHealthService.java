package com.ejercicio.covid19.services;

import com.ejercicio.covid19.dto.response.RiskPersonDto;
import com.ejercicio.covid19.dto.response.SyntomDto;
import com.ejercicio.covid19.entities.Syntom;
import com.ejercicio.covid19.exceptions.NotRiskPersonsOnSistem;
import com.ejercicio.covid19.exceptions.NotSyntomFindedWithName;
import com.ejercicio.covid19.exceptions.NotSyntomsOnSistem;

import java.util.Set;

public interface IHealthService {
    Set<Syntom> getSyntoms() throws NotSyntomsOnSistem;

    SyntomDto findSympton(String name) throws NotSyntomFindedWithName;

    Set<RiskPersonDto> getRiskPersons() throws NotRiskPersonsOnSistem;
}
