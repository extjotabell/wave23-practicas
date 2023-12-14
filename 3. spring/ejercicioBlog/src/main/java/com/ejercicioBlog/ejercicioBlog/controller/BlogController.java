package com.ejercicioBlog.ejercicioBlog.controller;
import com.ejercicioBlog.ejercicioBlog.dto.request.BlogRequestDTO;
import com.ejercicioBlog.ejercicioBlog.service.BlogServiceImpl;
import com.ejercicioBlog.ejercicioBlog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    IBlogService service;

    public BlogController(BlogServiceImpl service){
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<?>crearBlog(@RequestBody BlogRequestDTO blogrequest){
        return new ResponseEntity<>(service.crearBlog(blogrequest), HttpStatus.OK);

    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?>buscarId(@PathVariable Integer id){
        return new ResponseEntity<>(service.buscarId(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?>buscarTodos(){
        return new ResponseEntity<>(service.buscarTodos(), HttpStatus.OK);
    }
}
