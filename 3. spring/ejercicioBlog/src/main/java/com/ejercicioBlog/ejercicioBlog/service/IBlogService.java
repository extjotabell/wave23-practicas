package com.ejercicioBlog.ejercicioBlog.service;
import com.ejercicioBlog.ejercicioBlog.dto.request.BlogRequestDTO;
import com.ejercicioBlog.ejercicioBlog.dto.response.BlogCreateDTO;
import com.ejercicioBlog.ejercicioBlog.dto.response.BlogResponseDTO;
import com.ejercicioBlog.ejercicioBlog.dto.response.BlogsResponseDTO;

public interface IBlogService {
    BlogCreateDTO crearBlog(BlogRequestDTO blogrequest);
    BlogResponseDTO buscarId(Integer id);
    BlogsResponseDTO buscarTodos();
}
