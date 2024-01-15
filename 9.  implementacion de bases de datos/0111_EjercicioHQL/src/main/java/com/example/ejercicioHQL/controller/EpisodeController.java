package com.example.ejercicioHQL.controller;

import com.example.ejercicioHQL.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episode")
public class EpisodeController {

    @Autowired
    IEpisodeService episodeService;

    @GetMapping("/actor/firstName/{firstName}/lastName/{lastName}")
    public ResponseEntity<?> findByActorsMatches(@PathVariable String firstName,
                                                 @PathVariable String lastName){
        return ResponseEntity.ok(episodeService.findByActorsMatches(firstName, lastName));
    }

}
