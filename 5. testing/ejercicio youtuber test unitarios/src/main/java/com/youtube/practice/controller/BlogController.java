package com.youtube.practice.controller;

import com.youtube.practice.dto.BlogEntriesDTO;
import com.youtube.practice.dto.BlogEntryDTO;
import com.youtube.practice.dto.response.BlogEntryResponse;
import com.youtube.practice.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping (path = "/newBlogEntry")
    public ResponseEntity<BlogEntryResponse> newBlogEntry(@RequestBody BlogEntryDTO blogEntryDTO) {
        return ResponseEntity.ok(blogService.addNewEntry(blogEntryDTO));
    }

    @GetMapping (path = "/findBlog/{id}")
    public ResponseEntity<BlogEntryDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(blogService.findById(id));
    }

    @GetMapping (path = "/blogs")
    public ResponseEntity<BlogEntriesDTO> getAll() {
        return ResponseEntity.ok(blogService.getAll());
    }
}
