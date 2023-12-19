package com.ejercicio.LinkTracker.controller;

import com.ejercicio.LinkTracker.dto.request.RequestLinkDTO;
import com.ejercicio.LinkTracker.dto.response.ResponseLinkDTO;
import com.ejercicio.LinkTracker.service.ILinkService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {
    ILinkService service;

    public LinkController(ILinkService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveLink(@RequestBody RequestLinkDTO requestLink){
        return new ResponseEntity<>(service.saveLink(requestLink), HttpStatus.OK);
    }

    @GetMapping("link/{linkId}")
    public ResponseEntity<?> getLink(@PathVariable int linkId, @RequestParam(required = false) String password){
        ResponseLinkDTO linkDto = service.searchLink(linkId, password);
        String redirectUrl = linkDto.getLink();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(redirectUrl));

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable int linkId){
        return new ResponseEntity<>(service.metricsLink(linkId), HttpStatus.OK);
    }

    @PostMapping("invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable int linkId){
        return new ResponseEntity<>(service.invalidateLink(linkId), HttpStatus.OK);
    }
}
