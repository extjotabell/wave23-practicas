package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.entity.Person;
import com.mercadolibre.covid19.entity.Symptom;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for handling health consultations related to COVID-19.
 */
public class ConsultationsRegardingHealthService {
    private static final List<Symptom> symptoms = initializeSymptoms();
    private static final List<Person> patients = initializePatients();

    /**
     * Initializes a list of predefined symptoms.
     *
     * @return List of predefined symptoms.
     */
    private static List<Symptom> initializeSymptoms() {
        return List.of(
                new Symptom(1, "Dolor de garganta", 1),
                new Symptom(2, "Fiebre", 3),
                new Symptom(3, "Dolor corporal", 2),
                new Symptom(4, "Escalofríos", 2),
                new Symptom(5, "Vómito", 2)
        );
    }

    /**
     * Initializes a list of predefined patients.
     *
     * @return List of predefined patients.
     */
    private static List<Person> initializePatients(){
        return List.of(
                new Person(1, "Arami", "Aquino", 25, List.of(new Symptom(5, "Vómito", 2), new Symptom(4, "Escalofríos", 2))),
                new Person(2, "Matias", "Gonzalez", 70, List.of(new Symptom(1, "Dolor de garganta", 1), new Symptom(2, "Fiebre", 3), new Symptom(3, "Dolor corporal", 2))),
                new Person(3, "Maria", "Perez", 81, List.of(new Symptom(1, "Dolor de garganta", 1), new Symptom(5, "Vómito", 2))),
                new Person(3, "Camila", "Pereira", 41, List.of(new Symptom(1, "Dolor de garganta", 1), new Symptom(2, "Fiebre", 3), new Symptom(3, "Dolor corporal", 2))),
                new Person(4, "Sofía", "Mandela", 89, List.of())
        );
    }

    /**
     * Finds persons at risk based on age and symptoms.
     *
     * @return List of persons at risk.
     */
    public List<Person> findRiskPersons(){
        return patients.stream()
                .filter(patient -> patient.getAge() > 60 && !patient.getSymptoms().isEmpty())
                .collect(Collectors.toList());
    }

    /**
     * Gets a list of predefined symptoms.
     *
     * @return List of predefined symptoms.
     */
    public List<Symptom> findSymptoms(){
        return symptoms;
    }

    /**
     * Finds a symptom by its name.
     *
     * @param name The name of the symptom to search for.
     * @return Optional containing the symptom if found, otherwise empty.
     */
    public Optional<Symptom> findSymptomByName(String name){
        return symptoms.stream()
                .filter(symptom -> symptom.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
