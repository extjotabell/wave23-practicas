package com.implementationbd.movie.controller;

import com.implementationbd.movie.model.dto.EpisodeDto;
import com.implementationbd.movie.service.interfaces.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/episode")
public class EpisodeController {

    @Autowired
    IEpisodeService service;

    @GetMapping("/with-actor/{actorId}")
    public ResponseEntity<List<EpisodeDto>> getAllEpisodesWithActor(@PathVariable Long actorId) {
        return new ResponseEntity<>(service.getAllEpisodesWithActor(actorId), HttpStatus.OK);
    }
}
