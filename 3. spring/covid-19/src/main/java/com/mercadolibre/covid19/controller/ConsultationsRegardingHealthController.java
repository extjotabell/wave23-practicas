package com.mercadolibre.covid19.controller;

import com.mercadolibre.covid19.dto.SymptomDTO;
import com.mercadolibre.covid19.entity.Person;
import com.mercadolibre.covid19.entity.Symptom;
import com.mercadolibre.covid19.mapper.ConsultationsRegardingHealthMapper;
import com.mercadolibre.covid19.dto.PersonDTO;
import com.mercadolibre.covid19.service.ConsultationsRegardingHealthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for handling health consultations related to COVID-19.
 */
@RestController
@RequestMapping("api/consultations-regarding-health")
public class ConsultationsRegardingHealthController {
    private final ConsultationsRegardingHealthService consultationsService;
    private final ConsultationsRegardingHealthMapper mapper;

    /**
     * Constructor for ConsultationsRegardingHealthController.
     */
    public ConsultationsRegardingHealthController() {
        this.consultationsService = new ConsultationsRegardingHealthService();
        this.mapper = new ConsultationsRegardingHealthMapper();
    }

    /**
     * Endpoint to find all symptoms.
     *
     * @return ResponseEntity with a list of SymptomDTOs or an error message if an exception occurs.
     */
    @GetMapping("/findSymptoms")
    public ResponseEntity<?> findSymptoms() {
        try {
            List<Symptom> symptoms = consultationsService.findSymptoms();
            List<SymptomDTO> symptomDTOs = symptoms.stream()
                    .map(mapper::mapSymptomToDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(symptomDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al intentar obtener los síntomas.");
        }
    }

    /**
     * Endpoint to find a symptom by name.
     *
     * @param name The name of the symptom to search for.
     * @return ResponseEntity with a SymptomDTO or an error message if an exception occurs.
     */
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable String name) {
        try {
            return consultationsService.findSymptomByName(name)
                    .map(mapper::mapSymptomToDTO)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al intentar obtener el síntoma por nombre.");
        }
    }

    /**
     * Endpoint to find persons at risk.
     *
     * @return ResponseEntity with a list of PersonDTOs or an error message if an exception occurs.
     */
    @GetMapping("/findRiskPersons")
    public ResponseEntity<?> findRiskPersons() {
        try {
            List<Person> riskPersons = consultationsService.findRiskPersons();
            List<PersonDTO> result = riskPersons.stream()
                    .map(mapper::mapPatientToDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al intentar obtener a las personas en riesgo.");
        }
    }

}
