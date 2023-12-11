package com.bootcamp.ejercicioDeportistas.controller;

import com.bootcamp.ejercicioDeportistas.dto.request.PersonaRequestDto;
import com.bootcamp.ejercicioDeportistas.dto.response.DeporteResponseDto;
import com.bootcamp.ejercicioDeportistas.dto.response.ErrorResponse;
import com.bootcamp.ejercicioDeportistas.dto.response.PersonaDeporteResponseDto;
import com.bootcamp.ejercicioDeportistas.dto.response.PersonaResponseDto;
import com.bootcamp.ejercicioDeportistas.model.Deporte;
import com.bootcamp.ejercicioDeportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @PostMapping
    public ResponseEntity<?> agregarPersona(@RequestBody PersonaRequestDto nuevaPersonaRequest){

        try{
            if(nuevaPersonaRequest.getNombre() == null
                    || nuevaPersonaRequest.getApellido() == null
                    || nuevaPersonaRequest.getEdad() == null ){
                throw new MissingRequestValueException("Datos incompletos para agregar un nuevo deporte");
            }

            Persona nuevaPersona = new Persona(nuevaPersonaRequest.getNombre(),
                    nuevaPersonaRequest.getApellido(),
                    nuevaPersonaRequest.getEdad());

            Persona.agregarPersona(nuevaPersona);

            PersonaResponseDto nuevaPersonaResponse = new PersonaResponseDto(
                    nuevaPersona.getNombre(),
                    nuevaPersona.getApellido(),
                    nuevaPersona.getEdad());

            return ResponseEntity.ok(nuevaPersonaResponse);

        }catch(MissingRequestValueException e){
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse("Ocurrió un error."));
        }
    }

    @GetMapping
    public ResponseEntity<?> mostrarPersonas(){
        try{
            List<PersonaResponseDto> listaPersonasResponse = new ArrayList<>();
            for(Persona persona : Persona.getListaPersonas()){
                listaPersonasResponse.add(new PersonaResponseDto(
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getEdad())
                );
            }
            return new ResponseEntity<>(listaPersonasResponse, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse("Ocurrió un error."));
        }
    }

    @GetMapping("/deporte")
    public ResponseEntity<?> obtenerPersonasConDeporte(){

        Random r = new Random();
        int valorFinal = Deporte.getListaDeportes().size();

        try{
            List<PersonaDeporteResponseDto> listaPersonasDeporte = new ArrayList<>();
            for(Persona persona : Persona.getListaPersonas()){
                String deporte = null;
                if(!Deporte.getListaDeportes().isEmpty()){
                    deporte = Deporte.getListaDeportes().get(r.nextInt(valorFinal)).getNombre();
                }
                listaPersonasDeporte.add(new PersonaDeporteResponseDto(
                        persona.getNombre(),
                        persona.getApellido(),
                        deporte
                ));
            }
            return ResponseEntity.ok().body(listaPersonasDeporte);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse("Ocurrió un error."));
        }
    }

}
