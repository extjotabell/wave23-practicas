package com.meli.linktracker.controller;

import com.meli.linktracker.dto.request.CreateLinkRequestDto;
import com.meli.linktracker.dto.response.CreateLinkResponseDto;
import com.meli.linktracker.dto.response.InvalidateDto;
import com.meli.linktracker.dto.response.MetricsDto;
import com.meli.linktracker.dto.response.RedirectDto;
import com.meli.linktracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkTrackerController {

    @Autowired
    private ILinkTrackerService service;

    @PostMapping("/link/{linkId}")
    public ResponseEntity<CreateLinkResponseDto> createLink(@PathVariable String linkId, @RequestBody CreateLinkRequestDto createLinkRequestDto) {
        CreateLinkResponseDto response = service.createLink(linkId, createLinkRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectLink(@PathVariable String linkId, @RequestParam(required = false) String password) {
        RedirectDto response = service.getLink(linkId, password);
        String targetUrl = response.getUrl();

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(targetUrl);

        return redirectView;
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<MetricsDto> getMetrics(@PathVariable String linkId) {
        MetricsDto response = service.getMetrics(linkId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<InvalidateDto> invalidateLink(@PathVariable String linkId) {
        InvalidateDto response = service.invalidateLink(linkId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
