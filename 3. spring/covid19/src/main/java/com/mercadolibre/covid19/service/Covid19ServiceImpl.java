package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.dto.RiskPersonDto;
import com.mercadolibre.covid19.dto.RiskPersonsDto;
import com.mercadolibre.covid19.dto.SymptomDto;
import com.mercadolibre.covid19.dto.SymptomsDto;
import com.mercadolibre.covid19.entity.Person;
import com.mercadolibre.covid19.entity.Symptom;
import com.mercadolibre.covid19.exception.NotFoundException;
import com.mercadolibre.covid19.repository.ICovid19Repository;
import com.mercadolibre.covid19.repository.Covid19RepositoryImpl;
import com.mercadolibre.covid19.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class Covid19ServiceImpl implements ICovid19Service {
    ICovid19Repository symptomRepository;

    public Covid19ServiceImpl(Covid19RepositoryImpl symptomRepository) {
        this.symptomRepository = symptomRepository;
    }

    @Override
    public SymptomsDto findAllSymptoms() {
        Set<Symptom> list = symptomRepository.findAllSymptoms();

        if (list.isEmpty()) {
            throw new NotFoundException("No se encontraron síntomas");
        }

        return new SymptomsDto(list.stream().map(Mapper::mapperSymptomToDto).toList());
    }

    @Override
    public SymptomDto findSymptomByName(String name) {
        Optional<Symptom> symptom = symptomRepository.findSymptomByName(name);

        if (symptom.isEmpty()) {
            throw new NotFoundException("No se encontró síntomas con el nombre " + name);
        }

        return Mapper.mapperSymptomToDto(symptom.get());
    }

    @Override
    public RiskPersonsDto findRiskPerson() {
        Map<Person, Symptom> riskPersons = symptomRepository.findRiskPerson();

        if (riskPersons.isEmpty()) {
            throw new NotFoundException("No se encontraron personas de riesgo");
        }

        return new RiskPersonsDto(riskPersons.entrySet().stream()
                .map(Mapper::mapperRiskPersonToDto)
                .toList());
    }
}
