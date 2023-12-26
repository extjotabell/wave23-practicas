package com.ospina.blogyoutuber.servicio;

import com.ospina.blogyoutuber.modelo.comando.ComandoBlog;
import com.ospina.blogyoutuber.modelo.entidad.EntradaBlog;

import java.util.List;

public interface ServicioBlog {
    int crearEntradaBlog(ComandoBlog comandoBlog);
    EntradaBlog obtenerEntradaBlogPorId(int id);

    List<EntradaBlog> obtenerEntradasBlog();
}
