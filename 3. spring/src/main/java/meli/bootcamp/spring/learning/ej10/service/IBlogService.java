package meli.bootcamp.spring.learning.ej10.service;

import java.util.List;

import meli.bootcamp.spring.learning.ej10.dto.request.NuevaEntradaDto;
import meli.bootcamp.spring.learning.ej10.dto.response.BaseDto;
import meli.bootcamp.spring.learning.ej10.dto.response.EntradaBlogDto;

public interface IBlogService {
  public BaseDto crearBlog(NuevaEntradaDto nuevoBlog);

  public EntradaBlogDto obtenerBlogPorId(Integer id);

  public List<EntradaBlogDto> obtenerTodos();
}
