package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.PersonDTO;
import com.bootcamp.covid.dto.SymptomDTO;
import com.bootcamp.covid.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidService {
    List<PersonDTO> personDTOList = new ArrayList<>();
    List<SymptomDTO> symptomDTOList = new ArrayList<>();
    public List<SymptomDTO> findAllSymptom() {
        resetData();
        uploadData();
        return symptomDTOList;
    }
    public String findSymptomByName(String name) {
        resetData();
        uploadData();
        for(SymptomDTO s : symptomDTOList){
            if(s.getName().equals(name)){
                return s.getSeverityLevel();
            }
        }
        return null;
    }
    public List<PersonDTO> findAllRiskPerson() {
        List<PersonDTO> riskPersonList = new ArrayList<>();
        for(PersonDTO p : personDTOList){
            if(p.getAge()>60 && !p.getSymptomDTOList().isEmpty()){
                riskPersonList.add(p);
            }
        }
        return riskPersonList;
    }
    public void resetData(){
        symptomDTOList.clear();
        personDTOList.clear();
    }
    public void uploadData(){

        SymptomDTO symptomDTO1 = new SymptomDTO("Fever","High");
        SymptomDTO symptomDTO2 = new SymptomDTO("Headache","Medium");
        SymptomDTO symptomDTO3 = new SymptomDTO("Decay","Low");

        symptomDTOList.add(symptomDTO1);
        symptomDTOList.add(symptomDTO2);
        symptomDTOList.add(symptomDTO3);

        PersonDTO personDTO1 = new PersonDTO("Geronimo",24,symptomDTOList);
        PersonDTO personDTO2 = new PersonDTO("Alice",80,symptomDTOList);

        personDTOList.add(personDTO1);
        personDTOList.add(personDTO2);

    }

}


