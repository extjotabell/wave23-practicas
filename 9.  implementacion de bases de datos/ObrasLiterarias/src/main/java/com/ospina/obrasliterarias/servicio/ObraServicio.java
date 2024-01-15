package com.ospina.obrasliterarias.servicio;

import com.ospina.obrasliterarias.entidad.Obra;
import com.ospina.obrasliterarias.repositorio.ObraRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ObraServicio {
    private final ObraRepositorio obraRepositorio;

    public ObraServicio(ObraRepositorio obraRepositorio) {
        this.obraRepositorio = obraRepositorio;
    }

    public Obra guardarObra(Obra obra) {
        return obraRepositorio.save(obra);
    }

    public Iterable<Obra> obtenerObras() {
        return obraRepositorio.findAll();
    }

    public Iterable<Obra> obtenerObrasPorAutor(String autor) {
        return obraRepositorio.findByAutor(autor);
    }

    public Iterable<Obra> obtenerObrasPorTitulo(String titulo) {
        return obraRepositorio.findByTitulo(titulo);
    }

    public Iterable<Obra> obtenerObrasMasDeNPaginas(int paginas) {
        return obraRepositorio.findByCantidadPaginasMayorA(paginas);
    }

    public Iterable<Obra> obtenerObrasPublicadasAntesDe(int anio) {
        return obraRepositorio.findByAnioPublicacionAntesDe(anio);
    }

    public Iterable<Obra> obtenerObrasPublicadasDespuesDe(int anio) {
        return obraRepositorio.findByAnioPublicacionDespuesDe(anio);
    }

    public Iterable<Obra> obtenerObrasPorEditorial(String editorial) {
        return obraRepositorio.findByEditorial(editorial);
    }
}
