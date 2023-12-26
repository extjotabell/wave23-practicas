package com.ospina.blogYoutuber.servicio;

import com.ospina.blogYoutuber.excepcion.EntradaBlogExistenteExcepcion;
import com.ospina.blogYoutuber.excepcion.EntradaBlogNoEncontradaExcepcion;
import com.ospina.blogYoutuber.modelo.comando.ComandoBlog;
import com.ospina.blogYoutuber.modelo.entidad.EntradaBlog;
import com.ospina.blogYoutuber.repositorio.RepositorioBlog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioBlogImpl implements ServicioBlog{
    private final RepositorioBlog repositorioBlog;

    public ServicioBlogImpl(RepositorioBlog repositorioBlog) {
        this.repositorioBlog = repositorioBlog;
    }

    @Override
    public int crearEntradaBlog(ComandoBlog comandoBlog) {
        EntradaBlog entradaBlog = new EntradaBlog(comandoBlog.getTitulo(), comandoBlog.getAutor(), comandoBlog.getFechaPublicacion());
        if (repositorioBlog.existeEntradaBlogPorId(entradaBlog.getId())) {
            throw new EntradaBlogExistenteExcepcion("Ya existe una entrada de blog con el id: " + entradaBlog.getId());
        }
        repositorioBlog.guardarEntradaBlog(entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public EntradaBlog obtenerEntradaBlogPorId(int id) {
        EntradaBlog entradaBlog = repositorioBlog.obtenerEntradaBlogPorId(id);
        if (entradaBlog == null) {
            throw new EntradaBlogNoEncontradaExcepcion("No existe una entrada de blog con el id: " + id);
        }
        return entradaBlog;
    }

    @Override
    public List<EntradaBlog> obtenerEntradasBlog() {
        return repositorioBlog.obtenerEntradasBlog();
    }
}
