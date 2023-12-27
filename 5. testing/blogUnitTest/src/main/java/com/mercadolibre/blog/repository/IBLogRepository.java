package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.InputBlog;

import java.util.List;

public interface IBLogRepository {
    List<InputBlog> findAll();
    List<InputBlog> findIdBlog(Long id);

    void addBlog(InputBlog vehicle);
}
