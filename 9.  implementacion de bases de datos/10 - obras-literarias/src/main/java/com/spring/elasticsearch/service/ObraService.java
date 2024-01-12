package com.spring.elasticsearch.service;

import com.spring.elasticsearch.model.ObraLiteraria;
import com.spring.elasticsearch.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraService {

    @Autowired
    private ObraRepository repository;
    public List<ObraLiteraria> getAll(){
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }

    public ObraLiteraria save(ObraLiteraria obraLiteraria) {
        return repository.save(obraLiteraria);
    }

    public List<ObraLiteraria> findByAutor(String nombre) {
        return repository.findByAutor(nombre);
    }

    public List<ObraLiteraria> findByObra(String obraName) {
        return repository.findByNombreContaining(obraName);
    }

    public List<ObraLiteraria> findByPages(Integer pages) {
        return repository.findByCantidadDePaginasGreaterThan(pages);
    }

    public List<ObraLiteraria> findByYearBefore(Integer year) {
        return repository.findByAnioPublicacionLessThan(year);
    }

    public List<ObraLiteraria> findByYearAfter(Integer year) {
        return repository.findByAnioPublicacionGreaterThanEqual(year);
    }

    public List<ObraLiteraria> findByEditorial(String editorial) {
        return repository.findByEditorial(editorial);
    }
}
