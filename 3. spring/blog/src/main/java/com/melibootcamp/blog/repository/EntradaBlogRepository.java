package com.melibootcamp.blog.repository;

import com.melibootcamp.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository {
    List<EntradaBlog> entradas = new ArrayList<>();
    @Override
    public void agregarNuevaEntrada(EntradaBlog entradaNueva) {
        entradas.add(entradaNueva);
    }

    @Override
    public EntradaBlog buscarPorId(String id) {
        return entradas.stream().filter(entrada-> entrada.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> todasLasEntradas() {
        return entradas;
    }
}
