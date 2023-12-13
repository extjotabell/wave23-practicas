package com.itbootcamp.Blog.repository;

import com.itbootcamp.Blog.dto.EntradaBlogDto;
import com.itbootcamp.Blog.entity.EntradaBlog;

import java.util.HashMap;

public interface IEntradaBlogRepository {
    public void agregarBlog(EntradaBlogDto nuevaEntrada);
    public HashMap<Integer, EntradaBlog> mostrarTodas();
    public EntradaBlog buscarPorId(int id);
}
