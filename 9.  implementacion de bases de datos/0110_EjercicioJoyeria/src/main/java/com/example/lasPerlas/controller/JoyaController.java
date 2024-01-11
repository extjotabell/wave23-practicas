package com.example.lasPerlas.controller;

import com.example.lasPerlas.dto.MessageDto;
import com.example.lasPerlas.dto.NewJoyaRequestDto;
import com.example.lasPerlas.model.Joya;
import com.example.lasPerlas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveJoya(@RequestBody NewJoyaRequestDto newJoya){
        Joya joya = joyaService.save(newJoya);
        return ResponseEntity.ok(new MessageDto("Joya creada con id " + joya.getNroIdentificatorio()));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(joyaService.getAllJoyas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        boolean isDeleted = joyaService.delete(id);
        if(isDeleted) return ResponseEntity.ok(new MessageDto("Joya eliminada para venta"));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDto("Joya no encontrada"));
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody NewJoyaRequestDto updatedJoyaDto){
        Joya updatedJoya = joyaService.update(id, updatedJoyaDto);
        if(updatedJoya == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDto("Joya no encontrada"));
        return ResponseEntity.ok(updatedJoya);
    }


}
