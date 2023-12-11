package covid19.covid19.controller;

import covid19.covid19.dto.ListaDto;
import covid19.covid19.dto.NivelGravedadDto;
import covid19.covid19.dto.PersonaDto;
import covid19.covid19.dto.SintomaDto;
import covid19.covid19.exception.SintomaNoEncontradoException;
import covid19.covid19.service.Covid19Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid-19")
public class Covid19Controller {
    @Autowired
    Covid19Service service;

    @GetMapping("/findSymptom")
    public ResponseEntity<ListaDto<SintomaDto>> getSintomas(){
       ListaDto<SintomaDto> sintomas =  service.getSintomas();
       return new ResponseEntity<>(sintomas, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<?> nivelGravedadPorNombreDeSintoma(@PathVariable String nombre){
        try {
            NivelGravedadDto gravedadDto = service.getNivelGravedadPorNombreDeSintoma(nombre);
            return new ResponseEntity<>(gravedadDto, HttpStatus.OK);
        } catch (SintomaNoEncontradoException er){
            return new ResponseEntity<>(er.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<ListaDto<PersonaDto>> getPacientesDeRiesgo(){
        ListaDto<PersonaDto> pacientesDeRiesgo = service.getPacientesDeRiesgo();
        return new ResponseEntity<>(pacientesDeRiesgo, HttpStatus.OK);
    }
}
