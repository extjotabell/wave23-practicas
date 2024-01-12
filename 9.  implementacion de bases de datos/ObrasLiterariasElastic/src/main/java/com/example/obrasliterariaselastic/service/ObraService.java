package com.example.obrasliterariaselastic.service;

import com.example.obrasliterariaselastic.entity.Autor;
import com.example.obrasliterariaselastic.entity.Obra;
import com.example.obrasliterariaselastic.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraService {

    private final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public Obra save(Obra empleado){
        return obraRepository.save(empleado);
    }

    public List<Obra> getAll(){
        Iterable<Obra> obraIterable = obraRepository.findAll();

        return StreamSupport
                .stream(obraIterable.spliterator(), false)
                .toList();
    }

    public List<Obra> findByAutor(String nombre) {
        return obraRepository.findByAutor(nombre);
    }

    public List<Obra> findByTituloContaining(String titulo) {
        return obraRepository.findByTituloContaining(titulo);
    }

    public List<Obra> findByPaginasGreaterThan(Integer paginas) {
        return obraRepository.findByPaginasGreaterThan(paginas);
    }

    public List<Obra> findByFechaGreaterThan(Integer fecha) {
        return obraRepository.findByFechaGreaterThan(fecha);
    }

    public List<Obra> findByFechaIsLessThan(Integer fecha) {
        return obraRepository.findByFechaIsLessThan(fecha);
    }
}
