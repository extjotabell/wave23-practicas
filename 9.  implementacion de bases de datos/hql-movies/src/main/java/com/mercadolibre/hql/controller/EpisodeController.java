package com.mercadolibre.hql.controller;

import com.mercadolibre.hql.dto.EpisodeDTO;
import com.mercadolibre.hql.service.EpisodeService;
import com.mercadolibre.hql.service.IEpisodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    IEpisodeService episodeService;
    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/actors/{lastName}")
    public ResponseEntity<List<EpisodeDTO>> findAllByActorLastName(@PathVariable String lastName) {
        return new ResponseEntity<List<EpisodeDTO>>(episodeService.findAllByActorLastName(lastName), HttpStatus.OK);
    }
}
