package com.example.linktracker.controller;


import com.example.linktracker.entity.Link;
import com.example.linktracker.service.ILinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectLinkById(@PathVariable Long linkId, @RequestParam String password){
        return new RedirectView(linkService.redirectLinkById(linkId, password));
    }

    @PostMapping("/link")
    public ResponseEntity<?> addLink(@RequestBody Link link){
        return ResponseEntity.status(200).body(linkService.addLink(link));
    }

    @PutMapping("/invalidate/{idLink}")
    public ResponseEntity<?> invalidateLink(@PathVariable Long idLink){
        return ResponseEntity.status(200).body(linkService.deleteLink(idLink));
    }

    @GetMapping("/metrica/{linkId}")
    public ResponseEntity<?> getMetricaLink(@PathVariable Long linkId){
        return ResponseEntity.ok(linkService.getMetricaLink(linkId));
    }
}
