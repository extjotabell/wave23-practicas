package com.mercadolibre.linkTracker.controller;

import com.mercadolibre.linkTracker.dto.request.LinkTrackerDTO;
import com.mercadolibre.linkTracker.dto.response.LinkMetricsResponseDTO;
import com.mercadolibre.linkTracker.service.ILinkTrackerService;
import com.mercadolibre.linkTracker.service.LinkTrackerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controller to handle operations related to the Link Tracker.
 */
@RestController
@RequestMapping("/api/link-tracker")
public class LinkTrackerController {

    ILinkTrackerService service;

    /**
     * Constructor for the controller that receives an implementation of ILinkTrackerService.
     *
     * @param service Implementation of ILinkTrackerService to manage Link Tracker operations.
     */
    public LinkTrackerController(LinkTrackerServiceImpl service){
        this.service = service;
    }

    /**
     * Endpoint to create a new Link Tracker link.
     *
     * @param linkTracker DTO object containing information for the new link.
     * @return ResponseEntity with the creation result and the ID of the new link.
     */
    @PostMapping
    public ResponseEntity<?> createLink(@RequestBody LinkTrackerDTO linkTracker){
        return new ResponseEntity<>(service.create(linkTracker), HttpStatus.OK);
    }

    /**
     * Endpoint to perform redirection for a specific Link Tracker link.
     *
     * @param linkId   ID of the link to redirect.
     * @param password Optional password for link validation.
     * @return RedirectView to perform the redirection.
     */
    @GetMapping("/link/{linkId}")
    public RedirectView redirectEndpoint(
            @PathVariable Long linkId,
            @RequestParam(required = false) String password) {
        return new RedirectView(service.getRedirectUrl(linkId, password));
    }

    /**
     * Endpoint to retrieve metrics for a specific Link Tracker link.
     *
     * @param linkId ID of the link to retrieve metrics for.
     * @return ResponseEntity with the metrics information.
     */
    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable Long linkId) {
        return new ResponseEntity<>(new LinkMetricsResponseDTO(service.getMetrics(linkId)), HttpStatus.OK);
    }
}
