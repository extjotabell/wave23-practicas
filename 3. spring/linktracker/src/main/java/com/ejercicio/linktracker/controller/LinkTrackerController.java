package com.ejercicio.linktracker.controller;

import com.ejercicio.linktracker.dto.request.RequestLinkDto;
import com.ejercicio.linktracker.service.LinkTrackerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkTrackerController {

    @Autowired
    LinkTrackerServiceImpl linkTrackerService;

    @PostMapping("/createLink")
    public ResponseEntity<?> createLink(@RequestBody RequestLinkDto urlDto) {
        return new ResponseEntity<>(linkTrackerService.createLink(urlDto), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkid}")
    public ResponseEntity<?> redirect(@PathVariable Integer linkid) {
        return new ResponseEntity<>(linkTrackerService.redirect(linkid), HttpStatus.PERMANENT_REDIRECT);
    }

    @GetMapping("/metrics/{linkid}")
    public ResponseEntity<?> getRedirecNumber(@PathVariable Integer linkid) {
        return new ResponseEntity<>(linkTrackerService.returnRedirecNumber(linkid), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{linkid}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkid) {
        return new ResponseEntity<>(linkTrackerService.invalidateLink(linkid), HttpStatus.OK);
    }

}
