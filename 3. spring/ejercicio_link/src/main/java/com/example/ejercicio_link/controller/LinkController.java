package com.example.ejercicio_link.controller;


import com.example.ejercicio_link.dto.request.SaveLinkDto;
import com.example.ejercicio_link.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class LinkController {
    @Autowired
    ILinkService service;

    @PostMapping("/addlink")
    public ResponseEntity<?> saveLink(@RequestBody SaveLinkDto linkDto){
        return new ResponseEntity<>(service.saveLink(linkDto), HttpStatus.CREATED);
    }

    @GetMapping("link/{id}")
    public RedirectView showLink(@PathVariable int id){
        return new RedirectView(service.showLink(id));
    }

    @GetMapping("invalidate/{id}")
    public ResponseEntity<?> invalidateLink(@PathVariable int id){
        return new ResponseEntity<>(service.invalidLink(id), HttpStatus.OK);
    }
}
