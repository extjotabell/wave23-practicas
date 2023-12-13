package com.blog.blog.repository;

import com.blog.blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {

    public void agregarNuevaEntrada(EntradaBlog entradaBlog);

    public EntradaBlog buscarPorId(Integer id);

    List<EntradaBlog> buscarTodos();

}
