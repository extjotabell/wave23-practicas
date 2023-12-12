package com.example.covid19.controllers;

import com.example.covid19.models.NivelesGravedad;
import com.example.covid19.models.Persona;
import com.example.covid19.models.PersonaDTO;
import com.example.covid19.models.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSException;

import java.util.List;

@RestController
public class ControllerCovid {
    private final List<Sintoma> sintomas = List.of(
            new Sintoma("3134","Fiebre", NivelesGravedad.MEDIO),
            new Sintoma("3124", "Tos seca", NivelesGravedad.BAJO),
            new Sintoma("4413", "Neumonia", NivelesGravedad.ALTO),
            new Sintoma("1234", "Dolor de cuerpo", NivelesGravedad.BAJO),
            new Sintoma("4667", "Cansancio", NivelesGravedad.BAJO),
            new Sintoma("3235", "Perdida de olfato", NivelesGravedad.BAJO),
            new Sintoma("6807", "Dolor de cabeza", NivelesGravedad.MEDIO)
    );
    private final List<Persona> personas = List.of(
            new Persona("Felipe", "Costa", 20,
                    List.of(sintomas.get(3),sintomas.get(2))),
            new Persona("Jose", "Perez", 63,
                    List.of(sintomas.get(0), sintomas.get(2))),
            new Persona("Maria", "Ruiz", 69,
                    List.of(sintomas.get(1), sintomas.get(2)))
    );

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Sintoma> sintomas(){
        return sintomas;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> sintomaPorNombre(@PathVariable String name){
        Sintoma sintoma = sintomas.stream().filter(s->s.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
        if(sintoma==null){
            return ResponseEntity.status(404).body("No existe un sintoma llamado " + name);
        }
        return ResponseEntity.status(200).body("Existe el sintoma " + name + ". Su nivel de gravedad es " + sintoma.getNivelDeGravedad().toString().toLowerCase());
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> personasDeRiesgo(){
        return personas.stream().filter(persona -> persona.getEdad()>60 && persona.getSintomas().size()>0).map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido())).toList();
    }
}
