package org.bootcamp.obrasliterarias.service;

import org.bootcamp.obrasliterarias.model.entity.Obra;
import org.bootcamp.obrasliterarias.repository.IObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraServiceImpl implements IObraService{

    @Autowired
    private IObraRepository repository;

    @Override
    public Obra save(Obra obra) {
        return repository.save(obra);
    }

    @Override
    public List<Obra> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Obra> findByAutor(String autor) {
        return repository.findByAutor(autor);
    }

    @Override
    public List<Obra> findByTitle(String titulo) {
        return repository.findByTitle(titulo);
    }

    @Override
    public List<Obra> findByAmountOfPages(Integer paginas) {
        return repository.findByAmountOfPages(paginas);
    }

    @Override
    public List<Obra> findByYearBefore(Integer anio) {
        return repository.findByYearBefore(anio);
    }

    @Override
    public List<Obra> findByYearAfter(Integer anio) {
        return repository.findByYearAfter(anio);
    }

    @Override
    public List<Obra> findByEditorial(String editorial) {
        return repository.findByEditorial(editorial);
    }

}
