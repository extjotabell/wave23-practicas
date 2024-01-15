package com.meli.ObrasLiterarias.service;

import com.meli.ObrasLiterarias.dto.ObraDto;
import com.meli.ObrasLiterarias.entity.Obra;
import com.meli.ObrasLiterarias.exception.NotFoundException;
import com.meli.ObrasLiterarias.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraServiceImpl implements ObraService {

    ObraRepository repository;

    public ObraServiceImpl(ObraRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<ObraDto> findAll() {
        Iterable<Obra> obras = repository.findAll();

        return StreamSupport.stream(obras.spliterator(), false)
            .map(ObraDto::new)
            .toList();
    }

    @Override
    public ObraDto findById(String id) {
        Obra obra = repository.findById(id).orElseThrow(() -> new NotFoundException("Obra no encontrada"));
        return new ObraDto(obra);
    }

    @Override
    public ObraDto save(ObraDto obraDto) {
        Obra obraToSave = new Obra(obraDto);
        Obra obraSaved = repository.save(obraToSave);
        return new ObraDto(obraSaved);
    }

    @Override
    public void deleteById(String id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Obra no encontrada"));
        repository.deleteById(id);
    }

    @Override
    public List<ObraDto> findByAuthor(String author) {
        Iterable<Obra> obras = repository.findByAutor(author);

        return StreamSupport.stream(obras.spliterator(), false)
            .map(ObraDto::new)
            .toList();
    }

    @Override
    public List<ObraDto> findByTituloContains(String titulo) {
        Iterable<Obra> obras = repository.findByTituloContains(titulo);

        return StreamSupport.stream(obras.spliterator(), false)
            .map(ObraDto::new)
            .toList();
    }

    @Override
    public List<ObraDto> findByCantidadPaginasGreaterThan(Integer cantidadPaginas) {
        Iterable<Obra> obras = repository.findByCantidadPaginasGreaterThan(cantidadPaginas);

        return StreamSupport.stream(obras.spliterator(), false)
            .map(ObraDto::new)
            .toList();
    }

    @Override
    public List<ObraDto> findByYearPublicacionBefore(Integer yearPublicacion) {
        Iterable <Obra> obras = repository.findByYearPublicacionBefore(yearPublicacion);

        return StreamSupport.stream(obras.spliterator(), false)
            .map(ObraDto::new)
            .toList();
    }

    @Override
    public List<ObraDto> findByYearPublicacionAfter(Integer yearPublicacion) {
        Iterable <Obra> obras = repository.findByYearPublicacionAfter(yearPublicacion);

        return StreamSupport.stream(obras.spliterator(), false)
            .map(ObraDto::new)
            .toList();
    }

    @Override
    public List<ObraDto> findByEditorial(String editorial) {
        Iterable <Obra> obras = repository.findByEditorial(editorial);

        return StreamSupport.stream(obras.spliterator(), false)
            .map(ObraDto::new)
            .toList();
    }
}
