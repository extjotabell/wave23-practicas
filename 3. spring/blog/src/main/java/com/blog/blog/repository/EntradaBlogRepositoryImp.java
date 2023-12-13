package com.blog.blog.repository;

import com.blog.blog.entity.EntradaBlog;
import com.blog.blog.services.IEntradaBlogService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EntradaBlogRepositoryImp implements IEntradaBlogRepository {

    private List<EntradaBlog> entradaBlogs = new ArrayList<>();
    @Override
    public void agregarNuevaEntrada(EntradaBlog entradaBlog) {
        entradaBlogs.add(entradaBlog);
    }

    @Override
    public EntradaBlog buscarPorId(Integer id) {
        Optional<EntradaBlog> first = entradaBlogs.stream().filter(e -> e.getId().equals(id)).findFirst();
        return first.orElse(null);
    }

    @Override
    public List<EntradaBlog> buscarTodos() {
        return entradaBlogs;
    }
}
