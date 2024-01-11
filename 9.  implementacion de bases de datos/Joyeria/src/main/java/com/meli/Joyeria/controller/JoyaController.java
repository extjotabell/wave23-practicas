package com.meli.Joyeria.controller;

import com.meli.Joyeria.dto.MessageDTO;
import com.meli.Joyeria.model.Joya;
import com.meli.Joyeria.service.IJoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    IJoyaService service;

    public JoyaController(IJoyaService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<Joya> create(@RequestBody Joya joya) {
        Joya newJoya = service.save(joya);
        return ResponseEntity.ok(newJoya);
    }

    @GetMapping("/")
    public ResponseEntity<List<Joya>> getAll() {
        List<Joya> joyas = service.findAll();
        return ResponseEntity.ok(joyas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joya> getById(@PathVariable Long id) {
        Joya joya = service.findById(id);
        return ResponseEntity.ok(joya);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Joya> update(@PathVariable Long id, @RequestBody Joya joya) {
        Joya updatedJoya = service.update(id, joya);
        return ResponseEntity.ok(updatedJoya);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> delete(@PathVariable Long id) {
        service.delete(id);
        MessageDTO message = new MessageDTO("Joya eliminada");
        return ResponseEntity.ok(message);
    }
}
