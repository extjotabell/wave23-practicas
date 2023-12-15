package com.mercadolibre.linktracker.controllers;

import com.mercadolibre.linktracker.dtos.requests.UrlResquestDto;
import com.mercadolibre.linktracker.services.ILinkTrackerService;
import com.mercadolibre.linktracker.services.LinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkTrackerController {

    ILinkTrackerService service;

    public LinkTrackerController(LinkTrackerService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UrlResquestDto data){
        return new ResponseEntity<>(service.create(data), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable int linkId,@RequestParam String password){
        return new RedirectView(service.redirect(linkId,password));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> metrics(@PathVariable int linkId){
        return new ResponseEntity<>(service.metrics(linkId), HttpStatus.OK);
    }

    @PutMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidate(@PathVariable int linkId){
        return new ResponseEntity<>(service.invalidate(linkId), HttpStatus.OK);
    }
}
