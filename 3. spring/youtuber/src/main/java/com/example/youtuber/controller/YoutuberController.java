package com.example.youtuber.controller;

import com.example.youtuber.dto.EntradaBlogDTO;
import com.example.youtuber.service.IYoutuberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class YoutuberController {

    private final IYoutuberService youtuberService;

    public YoutuberController(IYoutuberService youtuberService) {
        this.youtuberService = youtuberService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EntradaBlogDTO entradaBlogDTO) {
        youtuberService.create(entradaBlogDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        return ResponseEntity.ok(youtuberService.get(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(youtuberService.getAll());
    }
}
