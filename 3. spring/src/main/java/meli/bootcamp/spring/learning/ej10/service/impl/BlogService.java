package meli.bootcamp.spring.learning.ej10.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import meli.bootcamp.spring.learning.ej10.dto.request.NuevaEntradaDto;
import meli.bootcamp.spring.learning.ej10.dto.response.BaseDto;
import meli.bootcamp.spring.learning.ej10.dto.response.EntradaBlogDto;
import meli.bootcamp.spring.learning.ej10.entity.EntradaBlog;
import meli.bootcamp.spring.learning.ej10.exception.BlogNotFoundException;
import meli.bootcamp.spring.learning.ej10.exception.NoBlogsFoundException;
import meli.bootcamp.spring.learning.ej10.exception.UnavailableIdException;
import meli.bootcamp.spring.learning.ej10.repository.IBlogRepository;
import meli.bootcamp.spring.learning.ej10.repository.impl.BlogRepository;
import meli.bootcamp.spring.learning.ej10.service.IBlogService;

@Service
public class BlogService implements IBlogService {

  private IBlogRepository repository;

  public BlogService(BlogRepository repository) {
    this.repository = repository;
  }

  public BaseDto crearBlog(NuevaEntradaDto nuevoBlog) {
    Optional<EntradaBlog> posibleBlog = repository.obtenerPorId(nuevoBlog.getId());
    if (posibleBlog.isPresent()) {
      throw new UnavailableIdException("El blog con id " + nuevoBlog.getId() + " ya existe");
    }
    EntradaBlog nuevaEntradaBlog = new EntradaBlog(nuevoBlog.getId(), nuevoBlog.getTitulo(),
        nuevoBlog.getNombreAutor());
    repository.guardar(nuevaEntradaBlog);
    return new BaseDto("Blog creado exitosamente", true);
  }

  @Override
  public EntradaBlogDto obtenerBlogPorId(Integer id) {
    Optional<EntradaBlog> posibleBlog = repository.obtenerPorId(id);
    if (!posibleBlog.isPresent()) {
      throw new BlogNotFoundException("Blog con el id " + id + " no fue encontrado");
    }
    EntradaBlog blogEncontrado = posibleBlog.get();
    EntradaBlogDto respuesta = this.blogADto(blogEncontrado);
    return respuesta;
  }

  @Override
  public List<EntradaBlogDto> obtenerTodos() {
    List<EntradaBlog> blogs = repository.obtenerTodos();
    if (blogs.size() == 0) {
      throw new NoBlogsFoundException("No hay blogs cargados");
    }
    return blogs.stream().map(b -> this.blogADto(b)).toList();
  }

  private EntradaBlogDto blogADto(EntradaBlog blog) {
    return new EntradaBlogDto(blog.getId(), blog.getTitulo(), blog.getNombreAutor(), blog.getFecha().toString());
  }
}
