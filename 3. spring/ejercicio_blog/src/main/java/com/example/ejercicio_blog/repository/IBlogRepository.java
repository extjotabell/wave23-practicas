package com.example.ejercicio_blog.repository;

import com.example.ejercicio_blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    Blog findId(int variable);

    Blog saveBlog(Blog variable);
}
