package com.spring.blog.service;

import com.spring.blog.dto.BlogResponseDto;
import com.spring.blog.dto.BlogRequestDto;
import com.spring.blog.entity.Blog;
import com.spring.blog.exception.AlreadyUseIdException;
import com.spring.blog.exception.NotFoundException;
import com.spring.blog.repository.interfaces.IBlogRepository;
import com.spring.blog.service.interfaces.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository _repository;

    @Override
    public List<BlogResponseDto> getAll() {
        return _repository.getAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public BlogResponseDto findBlogById(int id) {

        Blog blog = _repository.findBlogById(id);

        if (blog == null) {
            throw new NotFoundException("El blog con id " + id + " no existe");
        }
        return new BlogResponseDto(id, blog.getTitulo(), blog.getAutor(), blog.getFecha());
    }

    @Override
    public BlogResponseDto saveBlog(BlogRequestDto blog) {

        if (alreadyExist(blog.getId())) {
            throw new AlreadyUseIdException("El id del blog ya existe...");
        }

        return mapToDto(_repository.saveBlog(
                new Blog(
                        blog.getId(),
                        blog.getTitulo(),
                        blog.getAutor(),
                        LocalDateTime.now())));
    }

    private BlogResponseDto mapToDto(Blog blog) {
        return new BlogResponseDto(blog.getId(), blog.getTitulo(), blog.getAutor(), blog.getFecha());
    }


    private boolean alreadyExist(int id) {
        return _repository.findBlogById(id) != null;
    }
}
