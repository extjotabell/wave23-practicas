package com.example.carga_literaria.service;

import com.example.carga_literaria.model.Obra;
import com.example.carga_literaria.repository.IObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraService {
    @Autowired
    IObraRepository repository;

    public String add(Obra obra){
        repository.save(obra);
        return "La obra ha sido almacenada";
    }

    public List<Obra> findAll(){
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Obra> findAuthor(String name){
        return repository.findAuthor(name);
    }

    public List<Obra> findTitle(String title){
        return repository.findTitle(title);
    }

    public List<Obra> findPages(Integer pages) {
        return repository.findPages(pages);
    }

    public List<Obra> findLowerYear(Integer year){
        return repository.findLowerYear(year);
    }

    public List<Obra> findGreaterYear(Integer year){
        return repository.findGreaterYear(year);
    }

    public List<Obra> findEditorial(String editorial){
        return repository.findEditorial(editorial);
    }
}
