package com.meli.elasticsearchobras.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.elasticsearchobras.domain.DTO.ObraDTO;
import com.meli.elasticsearchobras.domain.DTO.ObrasDTO;
import com.meli.elasticsearchobras.domain.Obra;
import com.meli.elasticsearchobras.repository.IObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraServiceImpl implements IObraService {
    private final IObraRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public ObraServiceImpl(IObraRepository repository) {
        this.repository = repository;
    }

    @Override
    public ObraDTO save(ObraDTO obra) {
        repository.save(mapper.convertValue(obra, Obra.class));
        return obra;
    }

    @Override
    public ObrasDTO findAll() {
        Iterable<Obra> iterable = repository.findAll();
        return new ObrasDTO(mapIterableObraToListObraDTO(iterable));
    }

    @Override
    public ObrasDTO findByAutor(String autor) {
        Iterable<Obra> iterable = repository.findByAuthor(autor);
        return new ObrasDTO(mapIterableObraToListObraDTO(iterable));
    }

    @Override
    public ObrasDTO findByNombre(String nombre) {
        Iterable<Obra> iterable = repository.findByNombre(nombre);
        return new ObrasDTO(mapIterableObraToListObraDTO(iterable));
    }

    private List<ObraDTO> mapIterableObraToListObraDTO(Iterable<Obra> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(obra -> mapper.convertValue(obra, ObraDTO.class))
                .toList();
    }
}
