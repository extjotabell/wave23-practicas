package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.entity.Blog;

import java.util.List;

public interface IBlogService {

    List<BlogDTO> findAll();

    BlogDTO findId(int variable);

    BlogDTO saveBlog(BlogDTO variable);

    Boolean alreadyExist(Blog blog);

}
