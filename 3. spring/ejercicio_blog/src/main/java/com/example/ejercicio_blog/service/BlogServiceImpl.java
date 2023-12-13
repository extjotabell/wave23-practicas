package com.example.ejercicio_blog.service;

import com.example.ejercicio_blog.dto.BlogDto;
import com.example.ejercicio_blog.entity.Blog;
import com.example.ejercicio_blog.exception.AlreadyUsedIdException;
import com.example.ejercicio_blog.repository.BlogRepositoryImpl;
import com.example.ejercicio_blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository repository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<BlogDto> findAll() {
        List<Blog> aux = repository.findAll();
        List<BlogDto> respuesta = new ArrayList<>();

        for (Blog item: aux
             ) {
            respuesta.add(objectMapper.convertValue(item,BlogDto.class));
        }

        return respuesta;
    }

    @Override
    public BlogDto findId(int variable) {
        BlogDto blogDto = objectMapper.convertValue(repository.findId(variable),BlogDto.class);
        return blogDto;
    }

    @Override
    public BlogDto saveBlog(BlogDto blogDto) {
        Blog blog = objectMapper.convertValue(blogDto, Blog.class);

        if (alreadyExist(blog)){
            throw new AlreadyUsedIdException("Este blog ya existe");
        }

        repository.saveBlog(blog);
        return blogDto;
    }

    @Override
    public Boolean alreadyExist(Blog blog) {

        Blog aux = repository.findId(blog.getId());

        if (aux != null){
            return true;
        }
        else return false;
    }
}
