package com.meli.MiniSeries.controller;

import com.meli.MiniSeries.dto.MessageDTO;
import com.meli.MiniSeries.dto.MiniSerieReqDTO;
import com.meli.MiniSeries.dto.MiniSerieResDTO;
import com.meli.MiniSeries.service.IMiniSerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miniseries")
public class MiniSerieController {

    private IMiniSerieService service;

    public MiniSerieController(IMiniSerieService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<MiniSerieResDTO> create(@RequestBody MiniSerieReqDTO miniSerieReqDTO) {
        MiniSerieResDTO response = service.save(miniSerieReqDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<MiniSerieResDTO>> findAll() {
        List<MiniSerieResDTO> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiniSerieResDTO> findById(@PathVariable Long id) {
        MiniSerieResDTO response = service.find(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MiniSerieResDTO> update(@PathVariable Long id, @RequestBody MiniSerieReqDTO miniSerieReqDTO) {
        MiniSerieResDTO response = service.update(id, miniSerieReqDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> delete(@PathVariable Long id) {
        MessageDTO response = service.delete(id);
        return ResponseEntity.ok(response);
    }
}
