package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.service.EntryServiceImpl;
import com.mercadolibre.blog.service.IEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/entryBlog")
public class EntryBlogController {
    IEntryService service;

    public EntryBlogController(EntryServiceImpl service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBlog(@RequestBody EntryBlogDTO entry){
        return new ResponseEntity<>(service.createBlog(entry),HttpStatus.OK);
    }

    @GetMapping("/getBlog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Long id){
        return new ResponseEntity<>(service.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
