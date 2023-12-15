package com.mercadolibre.covid19.repository;

import com.mercadolibre.covid19.entity.Person;
import com.mercadolibre.covid19.entity.Symptom;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class Covid19RepositoryImpl implements ICovid19Repository {
    Set<Symptom> listOfSymptoms = new HashSet<>();
    Set<Person> listOfPeople = new HashSet<>();
    Map<Person, Symptom> riskPerson = new HashMap<>();

    public Covid19RepositoryImpl() {
        loadData();
    }

    @Override
    public Set<Symptom> findAllSymptoms() {
        return listOfSymptoms;
    }

    @Override
    public Optional<Symptom> findSymptomByName(String name) {
        return listOfSymptoms.stream()
                .filter(s -> name.equalsIgnoreCase(s.getSymptomName()))
                .findFirst();
    }

    @Override
    public Map<Person, Symptom> findRiskPerson() {
        return riskPerson;
    }

    private void loadData() {
        listOfSymptoms.add(new Symptom(1, "Fiebre", "Alto"));
        listOfSymptoms.add(new Symptom(2, "Tos seca", "Leve"));
        listOfSymptoms.add(new Symptom(3, "Fatiga", "Moderado"));
        listOfSymptoms.add(new Symptom(4, "Dificultad para respirar", "Alto"));

        listOfPeople.add(new Person(1, "Juan", "Perez", 65));
        listOfPeople.add(new Person(2, "Diego", "Lopez", 32));
        listOfPeople.add(new Person(3, "Maria", "Gonzalez", 43));
        listOfPeople.add(new Person(4, "Ana", "Martinez", 70));

        riskPerson.put(
                new Person(1, "Juan", "Perez", 65),
                new Symptom(1, "Fiebre", "Alto")
        );
        riskPerson.put(
                new Person(4, "Ana", "Martinez", 70),
                new Symptom(4, "Dificultad para respirar", "Alto")
        );
    }
}
