package com.ejercicioBlog.ejercicioBlog.repository;
import com.ejercicioBlog.ejercicioBlog.entity.Blog;
import java.util.List;

public interface IBlogRepository {
    Blog buscarId(Integer id);
    Blog crearBlog(Blog blogrequest);
    List<Blog> buscarTodos();

}
