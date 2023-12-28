package com.mercadolibre.PracticaIntegradoraBlog.Controller;

import com.mercadolibre.PracticaIntegradoraBlog.Service.BlogService;
import com.mercadolibre.PracticaIntegradoraBlog.Service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/blog")
public class BlogController {

    IBlogService service;

    public BlogController(BlogService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> crearBlog(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
