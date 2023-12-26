package com.ospina.blogYoutuber.controlador;

import com.ospina.blogYoutuber.modelo.comando.ComandoBlog;
import com.ospina.blogYoutuber.servicio.ServicioBlog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/blog")
public class ControladorBlog {
    private final ServicioBlog servicioBlog;
    private static final String SUCCESS_MESSAGE = "Se creo la entrada de blog con exito con el id: ";

    public ControladorBlog(ServicioBlog servicioBlog) {
        this.servicioBlog = servicioBlog;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> crearBlog(@RequestBody ComandoBlog comandoBlog) {
        int id = servicioBlog.crearEntradaBlog(comandoBlog);
        return ResponseEntity.ok(SUCCESS_MESSAGE + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerBlogPorId(@PathVariable int id) {
        return ResponseEntity.ok(servicioBlog.obtenerEntradaBlogPorId(id));
    }

    @GetMapping("/obtenerEntradas")
    public ResponseEntity<?> obtenerEntradasBlog() {
        return ResponseEntity.ok(servicioBlog.obtenerEntradasBlog());
    }
}
