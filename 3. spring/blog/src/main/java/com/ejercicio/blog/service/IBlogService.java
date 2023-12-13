package com.ejercicio.blog.service;

import com.ejercicio.blog.dto.request.RequestBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogsDto;
import com.ejercicio.blog.dto.response.ResponseIdBlogDto;

public interface IBlogService {

    ResponseIdBlogDto crearBlog(RequestBlogDto requestBlogDto);

    ResponseBlogDto getBlogById(Integer id);

    ResponseBlogsDto getBlogs();

}
