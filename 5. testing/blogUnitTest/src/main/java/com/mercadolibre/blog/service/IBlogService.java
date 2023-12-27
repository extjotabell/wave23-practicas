package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.InputBlogDto;

import java.util.List;


public interface IBlogService {
    InputBlogDto addBlog(InputBlogDto blogDto);
    List<InputBlogDto> searchAllBlogs();
    InputBlogDto searchIdBlogs(Long id);

}
