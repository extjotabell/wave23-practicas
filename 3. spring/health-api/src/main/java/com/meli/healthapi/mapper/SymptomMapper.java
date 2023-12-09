package com.meli.healthapi.mapper;

import com.meli.healthapi.dto.SymptomDTO;
import com.meli.healthapi.model.Symptom;

public class SymptomMapper {

    public static SymptomDTO symptomToSymptomDTO(Symptom symptom){
        return new SymptomDTO(symptom.getCode(), symptom.getName(), symptom.getSeverity());
    }

    public static Symptom symptomDTOToSymptom(SymptomDTO symptomDTO) {
        return new Symptom(symptomDTO.getCode(), symptomDTO.getName(), symptomDTO.getSeverity());
    }
}
