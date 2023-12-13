package com.example.ejercicio_blog.service;

import com.example.ejercicio_blog.dto.BlogDto;
import com.example.ejercicio_blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<BlogDto> findAll();

    BlogDto findId(int variable);

    BlogDto saveBlog(BlogDto variable);

    Boolean alreadyExist(Blog blog);
}
