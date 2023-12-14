package com.spring.blog.service.interfaces;

import com.spring.blog.dto.BlogResponseDto;
import com.spring.blog.dto.BlogRequestDto;

import java.util.List;

public interface IBlogService {
    List<BlogResponseDto> getAll();

    BlogResponseDto findBlogById(int id);

    BlogResponseDto saveBlog(BlogRequestDto blog);
}
