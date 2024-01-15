package com.example.obrasLiterarias.service;

import com.example.obrasLiterarias.model.ObraLiteraria;
import com.example.obrasLiterarias.repository.IObrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.StreamSupport;

import java.util.List;

@Service
public class ObrasService {
    @Autowired
    IObrasRepository repository;

    //Crear obra literaria
    public ObraLiteraria save(ObraLiteraria obraLiteraria) {
        return repository.save(obraLiteraria);
    }

    //Retornar todas las obras literarias
    public List<ObraLiteraria> getAll(){
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }

    //Retornar las obras de un autor dado por el usuario.
    public List<ObraLiteraria> findByAutor(String autor){
        return StreamSupport.stream(repository.findByAutor(autor).spliterator(), false).toList();
    }

    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    public List<ObraLiteraria> findByTitle(String nombre){
        return StreamSupport.stream(repository.findByTitle(nombre).spliterator(), false).toList();
    }

    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    public List<ObraLiteraria> findByQPages(Integer cantidadPaginas){
        return StreamSupport.stream(repository.findByQPages(cantidadPaginas).spliterator(), false).toList();
    }

    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario
    // (crear 2 endpoints).
    public List<ObraLiteraria> findByYearBefore(Integer anioPublicacion){
        return StreamSupport.stream(repository.findByYearBefore(anioPublicacion).spliterator(), false).toList();
    }

    public List<ObraLiteraria> findByYearAfter(Integer anioPublicacion){
        return StreamSupport.stream(repository.findByYearAfter(anioPublicacion).spliterator(), false).toList();
    }

    //Retornar las obras de una misma editorial.
    public List<ObraLiteraria> findByEditorial(String editorial){
        return StreamSupport.stream(repository.findByEditorial(editorial).spliterator(), false).toList();
    }
}
