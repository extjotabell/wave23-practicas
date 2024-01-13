package com.example.obrasliterarias.controller;

import com.example.obrasliterarias.dto.LiteraryWorkDTO;
import com.example.obrasliterarias.service.LiteraryWorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/literaryWorks")
public class LiteraryWorkController {
    @Autowired
    private LiteraryWorkServiceImpl literaryWorkService;

    @GetMapping("/findByAuthor/{author}")
    public ResponseEntity<?> findByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(literaryWorkService.findByAuthor(author));
    }

    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<?> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(literaryWorkService.findByTitle(title));
    }

    @GetMapping("/findByPageCountGreaterThan/{pageCount}")
    public ResponseEntity<?> findByPageCountGreaterThan(@PathVariable String pageCount) {
        return ResponseEntity.ok(literaryWorkService.findByPageCountGreaterThan(pageCount));
    }

    @GetMapping("/findByFirstPublicationYearGreaterThan/{year}")
    public ResponseEntity<?> findByFirstPublicationYearGreaterThan(@PathVariable String year) {
        return ResponseEntity.ok(literaryWorkService.findByFirstPublicationYearGreaterThan(year));
    }

    @GetMapping("/findByFirstPublicationYearLessThan/{year}")
    public ResponseEntity<?> findByFirstPublicationYearLessThan(@PathVariable String year) {
        return ResponseEntity.ok(literaryWorkService.findByFirstPublicationYearLessThan(year));
    }

    @GetMapping("/findByPublisher/{publisher}")
    public ResponseEntity<?> findByPublisher(@PathVariable String publisher) {
        return ResponseEntity.ok(literaryWorkService.findByPublisher(publisher));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LiteraryWorkDTO literaryWorkDTO) {
        literaryWorkService.save(literaryWorkDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(literaryWorkService.findAll());
    }
}
