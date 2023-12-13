package com.itbootcamp.Blog.repository;

import com.itbootcamp.Blog.dto.EntradaBlogDto;
import com.itbootcamp.Blog.entity.EntradaBlog;
import com.itbootcamp.Blog.exception.LlaveDuplicadaException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class EntradaBlogRepositoryImpl implements IEntradaBlogRepository {

    private HashMap<Integer, EntradaBlog> entradas = new HashMap<Integer, EntradaBlog>();

    @Override
    public void agregarBlog(EntradaBlogDto nuevaEntradaDto) {
        if(entradas.containsKey(nuevaEntradaDto.getId())){
            throw new LlaveDuplicadaException("Ya existe un registro de Blog con ese ID");
        }

        EntradaBlog nuevaEntrada = new EntradaBlog(nuevaEntradaDto.getId(),
                nuevaEntradaDto.getTitulo(),
                nuevaEntradaDto.getAutor(),
                nuevaEntradaDto.getFechaPublicacion());

        entradas.put(nuevaEntrada.getId(), nuevaEntrada);
    }

    @Override
    public HashMap<Integer, EntradaBlog> mostrarTodas() {
        return entradas;
    }

    @Override
    public EntradaBlog buscarPorId(int id) {
        return entradas.get(id);
    }
}
