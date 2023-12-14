package com.spring.blog.services;

import com.spring.blog.dtos.BlogDto;
import com.spring.blog.exceptions.NotAcceptableException;
import com.spring.blog.exceptions.NotFoundException;
import com.spring.blog.mappers.BlogMapper;
import com.spring.blog.model.EntradaBlog;
import com.spring.blog.repositories.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        EntradaBlog blog = blogRepository.findById(blogDto.getId());
        if(blog != null){
            throw new NotAcceptableException("El blog con id: "+blogDto.getId()+" ya existe en la BD.");
        }
        blogRepository.save(BlogMapper.mapBlogDtoToEntradaBlog(blogDto));
        return blogDto;
    }

    @Override
    public BlogDto findBlogById(Long id) {
        EntradaBlog blog = blogRepository.findById(id);
        if(blog == null){
            throw new NotFoundException("El blog con id: "+ id +" no existe.");
        }
        return BlogMapper.mapEntradaBlogToBlogDto(blog);
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        List<EntradaBlog> blogs = blogRepository.getAll();
        if(blogs.isEmpty()){
            throw new NotFoundException("Al momento no hay blogs en la BD.");
        }
        return blogs.stream().map(BlogMapper::mapEntradaBlogToBlogDto).toList();
    }
}
