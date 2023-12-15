package com.meli.blog.service;

import com.meli.blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {
    BlogDTO saveBlog(BlogDTO blogDTO);

    BlogDTO findById(long id);

    List<BlogDTO> getAll();
}
