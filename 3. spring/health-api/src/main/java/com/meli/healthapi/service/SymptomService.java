package com.meli.healthapi.service;

import com.meli.healthapi.dto.BasicPersonDTO;
import com.meli.healthapi.dto.PersonDTO;
import com.meli.healthapi.dto.SymptomDTO;
import com.meli.healthapi.mapper.SymptomMapper;
import com.meli.healthapi.model.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomService {
    private List<Symptom> symptoms;

    @Autowired
    private PersonService ps;

    public SymptomService() {
        symptoms = new ArrayList<>();
    }

    public SymptomService(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public List<SymptomDTO> getSymptoms() {
        return symptoms.stream().map(SymptomMapper::symptomToSymptomDTO).toList();
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
    public void addSymptom(SymptomDTO newSymptom){
        this.symptoms.add(SymptomMapper.symptomDTOToSymptom(newSymptom));
    }
    public void deleteSymptom(Symptom newSymptom){
        this.symptoms.remove(newSymptom);
    }

    public List<BasicPersonDTO> getRiskPersons() {
        return ps.getPersons().stream().filter(p -> p.getAge() >= 60 && !p.getSymptoms().isEmpty())
                              .map(p -> new BasicPersonDTO(p.getName(), p.getLastName())).toList();
    }
}
