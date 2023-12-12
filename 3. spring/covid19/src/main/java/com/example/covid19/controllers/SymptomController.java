package com.example.covid19.controllers;

import com.example.covid19.dto.PersonDTO;
import com.example.covid19.dto.SymptomDTO;
import com.example.covid19.entities.Person;
import com.example.covid19.entities.Symptom;
import com.example.covid19.enums.NAMESYMPTOM;
import com.example.covid19.enums.SEVERITY;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SymptomController {

    List<Person> person = new ArrayList<>();
    List<Symptom> symptoms = new ArrayList<>();
    int adultAge = 60;

    public SymptomController() {
        symptoms.add((new Symptom(123, NAMESYMPTOM.FEVER, SEVERITY.HIGH)));
        symptoms.add(new Symptom(189, NAMESYMPTOM.RUNNY_NOSE, SEVERITY.LOW));
        symptoms.add(new Symptom(111, NAMESYMPTOM.LOSS_SMELL, SEVERITY.MEDIUM));
        symptoms.add(new Symptom(100, NAMESYMPTOM.LOSS_TASTE, SEVERITY.MEDIUM));
        symptoms.add(new Symptom(89, NAMESYMPTOM.HEADACHE, SEVERITY.LOW));
        symptoms.add(new Symptom(22, NAMESYMPTOM.FEEL_TIRED, SEVERITY.HIGH));

        person.add(new Person(1,"Andres", "Limpio",30 ));
        person.add(new Person(2,"Brunilda", "Jimenez",66 ));
        person.add(new Person(3,"Checo", "Sevilla",59 ));
        person.add(new Person(4,"Carmen", "Diaz",77 ));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> getSymptom() {
        List<SymptomDTO> symptomDTO = new ArrayList<>();
        symptoms.forEach(symptomAdd -> symptomDTO
                .add(new SymptomDTO(symptomAdd.getNameSymptom(), symptomAdd.getSeverity()))
        );
        return ResponseEntity.ok(symptomDTO);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> getNameSymptom(@PathVariable String name) {
        String nameBlank = name.replace(" ", "_").toUpperCase();
        try {
            NAMESYMPTOM parseEnum = NAMESYMPTOM.valueOf(nameBlank);
            Symptom foundSymptom = symptoms.stream()
                    .filter(symptom -> symptom.getNameSymptom() == parseEnum)
                    .findFirst()
                    .orElse(null);
            if (foundSymptom != null) {
                return ResponseEntity.ok(new SymptomDTO(foundSymptom.getNameSymptom(), foundSymptom.getSeverity()));
            }
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nombre de síntoma inválido");
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> getRiskPeople() {
        List<PersonDTO> personDTO = person.stream()
                .filter(personAdd -> personAdd.getAge() >= adultAge)
                .map(personAdd -> new PersonDTO
                        (personAdd.getId(), personAdd.getName(), personAdd.getLastName(), personAdd.getAge()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }
}
