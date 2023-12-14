package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.InputBlogDto;
import com.mercadolibre.blog.entity.InputBlog;
import com.mercadolibre.blog.exception.ConflictException;
import com.mercadolibre.blog.exception.NotFoundException;
import com.mercadolibre.blog.repository.BlogRepositoryImpl;
import com.mercadolibre.blog.repository.IBLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService{

    IBLogRepository blogRepository;

    public BlogServiceImpl(BlogRepositoryImpl blogRepository) {
        this.blogRepository = blogRepository;
    }
    @Override
    public List<InputBlogDto> searchAllBlogs() {
        List<InputBlog> blogList = blogRepository.findAll();
        return blogList.stream().map(blog -> new InputBlogDto(blog.getIdBlog(), blog.getTitleBlog(),
                blog.getAuthorBlog(), blog.getPostDateBlog())).collect(Collectors.toList());
    }

    @Override
    public InputBlogDto searchIdBlogs(Long id) {
        List<InputBlog> blogs = blogRepository.findIdBlog(id);
        if (blogs.isEmpty()) {
            throw new NotFoundException();
        }
        InputBlog blog = blogs.get(0);
        return new InputBlogDto(blog.getIdBlog(), blog.getTitleBlog(),
                blog.getAuthorBlog(), blog.getPostDateBlog());
    }


    @Override
    public InputBlogDto addBlog(InputBlogDto blogDto) {
        InputBlog blog = new InputBlog(blogDto.getIdBlog(), blogDto.getTitleBlog(),
                blogDto.getAuthorBlog(), blogDto.getPostDateBlog());
        if(!blogRepository.findIdBlog((long) blog.getIdBlog()).isEmpty()) {
            throw new ConflictException();
        }
        blogRepository.addBlog(blog);

        return new InputBlogDto(blog.getIdBlog(), blog.getTitleBlog(),
                blog.getAuthorBlog(), blog.getPostDateBlog());
    }
}
