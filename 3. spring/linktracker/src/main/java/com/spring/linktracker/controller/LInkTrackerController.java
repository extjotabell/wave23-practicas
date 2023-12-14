package com.spring.linktracker.controller;

import com.spring.linktracker.dto.request.LinkRequestDto;
import com.spring.linktracker.dto.response.LinkResponseDto;
import com.spring.linktracker.service.interfaces.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LInkTrackerController {

    @Autowired
    private ILinkService _service;

    @PostMapping("/create")
    public ResponseEntity<LinkResponseDto> createLink(@RequestBody LinkRequestDto link) {
        return new ResponseEntity<>(_service.createLink(link), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable int linkId, @RequestParam String password) {

        String url = _service.redirect(linkId, password).getUrl();

        RedirectView redirect = new RedirectView();
        redirect.setUrl(url);
        return redirect;
    }

    @PutMapping("/invalidate/{idLink}")
    public ResponseEntity<?> invalidateLink(@PathVariable int idLink){
        return ResponseEntity.status(200).body(_service.deleteLink(idLink));
    }

    @GetMapping("/metrica/{linkId}")
    public ResponseEntity<?> getMetricaLink(@PathVariable int linkId){
        return ResponseEntity.ok(_service.metrics(linkId));
    }
}
