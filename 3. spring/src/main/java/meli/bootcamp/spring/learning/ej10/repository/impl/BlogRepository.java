package meli.bootcamp.spring.learning.ej10.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import meli.bootcamp.spring.learning.ej10.entity.EntradaBlog;
import meli.bootcamp.spring.learning.ej10.repository.IBlogRepository;

@Repository
public class BlogRepository implements IBlogRepository {
  private List<EntradaBlog> blogs;

  public BlogRepository() {
    this.blogs = new ArrayList<EntradaBlog>();
  }

  public void guardar(EntradaBlog blog) {
    this.blogs.add(blog);
  }

  public Optional<EntradaBlog> obtenerPorId(Integer id) {
    return this.blogs.stream().filter(b -> b.getId() == id).findFirst();
  }

  public List<EntradaBlog> obtenerTodos() {
    return this.blogs;
  }

}
