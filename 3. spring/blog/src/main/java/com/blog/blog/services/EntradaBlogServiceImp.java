package com.blog.blog.services;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.dto.response.NuevaEntradaResponseDTO;
import com.blog.blog.dto.response.TodasLasEntradasDTO;
import com.blog.blog.entity.EntradaBlog;
import com.blog.blog.exceptions.EntradaExistenteException;
import com.blog.blog.exceptions.EntradaNoEncontradaException;
import com.blog.blog.repository.EntradaBlogRepositoryImp;
import com.blog.blog.repository.IEntradaBlogRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Data
@NoArgsConstructor(force = true)
public class EntradaBlogServiceImp implements IEntradaBlogService{
    private final IEntradaBlogRepository repositorioBlog;

    public EntradaBlogServiceImp(EntradaBlogRepositoryImp repositorioBlog) {
        this.repositorioBlog = repositorioBlog;
    }

    @Override
    public NuevaEntradaResponseDTO crearEntrada(EntradaBlogDTO blog) {
        System.out.println(blog);
        EntradaBlog entradaBlog = new EntradaBlog(blog.getId(), blog.getTitulo(), blog.getNombreAutor(), Date.from(LocalDate.parse(blog.getFechaPublicacion()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        if (repositorioBlog.buscarPorId(entradaBlog.getId()) != null) {
            throw new EntradaExistenteException("Ya existe una entrada de blog con el id: " + entradaBlog.getId());
        }
        repositorioBlog.agregarNuevaEntrada(entradaBlog);
        return new NuevaEntradaResponseDTO(entradaBlog.getId());
    }

    @Override
    public EntradaBlogDTO buscarEntrada(Integer id) {
        EntradaBlog entradaBlog = repositorioBlog.buscarPorId(id);
        if (entradaBlog == null) {
            throw new EntradaNoEncontradaException("No existe una entrada de blog con el id: " + id);
        }
        return new EntradaBlogDTO(entradaBlog);
    }

    @Override
    public TodasLasEntradasDTO todasLasEntradas() {
        List<EntradaBlogDTO> list = repositorioBlog.buscarTodos().stream().map(EntradaBlogDTO::new).toList();
        return new TodasLasEntradasDTO(list);
    }
}