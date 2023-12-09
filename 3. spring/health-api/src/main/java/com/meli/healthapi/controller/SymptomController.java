package com.meli.healthapi.controller;

import com.meli.healthapi.dto.BasicPersonDTO;
import com.meli.healthapi.dto.PersonDTO;
import com.meli.healthapi.dto.SymptomDTO;
import com.meli.healthapi.service.PersonService;
import com.meli.healthapi.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/symptom")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;
    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<SymptomDTO>> getAllSymptoms(){
        return new ResponseEntity<>(symptomService.getSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SymptomDTO> getSymptomByName(@PathVariable String name){
        return new ResponseEntity<>(symptomService.getSymptoms().stream().filter(s -> s.getName().equals(name.toUpperCase())).findFirst()
                                                                .get(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<BasicPersonDTO>> findRiskPerson(){
        return new ResponseEntity<>(symptomService.getRiskPersons(), HttpStatus.OK);
    }


    @PostMapping("/load")
    public ResponseEntity<List<SymptomDTO>> loadSymptoms(@RequestBody List<SymptomDTO> listNewSymptoms){
            for (SymptomDTO s : listNewSymptoms) symptomService.addSymptom(s);
            return new ResponseEntity<>(symptomService.getSymptoms(), HttpStatus.OK);
    }


}
