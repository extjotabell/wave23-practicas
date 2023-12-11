package com.example.covid19.controller;

import com.example.covid19.dto.SintomaDTO;
import com.example.covid19.model.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sintomas")
public class SintomaController {

    @PostMapping
    public ResponseEntity<SintomaDTO> agregarSintoma(@RequestBody SintomaDTO nuevoSintomaDTO){
        Sintoma nuevoSintoma = new Sintoma(nuevoSintomaDTO.getCodigo(), nuevoSintomaDTO.getNombre(), nuevoSintomaDTO.getNivelDeGravedad());
        Sintoma.agregarSintoma(nuevoSintoma);
        return ResponseEntity.ok().body(nuevoSintomaDTO);
    }

    @GetMapping
    public ResponseEntity<List<SintomaDTO>> encontrarTodosSintomas(){

        List<SintomaDTO> listaSintomasDTO = new ArrayList<>();
        for(Sintoma sintoma : Sintoma.getListaSintomas()){
            listaSintomasDTO.add(new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelDeGravedad()));
        }

        return ResponseEntity.ok().body(listaSintomasDTO);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<SintomaDTO> encontrarSintoma(@PathVariable String nombre){
        Sintoma sintomaEncontrado = Sintoma.getListaSintomas().stream().
                filter(s -> nombre.equals(s.getNombre()))
                .findAny()
                .orElse(null);

        if(sintomaEncontrado != null){
            SintomaDTO sintomaEncontradoDTO = new SintomaDTO(sintomaEncontrado.getCodigo(), sintomaEncontrado.getNombre(), sintomaEncontrado.getNivelDeGravedad());
            return ResponseEntity.ok().body(sintomaEncontradoDTO);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
