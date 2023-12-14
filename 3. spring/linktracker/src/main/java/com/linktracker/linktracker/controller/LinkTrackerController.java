package com.linktracker.linktracker.controller;

import com.linktracker.linktracker.dto.Request.URLDTO;
import com.linktracker.linktracker.service.LinkTrackerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LinkTrackerController {

    @Autowired
    private LinkTrackerServiceImp serviceImp;
    @PostMapping("/link")
    public ResponseEntity<?> agregarURL(@RequestBody URLDTO urldto) {
        return new ResponseEntity<>(serviceImp.crearLink(urldto), HttpStatus.CREATED);
    }
    @GetMapping("/link/{linkid}")
    public ResponseEntity<?> redirect(@PathVariable Integer linkid) {
        return new ResponseEntity<>(serviceImp.crearRedireccion(linkid), HttpStatus.PERMANENT_REDIRECT);
    }

    @GetMapping("/metrics/{linkid}")
    public ResponseEntity<?> getNumeroRedirecciones(@PathVariable Integer linkid) {
        return new ResponseEntity<>(serviceImp.retornarNumeroRedirecciones(linkid), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{linkid}")
    public ResponseEntity<?> invalidar(@PathVariable Integer linkid) {
        serviceImp.invalidarLink(linkid);
        return new ResponseEntity<>("Url Invalidado: " + linkid , HttpStatus.OK);
    }

}
