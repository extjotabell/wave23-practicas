package com.ospina.blogYoutuber.servicio;

import com.ospina.blogYoutuber.modelo.comando.ComandoBlog;
import com.ospina.blogYoutuber.modelo.entidad.EntradaBlog;

import java.util.List;

public interface ServicioBlog {
    int crearEntradaBlog(ComandoBlog comandoBlog);
    EntradaBlog obtenerEntradaBlogPorId(int id);

    List<EntradaBlog> obtenerEntradasBlog();
}
