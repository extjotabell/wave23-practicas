package spring.elastic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.elastic.domain.Articulo;
import spring.elastic.respository.ArticuloRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/articulos")
public class Controller {
    @Autowired
    private ArticuloRepository repository;
    @PostMapping
    public Articulo create(@RequestBody Articulo articulo) {
        return repository.save(articulo);
    }
    @GetMapping("/{id}")
    public Optional<Articulo> findById(@PathVariable String id) {
        return repository.findById(id);
    }

    @GetMapping
    public Iterable<Articulo> findAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Articulo update(@PathVariable String id, @RequestBody Articulo articulo) {
        articulo.setId(id);
        return repository.save(articulo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}

