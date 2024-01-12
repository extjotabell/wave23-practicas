package com.practice.obras.service;

import com.practice.obras.entity.Obra;
import com.practice.obras.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraServiceImpl {
    @Autowired
    private ObraRepository obraRepository;

    public Obra save(Obra obra) {
        return obraRepository.save(obra);
    }

    public List<Obra> listObras() {
        Iterable<Obra> iterable = obraRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }

    public List<Obra> listObrasByAutor(String autor) {
        return obraRepository.findAllByAutor(autor);
    }

    public List<Obra> listObrasWithNombreContainKeywords(String keywords) {
        return obraRepository.findAllByNombreKeywords(keywords);
    }

    public List<Obra> listObrasWithCantidadPaginasGreaterThan(String number) {
        return obraRepository.findByCantidadPaginasGreaterThan(number);
    }

    public List<Obra> listObrasWithAnioPublicacionLessThan(String year) {
        return obraRepository.findByAnioPublicacionLessThan(year);
    }

    public List<Obra> listObrasWithAnioPublicacionGreaterThan(String year) {
        return obraRepository.findByAnioPublicacionGreaterThan(year);
    }

    public List<Obra> listObrasByEditorial(String editorial) {
        return obraRepository.findAllByEditorial(editorial);
    }
}
