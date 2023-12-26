package com.mercadolibre.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.blog.dto.request.EntradaRequestDto;
import com.mercadolibre.blog.dto.response.EntradaDto;
import com.mercadolibre.blog.dto.response.EntradaIdDto;
import com.mercadolibre.blog.dto.response.EntradasDto;
import com.mercadolibre.blog.entity.EntradaBlog;
import com.mercadolibre.blog.exception.BadRequestException;
import com.mercadolibre.blog.exception.NotFoundException;
import com.mercadolibre.blog.repository.BlogRepositoryImpl;
import com.mercadolibre.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    IBlogRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public BlogServiceImpl(BlogRepositoryImpl repository) {
        this.repository = repository;
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public EntradaIdDto crearEntrada(EntradaRequestDto request) {
        if (request == null) {
            throw new BadRequestException("Error al crear entrada");
        }

        EntradaBlog entradaBlog =  repository.buscarId(request.getId());
        if (entradaBlog != null) {
            throw new BadRequestException("La entrada ya existe");
        }

        entradaBlog = repository.crearEntrada(mapper.convertValue(request, EntradaBlog.class));
        return mapper.convertValue(entradaBlog, EntradaIdDto.class);
    }

    @Override
    public EntradaDto buscarPorId(Integer id) {
        EntradaBlog entradaBlog = repository.buscarId(id);

        if (entradaBlog == null) {
            throw new NotFoundException("No existe entrada con el id: " + id);
        }

        return mapper.convertValue(entradaBlog, EntradaDto.class);
    }

    @Override
    public EntradasDto buscarTodas() {
        List<EntradaBlog> entradas = repository.buscarTodas();

        if (entradas.isEmpty()) {
            throw new NotFoundException("No existen entradas cargadas");
        }

        return new EntradasDto(entradas.stream()
                .map(entradaBlog -> mapper.convertValue(entradaBlog, EntradaDto.class))
                .toList());
    }
}
