package meli.bootcamp.spring.learning.ej10.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.ej10.dto.request.NuevaEntradaDto;
import meli.bootcamp.spring.learning.ej10.dto.response.BaseDto;
import meli.bootcamp.spring.learning.ej10.dto.response.EntradaBlogDto;
import meli.bootcamp.spring.learning.ej10.service.impl.BlogService;

@RestController
@RequestMapping("ej10")
public class BlogController {
  private BlogService service;

  public BlogController(BlogService service) {
    this.service = service;
  }

  @PostMapping("blog")
  public ResponseEntity<BaseDto> crear(@RequestBody NuevaEntradaDto nuevo) {
    BaseDto respuesta = service.crearBlog(nuevo);
    return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
  }

  @GetMapping("blog/{id}")
  public ResponseEntity<EntradaBlogDto> obtenerPorId(@PathVariable Integer id) {
    EntradaBlogDto respuesta = service.obtenerBlogPorId(id);
    return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
  }

  @GetMapping("blogs")
  public ResponseEntity<List<EntradaBlogDto>> obtenerTodos() {
    List<EntradaBlogDto> respuesta = service.obtenerTodos();
    return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
  }
}
