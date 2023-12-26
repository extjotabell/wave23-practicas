package com.ospina.blogyoutuber.repositorio;

import com.ospina.blogyoutuber.modelo.entidad.EntradaBlog;

import java.util.List;

public interface RepositorioBlog {

    void guardarEntradaBlog(EntradaBlog entradaBlog);

    EntradaBlog obtenerEntradaBlogPorId(int id);

    List<EntradaBlog> obtenerEntradasBlog();

    boolean existeEntradaBlogPorId(int id);
}
