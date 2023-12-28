package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.service.EntryServiceImpl;
import com.mercadolibre.blog.service.IEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing blog entries.
 */
@RestController
@RequestMapping("api/entryBlog")
public class EntryBlogController {
    IEntryService service;

    /**
     * Constructor for EntryBlogController.
     *
     * @param service Entry service implementation.
     */
    public EntryBlogController(EntryServiceImpl service){
        this.service = service;
    }

    /**
     * Endpoint for creating a new blog entry.
     *
     * @param entry The blog entry data.
     * @return ResponseEntity with the created blog entry and HTTP status OK.
     */
    @PostMapping("/create")
    public ResponseEntity<?> createBlog(@RequestBody EntryBlogDTO entry){
        return new ResponseEntity<>(service.createBlog(entry),HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving a blog entry by ID.
     *
     * @param id The ID of the blog entry.
     * @return ResponseEntity with the retrieved blog entry and HTTP status OK.
     */
    @GetMapping("/getBlog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Long id){
        return new ResponseEntity<>(service.getBlogById(id), HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving all blog entries.
     *
     * @return ResponseEntity with the list of all blog entries and HTTP status OK.
     */
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
