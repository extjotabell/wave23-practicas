package com.ospina.blogyoutuber.repositorio;

import com.ospina.blogyoutuber.modelo.entidad.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositorioBlogImpl implements RepositorioBlog{
    private final Map<Integer, EntradaBlog> entradasBlog;

    public RepositorioBlogImpl() {
        this.entradasBlog = new HashMap<>();
    }

    @Override
    public void guardarEntradaBlog(EntradaBlog entradaBlog) {
        entradasBlog.put(entradaBlog.getId(), entradaBlog);
    }

    @Override
    public EntradaBlog obtenerEntradaBlogPorId(int id) {
        return entradasBlog.get(id);
    }

    @Override
    public List<EntradaBlog> obtenerEntradasBlog() {
        return entradasBlog.values().stream().toList();
    }

    @Override
    public boolean existeEntradaBlogPorId(int id) {
        return entradasBlog.containsKey(id);
    }
}
