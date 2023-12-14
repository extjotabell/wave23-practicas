package com.spring.blog.services;

import com.spring.blog.dtos.BlogDto;

import java.util.List;

public interface IBlogService {
    BlogDto createBlog(BlogDto blogDto);

    BlogDto findBlogById(Long id);

    List<BlogDto> getAllBlogs();
}
