package com.itbootcamp.Blog.service;

import com.itbootcamp.Blog.dto.EntradaBlogDto;
import com.itbootcamp.Blog.entity.EntradaBlog;
import com.itbootcamp.Blog.exception.RecursoNoEncontradoException;
import com.itbootcamp.Blog.repository.EntradaBlogRepositoryImpl;
import com.itbootcamp.Blog.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;

@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService {
    @Autowired
    IEntradaBlogRepository entradaBlogRepository;

    @Override
    public EntradaBlogDto agregarEntradaBlog(EntradaBlogDto nuevaEntradaDto) {
        entradaBlogRepository.agregarBlog(nuevaEntradaDto);
        return nuevaEntradaDto;
    }

    @Override
    public HashMap<Integer, EntradaBlogDto> mostrarTodas() {
        HashMap<Integer, EntradaBlog> entradasBlog = entradaBlogRepository.mostrarTodas();
        HashMap<Integer, EntradaBlogDto> entradasBlogDto = new HashMap<>();
        entradasBlog.forEach((id, entradaBlog) -> {
            entradasBlogDto.put(id, new EntradaBlogDto(entradaBlog.getId(),
                    entradaBlog.getTitulo(),
                    entradaBlog.getAutor(),
                    entradaBlog.getFechaPublicacion()));
        });
        return entradasBlogDto;
    }

    @Override
    public EntradaBlogDto buscarPorId(int id) {
        EntradaBlog entradaBlogEncontrada = entradaBlogRepository.buscarPorId(id);
        if(entradaBlogEncontrada == null){
            throw new RecursoNoEncontradoException("Entrada de blog no encontrada");
        }
        return new EntradaBlogDto(entradaBlogEncontrada.getId(),
                entradaBlogEncontrada.getTitulo(),
                entradaBlogEncontrada.getAutor(),
                entradaBlogEncontrada.getFechaPublicacion()
        );
    }
}
