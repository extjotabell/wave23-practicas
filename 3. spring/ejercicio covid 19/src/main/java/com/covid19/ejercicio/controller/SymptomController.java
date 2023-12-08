package com.covid19.ejercicio.controller;

import com.covid19.ejercicio.dto.SymptomDTO;
import com.covid19.ejercicio.dto.UserDTO;
import com.covid19.ejercicio.entities.Symptom;
import com.covid19.ejercicio.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SymptomController {
    /////////////////////////////// SYMPTOMS ////////////////////////////////////
    ArrayList<Symptom> symptoms = new ArrayList<>();
    Symptom fever = new Symptom(1, "Fever", "High");
    Symptom cough = new Symptom(2, "Cough", "Medium");
    Symptom fatigue = new Symptom(3, "Fatigue", "Medium");
    Symptom headache = new Symptom(3, "Headache", "Low");

    /////////////////////////////// USERS ////////////////////////////////////
    ArrayList<User> users = new ArrayList<>();
    User juan = new User(1, 30, "Juan", "Rodriguez");
    User dario = new User(2, 25, "Dario", "Marinez");
    User maria = new User(3, 15, "Maria", "Gonzalez");
    User julia = new User(4, 63, "Julia", "Sanchez");

    /////////////////////////////// DTOS ////////////////////////////////////
    HashMap<String, ArrayList<Symptom>> usersSymptoms = new HashMap<>();
    // juan, [tos, fiebre, dolor]

    /////////////////////////////// USER´S SYMPTOMS /////////////////////////////////
    ArrayList<Symptom> juansSymptoms = new ArrayList<>();
    ArrayList<Symptom> juliasSymptoms = new ArrayList<>();

    public SymptomController (){
        symptoms.addAll(List.of(fever, cough, fatigue, headache));
        users.addAll(List.of(juan, dario, maria, julia));
        juansSymptoms.addAll(List.of(fever, cough));
        juliasSymptoms.addAll(List.of(fever, cough, fatigue));
        usersSymptoms.put(juan.getName(), juansSymptoms);
        usersSymptoms.put(julia.getName(), juliasSymptoms);
    }

    @GetMapping (path = "/findSymptom")
    ResponseEntity<ArrayList<SymptomDTO>> findSymptom(){
        ArrayList<SymptomDTO> symptomDTOS = new ArrayList<>();
        for (Symptom s : symptoms) {
            SymptomDTO symptomDTO = new SymptomDTO();
            symptomDTO.setName(s.getName());
            symptomDTO.setSeverityLevel(s.getSeverityLevel());
            symptomDTOS.add(symptomDTO);
        }

        return ResponseEntity.ok(symptomDTOS);
    }

    @GetMapping (path = "/findSymptom/{name}")
    ResponseEntity<SymptomDTO> findSymptom (@PathVariable String name){
        SymptomDTO symptomDTO = new SymptomDTO();
        symptomDTO.setName(name);
        symptomDTO.setSeverityLevel(this.getSymptomSeverityByName(name).orElse("Symptom not found"));

        return ResponseEntity.ok(symptomDTO);
    }

    @GetMapping (path = "/findRiskPerson")
    ResponseEntity<List<UserDTO>> findRiskPerson() {
        return ResponseEntity.ok(findHighRiskIndividuals());
    }

    private Optional<String> getSymptomSeverityByName(String name) {
        return symptoms.stream().
                filter(s -> s.getName().equals(name))
                .map(Symptom::getSeverityLevel).
                findFirst();
    }

    private List<UserDTO> findHighRiskIndividuals() {
        List<UserDTO> usersWithRisk = new ArrayList<>();

        for (User u : users) {
            ArrayList<Symptom> userSymptoms = usersSymptoms.get(u.getName());
            if (u.getAge() >= 60 && !userSymptoms.isEmpty()) {
                UserDTO user = new UserDTO(u.getName() + " " + u.getSurname());
                usersWithRisk.add(user);
            }
        }

        return usersWithRisk;
    }
}
