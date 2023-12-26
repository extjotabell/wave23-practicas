package com.ospina.blogYoutuber.repositorio;

import com.ospina.blogYoutuber.modelo.entidad.EntradaBlog;

import java.util.List;

public interface RepositorioBlog {

    void guardarEntradaBlog(EntradaBlog entradaBlog);

    EntradaBlog obtenerEntradaBlogPorId(int id);

    List<EntradaBlog> obtenerEntradasBlog();

    boolean existeEntradaBlogPorId(int id);
}
