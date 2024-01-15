package com.meli.bootcamp.obraliteraria.service;

import com.meli.bootcamp.obraliteraria.dto.ObraDto;
import com.meli.bootcamp.obraliteraria.entity.Obra;
import com.meli.bootcamp.obraliteraria.repository.IObraRepository;
import com.meli.bootcamp.obraliteraria.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraServiceImpl implements IObraService{
    private IObraRepository repo;

    public ObraServiceImpl(IObraRepository repo) {
        this.repo = repo;
    }

    @Override
    public ObraDto save(ObraDto obraDto) {
        return Mapper.mapToObraDto(repo.save(Mapper.mapToObra(obraDto)));
    }

    @Override
    public List<ObraDto> findAll() {
        Iterable<Obra> obraIterable = repo.findAll();
        List<Obra> obras = StreamSupport
                .stream(obraIterable.spliterator(),false)
                .collect(Collectors.toList());
        return obras
                .stream()
                .map(obra -> Mapper.mapToObraDto(obra))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByTitle(String palabras) {
        List<Obra> obras =repo.findByTitle(palabras);
        return obras
                .stream()
                .map(obra -> Mapper.mapToObraDto(obra))
                .collect(Collectors.toList());
    }


    @Override
    public List<ObraDto> findByCantidadPaginasGreaterThan(int pages) {
        List<Obra> obras = repo.findByCantidadPaginasGreaterThan(pages);
        return obras
                .stream()
                .map(obra -> Mapper.mapToObraDto(obra))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByFechaPublicacionLessThan(int year) {
        List<Obra> obras = repo.findByFechaPublicacionLessThan(year);
        return obras
                .stream()
                .map(obra -> Mapper.mapToObraDto(obra))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByFechaPublicacionGreaterThan(int year) {
        List<Obra> obras = repo.findByFechaPublicacionGreaterThan(year);
        return obras
                .stream()
                .map(obra -> Mapper.mapToObraDto(obra))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByEditorial(String editorial) {
        List<Obra> obras = repo.findByEditorial(editorial);
        return obras
                .stream()
                .map(obra -> Mapper.mapToObraDto(obra))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByAutor(String nombreAutor) {
        List<Obra> obras = repo.findByAutor(nombreAutor);
        return obras
                .stream()
                .map(obra -> Mapper.mapToObraDto(obra))
                .collect(Collectors.toList());
    }


}
