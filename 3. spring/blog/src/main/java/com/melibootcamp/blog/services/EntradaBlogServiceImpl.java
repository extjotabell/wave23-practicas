package com.melibootcamp.blog.services;

import com.melibootcamp.blog.dto.EntradaBlogDTO;
import com.melibootcamp.blog.dto.response.NuevaEntradaResponseDTO;
import com.melibootcamp.blog.dto.response.TodasLasEntradasResponseDTO;
import com.melibootcamp.blog.entity.EntradaBlog;
import com.melibootcamp.blog.exceptions.EntradaNoEncontradaException;
import com.melibootcamp.blog.exceptions.IdDuplicadoException;
import com.melibootcamp.blog.repository.IEntradaBlogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService{
    private final IEntradaBlogRepository entradaBlogRepository;

    public EntradaBlogServiceImpl(IEntradaBlogRepository repository) {
        this.entradaBlogRepository = repository;
    }

    @Override
    public NuevaEntradaResponseDTO crearEntrada(EntradaBlogDTO entradaDTO) {
        if(entradaBlogRepository.buscarPorId(entradaDTO.getId()) != null){
            throw new IdDuplicadoException("El id ya está en uso");
        }
        else{
            EntradaBlog nuevaEntrada = new EntradaBlog(entradaDTO.getId(), entradaDTO.getTituloBlog(), entradaDTO.getNombreAutor());
            entradaBlogRepository.agregarNuevaEntrada(nuevaEntrada);
            return new NuevaEntradaResponseDTO("Entrada creada exitosamente. Id: " + entradaDTO.getId());
        }
    }

    @Override
    public EntradaBlogDTO buscarEntrada(String id) {
        EntradaBlog entradaConseguida = entradaBlogRepository.buscarPorId(id);
        if (entradaConseguida == null){
            throw new EntradaNoEncontradaException("La entrada con el id proveído no existe");
        }
        else{
            return new EntradaBlogDTO(entradaConseguida.getId(), entradaConseguida.getTituloBlog(), entradaConseguida.getNombreAutor(), entradaConseguida.getFechaPublicacion());
        }

    }

    @Override
    public TodasLasEntradasResponseDTO todasLasEntradas() {
        List<EntradaBlogDTO> entradas;
        entradas = entradaBlogRepository.todasLasEntradas().stream().map(
                entradaBlog -> new EntradaBlogDTO(entradaBlog.getId(), entradaBlog.getTituloBlog(), entradaBlog.getNombreAutor(), entradaBlog.getFechaPublicacion())).toList();
        return new TodasLasEntradasResponseDTO(entradas);
    }
}
