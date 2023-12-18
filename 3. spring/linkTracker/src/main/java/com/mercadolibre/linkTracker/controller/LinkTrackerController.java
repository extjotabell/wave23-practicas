package com.mercadolibre.linkTracker.controller;

import com.mercadolibre.linkTracker.dto.request.LinkTrackerDTO;
import com.mercadolibre.linkTracker.dto.response.LinkMetricsResponseDTO;
import com.mercadolibre.linkTracker.entity.LinkTracker;
import com.mercadolibre.linkTracker.service.ILinkTrackerService;
import com.mercadolibre.linkTracker.service.LinkTrackerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/link-tracker")
public class LinkTrackerController {

    ILinkTrackerService service;

    public LinkTrackerController(LinkTrackerServiceImpl service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createLink(@RequestBody LinkTrackerDTO linkTracker){
        return new ResponseEntity<>(service.create(linkTracker), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectEndpoint(@PathVariable Long linkId){
        return new RedirectView(service.getRedirectUrl(linkId));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable Long linkId){
        return new ResponseEntity<>(new LinkMetricsResponseDTO(service.getMetrics()), HttpStatus.OK);
    }
}
