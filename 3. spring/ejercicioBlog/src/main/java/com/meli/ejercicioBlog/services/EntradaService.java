package com.meli.ejercicioBlog.services;

import com.meli.ejercicioBlog.dtos.request.EntradaBlogCreacionRequestDTO;
import com.meli.ejercicioBlog.dtos.response.EntradaBlogListaResponseDTO;
import com.meli.ejercicioBlog.dtos.response.EntradaBlogResponseDTO;
import com.meli.ejercicioBlog.exceptions.AlreadyExistsException;
import com.meli.ejercicioBlog.exceptions.ResourceNotFoundException;
import com.meli.ejercicioBlog.model.EntradaBlog;
import com.meli.ejercicioBlog.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService implements IEntradaService {
    @Autowired
    private EntradaRepository repo;

    @Override
    public String crear(EntradaBlogCreacionRequestDTO entrada) {
        EntradaBlog dto = EntradaBlogCreacionRequestDTO.DtoToEntity(entrada);
        String res = repo.create(dto);
        if(res == null){
            throw new AlreadyExistsException("Una entrada con este id ya existe");
        }
        return res;
    }

    @Override
    public EntradaBlogResponseDTO find(String id) {
        EntradaBlog entrada = repo.find(id);
        if(entrada == null){
            throw new ResourceNotFoundException("No existe una entrada con ese id");
        }
        return EntradaBlogResponseDTO.entityToDto(entrada);
    }

    @Override
    public EntradaBlogListaResponseDTO getAll() {
        List<EntradaBlog> entradas = repo.getAll();
        if(entradas.isEmpty()){
            throw new ResourceNotFoundException("No hay entradas");
        }
        return new EntradaBlogListaResponseDTO(entradas.stream().map(EntradaBlogResponseDTO::entityToDto).toList());
    }
}
