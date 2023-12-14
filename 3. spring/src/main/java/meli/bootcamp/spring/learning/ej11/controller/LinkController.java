package meli.bootcamp.spring.learning.ej11.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import meli.bootcamp.spring.learning.ej11.dto.MessageDto;
import meli.bootcamp.spring.learning.ej11.dto.request.InvalidateLinkRequestDto;
import meli.bootcamp.spring.learning.ej11.dto.request.NewLinkRequestDto;
import meli.bootcamp.spring.learning.ej11.dto.response.LinkMetricsDto;
import meli.bootcamp.spring.learning.ej11.dto.response.NewLinkResponseDto;
import meli.bootcamp.spring.learning.ej11.service.ILinkService;
import meli.bootcamp.spring.learning.ej11.service.LinkServiceImpl;

import java.net.URI;
import java.util.Optional;

@RestController
public class LinkController {

  private ILinkService iLinkService;

  LinkController(LinkServiceImpl linkServiceImpl) {
    this.iLinkService = linkServiceImpl;
  }

  @PostMapping("/link")
  public ResponseEntity<NewLinkResponseDto> save(@RequestBody NewLinkRequestDto newLinkRequestDto) {
    return ResponseEntity.ok(iLinkService.save(newLinkRequestDto));
  }

  @GetMapping("/link/{linkId}")
  public ResponseEntity<Void> redirect(@PathVariable int linkId, @RequestParam Optional<String> password) {

    URI redirectUri = URI.create(iLinkService.redirect(linkId, password));
    return ResponseEntity.status(HttpStatus.SEE_OTHER)
        .location(redirectUri)
        .build();
  }

  @GetMapping("/metrics/{linkId}")
  public ResponseEntity<LinkMetricsDto> getMetrics(@PathVariable int linkId) {
    return ResponseEntity.ok(iLinkService.getMetrics(linkId));
  }

  @PostMapping("/invalidate")
  public ResponseEntity<MessageDto> invalidateLink(@RequestBody InvalidateLinkRequestDto invalidateLinkRequest) {
    return ResponseEntity.ok(iLinkService.invalidateLink(invalidateLinkRequest));
  }

}
