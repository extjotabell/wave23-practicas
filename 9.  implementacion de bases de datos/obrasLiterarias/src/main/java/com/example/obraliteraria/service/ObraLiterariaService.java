package com.example.obraliteraria.service;

import com.example.obraliteraria.entity.ObraLiteraria;
import com.example.obraliteraria.repository.IObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService {

    @Autowired
    private IObraLiterariaRepository repository;


    public ObraLiteraria save(ObraLiteraria obraLiteraria){
        return repository.save(obraLiteraria);
    }

    public List<ObraLiteraria> findByAutorNombre(String autorNombre) {
        return repository.findByAutorNombre(autorNombre);
    }

    public List<ObraLiteraria> findByNombre(String title) {
        return repository.findByNombre(title);
    }

    public List<ObraLiteraria> findByPaginas(int paginas) {
        return repository.findByPaginasGreaterThan(paginas);
    }

    public List<ObraLiteraria> findByYearFrom(int fromYear) {
        return  repository.findByAñoPublicacionGreaterThanEqual(fromYear);
    }

    public List<ObraLiteraria> findByYearUntil(int fromYear) {
        return  repository.findByAñoPublicacionLessThanEqual(fromYear);
    }

    public List<ObraLiteraria> findByEditorial(String editorial) {
        return repository.findByEditorial(editorial);
    }
}
