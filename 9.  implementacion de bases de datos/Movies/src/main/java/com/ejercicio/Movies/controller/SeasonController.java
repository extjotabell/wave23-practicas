package com.ejercicio.Movies.controller;

import com.ejercicio.Movies.service.SeasonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seasons")
public class SeasonController {
    @Autowired
    private SeasonServiceImpl seasonService;

    @GetMapping("/actor/{fullName}")
    public ResponseEntity<?> findSeasonsByActor(@PathVariable String fullName) {
        return new ResponseEntity<>(seasonService.findSeasonsByActor(fullName), HttpStatus.OK);
    }
}
