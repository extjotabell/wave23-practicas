package com.meli.covid.controllers;

import com.meli.covid.dto.response.MessageDTO;
import com.meli.covid.dto.response.RiskPersonDTO;
import com.meli.covid.dto.response.SymptomDTO;
import com.meli.covid.entities.Person;
import com.meli.covid.entities.Symptom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/covid/")
public class CovidRestController {

    private List<Person> persons = new ArrayList<>(List.of(
        new Person(1, "Juan", "Perez", 43),
        new Person(2, "Pedro", "Gomez", 61),
        new Person(3, "Maria", "Gonzalez", 54),
        new Person(4, "Jose", "Rodriguez", 78),
        new Person(5, "Luis", "Lopez", 65)
    ));

    private List<Symptom> symptoms = new ArrayList<>(List.of(
        new Symptom(1, "Tos", 1),
        new Symptom(2, "Fiebre", 2),
        new Symptom(3, "Dolor de cabeza", 3),
        new Symptom(4, "Dolor de garganta", 4),
        new Symptom(5, "Dificultad para respirar", 5)
    ));

    private Map<Person, Symptom> relations = new HashMap<>(Map.of(
        persons.get(0), symptoms.get(4),
        persons.get(1), symptoms.get(3),
        persons.get(2), symptoms.get(2),
        persons.get(3), symptoms.get(1),
        persons.get(4), symptoms.get(0)
    ));

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> getSymptoms() {
        List<SymptomDTO> symptomDTOs = symptoms.stream()
            .map(symptom -> {
                return new SymptomDTO(
                    symptom.getName(),
                    symptom.getSeverityLevel()
                );
            })
            .toList();

        return new ResponseEntity<>(symptomDTOs, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> getSymptom(@PathVariable String name) {
        Symptom symptom = symptoms.stream()
            .filter(s -> s.getName().equals(name))
            .findFirst()
            .orElse(null);

        if (symptom == null) {
            return new ResponseEntity<>(
                new MessageDTO("No se encontró el síntoma"),
                HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
            new SymptomDTO(symptom.getName(), symptom.getSeverityLevel()),
            HttpStatus.OK
        );
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> getRiskPersons() {
        List<RiskPersonDTO> riskPersons = new ArrayList<>();

        relations.forEach((person, symptom) -> {
            if(person.getAge() > 60) {
                 riskPersons.add(new RiskPersonDTO(
                    person.getName() + " " + person.getLastName(),
                    person.getAge(),
                    symptom.getName(),
                    symptom.getSeverityLevel()
                ));
            }
        });

        return new ResponseEntity<>(riskPersons, HttpStatus.OK);
    }
}
