package com.example.obrasliterariasnosql.service;

import com.example.obrasliterariasnosql.entity.ObraLiteraria;
import com.example.obrasliterariasnosql.repository.ObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraLiterariaService {
    @Autowired
    private ObraLiterariaRepository obraLiterariaRepository;
    public ObraLiteraria save(ObraLiteraria obraLiteraria){
        return obraLiterariaRepository.save(obraLiteraria);
    }
    public List<ObraLiteraria> getAll(){
        Iterable<ObraLiteraria> obraLiterariaIterable = obraLiterariaRepository.findAll();

        List<ObraLiteraria> obraLiterariaList = StreamSupport
                .stream(obraLiterariaIterable.spliterator(), false)
                .collect(Collectors.toList());

        return obraLiterariaList;
    }
    public List<ObraLiteraria> findByAutor(String autor) {
        return obraLiterariaRepository.findByAutor(autor);
    }
    public List<ObraLiteraria> findByCantidadPaginasGreaterThanEqual(Integer cantidadPaginas) {
        return obraLiterariaRepository.findByCantidadPaginasGreaterThanEqual(cantidadPaginas);
    }
    public List<ObraLiteraria> findByAnioPrimeraPublicacionGreaterThanEqual(Integer anioPrimeraPublicacion){
        return obraLiterariaRepository.findByAnioPrimeraPublicacionGreaterThanEqual(anioPrimeraPublicacion);
    }
    public List<ObraLiteraria> findByAnioPrimeraPublicacionLessThanEqual(Integer anioPrimeraPublicacion){
        return obraLiterariaRepository.findByAnioPrimeraPublicacionLessThanEqual(anioPrimeraPublicacion);
    }

    public List<ObraLiteraria> findbyEditorial(String editorial){
        return obraLiterariaRepository.findByEditorial(editorial);
    }
}
