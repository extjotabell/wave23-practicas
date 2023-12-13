package com.spring.Covid19.controllers;

import com.spring.Covid19.DTOs.RiskPerson;
import com.spring.Covid19.entities.Person;
import com.spring.Covid19.entities.Symptom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CovidController {

    private static final List<Symptom> SINTOMAS = new ArrayList<>();
    private static final List<Person> PERSONAS = new ArrayList<>();

    private static final Map<Person, List<Symptom>> PERSONAS_SINTOMAS = new HashMap<>();

    static {
        SINTOMAS.add(new Symptom("Fiebre", 2));
        SINTOMAS.add(new Symptom("Tos", 2));
        SINTOMAS.add(new Symptom("Dificultad para respirar", 3));
        SINTOMAS.add(new Symptom("Fatiga", 1));
        SINTOMAS.add(new Symptom("Dolores musculares y corporales", 1));
        SINTOMAS.add(new Symptom("Dolor de cabeza", 3));
        SINTOMAS.add(new Symptom("Dolor de garganta", 2));
        SINTOMAS.add(new Symptom("Pérdida reciente del olfato o el gusto", 1));
        PERSONAS.add(new Person("Ailen", "Pereira", 28));
        PERSONAS.add(new Person("Juan", "Perez", 20, SINTOMAS.subList(1,4)));
        PERSONAS.add(new Person("Carlos", "Martinez", 65));
        PERSONAS_SINTOMAS.put(PERSONAS.get(0),SINTOMAS.subList(0,1));
        PERSONAS_SINTOMAS.put(PERSONAS.get(1),SINTOMAS.subList(2,5));
        PERSONAS_SINTOMAS.put(PERSONAS.get(2),SINTOMAS.subList(0,3));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> findSymptom(){
        if(!SINTOMAS.isEmpty()){
            return new ResponseEntity<>(SINTOMAS, HttpStatus.OK);
        }else{
            return ResponseEntity.badRequest().body("No hay síntomas registrados");
        }

    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable String name){
        Symptom symptomFound = null;
        for (Symptom symptom : SINTOMAS) {
            if(symptom.getName().equalsIgnoreCase(name)){
                symptomFound = symptom;
            }
        };
        if(symptomFound == null){
            return ResponseEntity.badRequest().body("Síntoma no encontrado");
        }
        return ResponseEntity.ok(symptomFound);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findRiskPerson(){
        List<RiskPerson> riskPeople = new ArrayList<>();
        for (Person p: PERSONAS) {
            if(p.isRiskPerson()){
                riskPeople.add(new RiskPerson(p.getName(), p.getLastname()));
            }
        }
        if(riskPeople.isEmpty()){
            return ResponseEntity.badRequest().body("No se encontraron personas de riesgo");
        }
        return ResponseEntity.ok(riskPeople);
    }

    @GetMapping("/findRiskPersonMap")
    public ResponseEntity<?> findRiskPersonWMap(){
        List<RiskPerson> riskPeople = PERSONAS_SINTOMAS.entrySet().stream()
                .filter(entry -> entry.getKey().isRiskPerson() && !entry.getValue().isEmpty())
                .map(entry -> new RiskPerson(entry.getKey().getName(), entry.getKey().getLastname()))
                .toList();
        if(riskPeople.isEmpty()){
            return ResponseEntity.badRequest().body("No se encontraron personas de riesgo");
        }
        return ResponseEntity.ok(riskPeople);
    }
}
