package com.meli.blog.controller;

import com.meli.blog.dto.EntryRequestDto;
import com.meli.blog.dto.EntryResponseDto;
import com.meli.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> createEntry(@RequestBody EntryRequestDto entry) {
        EntryResponseDto entryResponseDto = blogService.createEntry(entry);

        return new ResponseEntity<>(entryResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getEntry(@PathVariable Integer id) {
        EntryResponseDto entryResponseDto = blogService.getEntry(id);

        return new ResponseEntity<>(entryResponseDto, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getEntries() {
        List<EntryResponseDto> entries = blogService.getAllEntries();

        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

}
