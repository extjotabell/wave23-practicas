package com.meli.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.blog.dto.BlogDTO;
import com.meli.blog.entity.Blog;
import com.meli.blog.exception.ConflictException;
import com.meli.blog.exception.NotFoundException;
import com.meli.blog.repository.BlogRepository;
import com.meli.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    ObjectMapper mapper;
    IBlogRepository repository;
    @Autowired
    public BlogService(BlogRepository blogRepository){
        this.repository = blogRepository;
    }
    @Override
    public BlogDTO saveBlog(BlogDTO blogDTO) {
        Blog blog = mapper.convertValue(blogDTO, Blog.class);
        if(repository.findById(blogDTO.getId()) != null){
            throw new ConflictException("El blog de id "+blogDTO.getId()+" ya existe.");
        }
        repository.save(blog);
        return blogDTO;
    }

    @Override
    public BlogDTO findById(long id) {
        if(repository.findById(id) == null){
            throw new NotFoundException("El blog de id "+id+" no existe.");
        }
        Blog blog = repository.findById(id);
        return mapper.convertValue(blog, BlogDTO.class);
    }

    @Override
    public List<BlogDTO> getAll() {
        List<Blog> blogList = repository.getAll();
        List<BlogDTO> blogDTOList = new ArrayList<>();
        if(blogList.isEmpty()){
            throw new NotFoundException("No hay blogs cargados.");
        }
        blogList.stream().forEach(blog -> {
                blogDTOList.add(mapper.convertValue(blog, BlogDTO.class));
        });
        return blogDTOList;
    }
}
