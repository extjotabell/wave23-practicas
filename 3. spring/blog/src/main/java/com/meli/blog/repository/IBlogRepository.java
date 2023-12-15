package com.meli.blog.repository;

import com.meli.blog.dto.BlogDTO;
import com.meli.blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog findById(long id);

    void save(Blog blog);

    List<Blog> getAll();
}
