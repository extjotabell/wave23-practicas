package com.example.ejercicioHQL.controller;

import com.example.ejercicioHQL.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private IActorService actorService;

    @GetMapping("/findHasFavoriteMovie")
    public ResponseEntity<?> findByHasFavoriteMovie(){
        return ResponseEntity.ok(actorService.findByHasFavoriteMovie());
    }

    @GetMapping("/findActorByRating/{rating}")
    public ResponseEntity<?> findByRating(@PathVariable Double rating){
        return ResponseEntity.ok(actorService.findByRating(rating));
    }

}
