package com.jpa.hql.controller;

import com.jpa.hql.model.dto.EpisodeDTO;
import com.jpa.hql.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    @Autowired
    IEpisodeService episodeService;
    @GetMapping("")
    ResponseEntity<Set<EpisodeDTO>> getEpisodesByFirstAndLastNameAutor(
            @RequestParam String firstName,
            @RequestParam String lastName
    ){
        return ResponseEntity.ok(episodeService.getEpisodesByFirstAndLastNameAutor(firstName, lastName));
    }

}
