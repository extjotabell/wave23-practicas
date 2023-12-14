package com.ejLinkTracker.ejLinkTracker.controller;
import com.ejLinkTracker.ejLinkTracker.dto.request.LinkTrackerDTO;
import com.ejLinkTracker.ejLinkTracker.dto.response.LinkMetricsResponseDTO;
import com.ejLinkTracker.ejLinkTracker.service.ILinkTrackerService;
import com.ejLinkTracker.ejLinkTracker.service.LinkTrackerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkTrackerController {

    ILinkTrackerService service;

    public LinkTrackerController(LinkTrackerServiceImpl service){
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody LinkTrackerDTO linkTracker){
        return new ResponseEntity<>(service.create(linkTracker), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectEndpoint(@PathVariable Long linkId){
        return new RedirectView(service.getRedirectUrl(linkId));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable Long linkId){
        return new ResponseEntity<>(new LinkMetricsResponseDTO(service.getMetrics(linkId)), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Long linkId){
        return new ResponseEntity<>(service.invalidate(linkId), HttpStatus.OK);
    }
}
