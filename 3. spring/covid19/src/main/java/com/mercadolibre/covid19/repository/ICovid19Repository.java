package com.mercadolibre.covid19.repository;

import com.mercadolibre.covid19.entity.Person;
import com.mercadolibre.covid19.entity.Symptom;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface ICovid19Repository {
    Set<Symptom> findAllSymptoms();
    Optional<Symptom> findSymptomByName(String name);
    Map<Person, Symptom> findRiskPerson();
}
