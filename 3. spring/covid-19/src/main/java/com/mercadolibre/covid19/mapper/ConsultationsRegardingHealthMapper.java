package com.mercadolibre.covid19.mapper;

import com.mercadolibre.covid19.dto.PersonDTO;
import com.mercadolibre.covid19.dto.SymptomDTO;
import com.mercadolibre.covid19.entity.Person;
import com.mercadolibre.covid19.entity.Symptom;

/**
 * Mapper class responsible for converting entities to DTOs in the context of health consultations.
 */
public class ConsultationsRegardingHealthMapper {
    /**
     * Maps a Symptom entity to a SymptomDTO.
     *
     * @param symptom The Symptom entity to be mapped.
     * @return SymptomDTO representing the mapped symptom.
     */
    public SymptomDTO mapSymptomToDTO(Symptom symptom){
        return new SymptomDTO(symptom.getName(), symptom.getSeverityLevel());
    }

    /**
     * Maps a Person entity to a PersonDTO.
     *
     * @param person The Person entity to be mapped.
     * @return PersonDTO representing the mapped person.
     */
    public PersonDTO mapPatientToDTO(Person person){
        return new PersonDTO(person.getName(), person.getLastname());
    }
}
