package com.example.clasenosql.service;

import com.example.clasenosql.entity.Obra;
import com.example.clasenosql.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {
    @Autowired
    ObraRepository obraRepository;

    public Obra save(Obra obra) {
        obraRepository.save(obra);
        return obra;
    }

    public Iterable<Obra> getAll() {
        return obraRepository.findAll();
    }

    public List<Obra> getAllByAutor(String autor) {
        return obraRepository.findAllByAutor(autor);
    }
}
