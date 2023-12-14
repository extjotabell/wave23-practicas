package org.ejercicio.linktracker.controller;

import org.ejercicio.linktracker.entity.Link;
import org.ejercicio.linktracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {
    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping()
    public ResponseEntity<?> addLink(@RequestBody Link link) {
        return new ResponseEntity<>(this.linkService.addLink(link), HttpStatus.OK);
    }

    @GetMapping("/{linkId}")
    public RedirectView redirectLinkById(@PathVariable Integer linkId, @RequestParam String password) {
        return new RedirectView(linkService.redirectLinkById(linkId, password));
    }

    @PutMapping("/invalidate/{idLink}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer idLink) {
        return new ResponseEntity<>(this.linkService.deleteLink(idLink), HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetricLink(@PathVariable Integer linkId) {
        return new ResponseEntity<>(this.linkService.getMetricsLink(linkId), HttpStatus.OK);
    }

}
