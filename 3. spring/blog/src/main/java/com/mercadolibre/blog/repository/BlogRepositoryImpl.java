package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    HashMap<Integer, EntradaBlog> data = new HashMap<>();
    @Override
    public EntradaBlog crearEntrada(EntradaBlog entradaBlog) {
        data.put(entradaBlog.getId(), entradaBlog);
        return entradaBlog;
    }

    @Override
    public EntradaBlog buscarId(Integer id) {
        return data.get(id);
    }

    @Override
    public List<EntradaBlog> buscarTodas() {
        return data.values().stream().toList();
    }

}
