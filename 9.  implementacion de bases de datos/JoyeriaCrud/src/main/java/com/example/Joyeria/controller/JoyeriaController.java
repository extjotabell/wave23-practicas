package com.example.Joyeria.controller;

import com.example.Joyeria.dto.request.NewJoyaDto;
import com.example.Joyeria.dto.response.BaseResponseDto;
import com.example.Joyeria.model.Joya;
import com.example.Joyeria.service.IJoyeriaService;
import com.example.Joyeria.service.JoyeriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JoyeriaController {

    private IJoyeriaService joyeriaService;

    public JoyeriaController(JoyeriaService joyeriaService) {
        this.joyeriaService = joyeriaService;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<BaseResponseDto> saveJoya (@RequestBody NewJoyaDto joya) {
        return ResponseEntity.ok(this.joyeriaService.saveJoya(joya));
    }

    @GetMapping("/jewerly")
    public List<Joya> getJoyas () {

        return this.joyeriaService.getJoyas();
    }

    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<BaseResponseDto> deleteJoya (@PathVariable Long id) {

        return ResponseEntity.ok(this.joyeriaService.deleteJoya(id));
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<Joya> editJoya (@PathVariable Long id_modificar,
                            @RequestBody Joya joya) {

        return ResponseEntity.ok(this.joyeriaService.editJoya(id_modificar, joya));
    }
}
