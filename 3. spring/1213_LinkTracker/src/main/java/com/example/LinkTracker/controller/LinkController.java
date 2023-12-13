package com.example.LinkTracker.controller;

import com.example.LinkTracker.dto.request.InvalidateLinkRequestDto;
import com.example.LinkTracker.dto.request.NewLinkRequestDto;
import com.example.LinkTracker.service.ILinkService;
import com.example.LinkTracker.service.LinkServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
public class LinkController {

    private ILinkService iLinkService;

    LinkController(LinkServiceImpl linkServiceImpl){
        this.iLinkService = linkServiceImpl;
    }

    @PostMapping("/link")
    public ResponseEntity<?> save(@RequestBody NewLinkRequestDto newLinkRequestDto){
        return ResponseEntity.ok(iLinkService.save(newLinkRequestDto));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirect(@PathVariable int linkId, @RequestParam Optional<String> password) {

        URI redirectUri = URI.create(iLinkService.redirect(linkId, password));
        return ResponseEntity.status(HttpStatus.SEE_OTHER)
                .location(redirectUri)
                .build();
    }

    @GetMapping("/link")
    public ResponseEntity<?> testLink(){
        return ResponseEntity.ok("Redirect");
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable int linkId){
        return ResponseEntity.ok(iLinkService.getMetrics(linkId));
    }

    @PostMapping("/invalidate")
    public ResponseEntity<?> invalidateLink(@RequestBody InvalidateLinkRequestDto invalidateLinkRequest){
        return ResponseEntity.ok(iLinkService.invalidateLink(invalidateLinkRequest));
    }

}
