package com.mercadolibre.covid19.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.covid19.dto.RiskPersonDto;
import com.mercadolibre.covid19.dto.SymptomDto;
import com.mercadolibre.covid19.entity.Person;
import com.mercadolibre.covid19.entity.Symptom;

import java.util.List;
import java.util.Map;

public class Mapper {
    static final ObjectMapper mapper = new ObjectMapper();

    public static SymptomDto mapperSymptomToDto(Symptom symptom) {
        return mapper.convertValue(symptom, SymptomDto.class);
    }

    public static RiskPersonDto mapperRiskPersonToDto(Map.Entry<Person, Symptom> riskPerson) {
        RiskPersonDto dto = new RiskPersonDto();
        dto.setName(riskPerson.getKey().getName());
        dto.setLastname(riskPerson.getKey().getLastname());
        dto.setAge(riskPerson.getKey().getAge());
        dto.setSymptomName(riskPerson.getValue().getSymptomName());
        dto.setSeverity_level(riskPerson.getValue().getSeverity_level());
        return dto;
    }
}
