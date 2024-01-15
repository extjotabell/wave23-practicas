package org.ejercicio.literaryworks.controller;

import org.ejercicio.literaryworks.model.dto.LiteraryWorkDto;
import org.ejercicio.literaryworks.service.ILiteraryWorkService;
import org.ejercicio.literaryworks.service.LiteraryWorkServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/library")
public class LiteraryWorkController {

    private final ILiteraryWorkService service;

    public LiteraryWorkController(LiteraryWorkServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllLiteraryWork() {
        return new ResponseEntity<>(service.getAllLiteraryWork(), HttpStatus.OK);
    }

    @GetMapping("/find/author/{author}")
    public ResponseEntity<?> getLiteraryWorksByAuthor(@PathVariable String author) {
        return new ResponseEntity<>(service.getLiteraryWorksByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/find/title/{title}")
    public ResponseEntity<?> getLiteraryWorksByTitle(@PathVariable String title) {
        return new ResponseEntity<>(service.getLiteraryWorksByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/find/editorial/{editorial}")
    public ResponseEntity<?> getLiteraryWorksByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(service.getLiteraryWorksByEditorial(editorial), HttpStatus.OK);
    }

    @GetMapping("/find/pages/{count}")
    public ResponseEntity<?> getLiteraryWorksByPages(@PathVariable Integer count) {
        return new ResponseEntity<>(service.getLiteraryWorksByPages(count), HttpStatus.OK);
    }

    @GetMapping("/find/year/after/{year}")
    public ResponseEntity<?> getLiteraryWorksByYearAfter(@PathVariable Integer year) {
        return new ResponseEntity<>(service.getLiteraryWorksByYearAfter(year), HttpStatus.OK);
    }

    @GetMapping("/find/year/before/{year}")
    public ResponseEntity<?> getLiteraryWorksByYearBefore(@PathVariable Integer year) {
        return new ResponseEntity<>(service.getLiteraryWorksByYearBefore(year), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody LiteraryWorkDto literaryWorkDto) {
        return new ResponseEntity<>(service.saveLiteraryWork(literaryWorkDto), HttpStatus.OK);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<?> saveProducts(@RequestBody List<LiteraryWorkDto> literaryWorkDtos) {
        return new ResponseEntity<>(service.saveLiteraryWorks(literaryWorkDtos), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLiteraryWork(@PathVariable String id) {
        service.deleteLiteraryWork(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
