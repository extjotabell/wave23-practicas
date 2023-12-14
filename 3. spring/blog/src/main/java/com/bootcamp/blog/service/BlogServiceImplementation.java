package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.entity.Blog;
import com.bootcamp.blog.exception.AlreadyUsedIdException;
import com.bootcamp.blog.exception.EmptyListException;
import com.bootcamp.blog.exception.NotFoundException;
import com.bootcamp.blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImplementation implements IBlogService{

    @Autowired
    IBlogRepository repository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<BlogDTO> findAll() {
        List<Blog> listaBlog = repository.findAll();

        if (listaBlog.isEmpty()){
            throw new EmptyListException("La lista se encuentra vacía");
        }

        return listaBlog.stream()
                .map(blog -> objectMapper.convertValue(blog, BlogDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BlogDTO findId(int variable) {
        Blog blog = repository.findId(variable);
        if(blog != null){
            throw new NotFoundException("No se ha encontrado la URL");
        }

        return objectMapper.convertValue(blog, BlogDTO.class);
    }

    @Override
    public BlogDTO saveBlog(BlogDTO blogDto) {
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
