package com.example.linkTracker.controller;

import com.example.linkTracker.service.LinkServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/link")
public class LinkController {

    private final LinkServiceImpl linkService;

    public LinkController(LinkServiceImpl linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> crearLink(@RequestParam String url,
                                       @RequestParam(required = false) String password) {
        int id = linkService.createlink(url, password);
        return new ResponseEntity<>(Map.of("linkId", id), HttpStatus.OK);
    }

    @PostMapping("/{linkId}")
    public ResponseEntity<?> redireccionarLink(@PathVariable int linkId,
                                               @RequestParam(required = false) String password) {
        String url = linkService.redirectLink(linkId, password);
        return new ResponseEntity<>(Map.of("url", url), HttpStatus.OK);
    }

    @GetMapping("/stadistics/{linkId}")
    public ResponseEntity<?> obtenerEstadisticas(@PathVariable int linkId) {
        Map<String, Integer> estadisticas = linkService.getStadistics(linkId);
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidarLink(@PathVariable int linkId) {
        linkService.invalidateLink(linkId);
        return new ResponseEntity<>("El link fue invalidado correctamente.", HttpStatus.OK);
    }
}
