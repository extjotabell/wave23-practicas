package com.ejercicio.blog.repository;

import com.ejercicio.blog.dto.request.RequestBlogDto;
import com.ejercicio.blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {

    Blog crearBlog(Blog blog);

    Blog getBlogById(Integer id);

    List<Blog> getAllBlogs();

}
