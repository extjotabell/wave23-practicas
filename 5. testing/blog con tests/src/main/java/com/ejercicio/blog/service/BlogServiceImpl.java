package com.ejercicio.blog.service;

import com.ejercicio.blog.dto.request.RequestBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogsDto;
import com.ejercicio.blog.dto.response.ResponseIdBlogDto;
import com.ejercicio.blog.entity.Blog;
import com.ejercicio.blog.exception.BadRequestException;
import com.ejercicio.blog.exception.NotFoundException;
import com.ejercicio.blog.repository.BlogRepositoryImpl;
import com.ejercicio.blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements  IBlogService {

    IBlogRepository repository;
    public BlogServiceImpl(BlogRepositoryImpl repository) {
        this.repository = repository;
    }

    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public ResponseIdBlogDto crearBlog(RequestBlogDto requestBlogDto) {
        if (requestBlogDto == null) {
            throw new BadRequestException("Error al crear entrada");
        }

        Blog blog = repository.getBlogById(requestBlogDto.getId());
        if (blog != null) {
            throw new BadRequestException("La entrada ya existe");
        }

        blog = repository.crearBlog(mapper.convertValue(requestBlogDto, Blog.class));

        return mapper.convertValue(blog, ResponseIdBlogDto.class);
    }

    @Override
    public ResponseBlogDto getBlogById(Integer id) {
        Blog blog = repository.getBlogById(id);

        if (blog == null) {
            throw new NotFoundException("No existe la entrada con el id: " + id);
        }

        return mapper.convertValue(blog, ResponseBlogDto.class);
    }

    @Override
    public ResponseBlogsDto getBlogs() {
        List<Blog> blogs = repository.getAllBlogs();
        List<ResponseBlogDto> respuesta = new ArrayList<>();

        if (blogs == null) {
            throw new NotFoundException("No existen entradas cargadas");
        }

        blogs.stream().forEach( b -> {
            respuesta.add(mapper.convertValue(b, ResponseBlogDto.class));
        });

        return new ResponseBlogsDto(respuesta);
    }
}
