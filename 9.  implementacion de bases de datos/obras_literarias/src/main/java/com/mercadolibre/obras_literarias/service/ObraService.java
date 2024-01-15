package com.mercadolibre.obras_literarias.service;

import com.mercadolibre.obras_literarias.entity.Obra;
import com.mercadolibre.obras_literarias.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraService implements IObraService {

    @Autowired
    ObraRepository obraRepository;

    @Override
    public Obra save(Obra obra) {
        return obraRepository.save(obra);
    }

    @Override
    public List<Obra> findAll() {
        Iterable<Obra> obraIterable = obraRepository.findAll();

        return StreamSupport
                .stream(obraIterable.spliterator(), false)
                .toList();
    }

    @Override
    public List<Obra> findByAutor(String nombre) {
        return obraRepository.findByAutor(nombre);
    }

    @Override
    public List<Obra> findByTitleContainsWord(String palabra) {
        return obraRepository.findByTitleContainsWord(palabra);
    }

    @Override
    public List<Obra> findByPagesCount(Integer cantidad) {
        return obraRepository.findByPagesCount(cantidad);
    }

    @Override
    public List<Obra> findByYearBefore(Integer anio) {
        return obraRepository.findByYearBefore(anio);
    }

    @Override
    public List<Obra> findByYearAfter(Integer anio) {
        return obraRepository.findByYearAfter(anio);
    }

    @Override
    public List<Obra> findByEditorial(String editorial) {
        return obraRepository.findByEditorial(editorial);
    }
}
