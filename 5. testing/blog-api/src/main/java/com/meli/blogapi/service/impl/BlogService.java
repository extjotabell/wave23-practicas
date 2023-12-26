package com.meli.blogapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.blogapi.dto.request.EntryBlogDTO;
import com.meli.blogapi.entity.EntryBlog;
import com.meli.blogapi.exception.DuplicateIdException;
import com.meli.blogapi.exception.NotFoundException;
import com.meli.blogapi.repository.IBlogRespository;
import com.meli.blogapi.service.IBlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    private final IBlogRespository blogRepository;
    private ObjectMapper objectMapper;

    public BlogService(IBlogRespository blogRespository) {
        this.blogRepository = blogRespository;
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public EntryBlogDTO getById(long id) {
        EntryBlog entryBlog = blogRepository.findById(id);
        if (entryBlog != null) return objectMapper.convertValue(entryBlog, EntryBlogDTO.class);
        else throw new NotFoundException("There is no blog with the given id ");
    }

    @Override
    public List<EntryBlogDTO> getAll() {
        return blogRepository.getAll().stream().map(b -> objectMapper.convertValue(b, EntryBlogDTO.class)).toList();
    }

    @Override
    public EntryBlogDTO save(EntryBlogDTO entryBlogDTO) {
        if (blogRepository.getAll().stream().map(EntryBlog::getId).toList().contains(entryBlogDTO.getId()))
            throw new DuplicateIdException("The given id has been previously registered");
        blogRepository.save(objectMapper.convertValue(entryBlogDTO, EntryBlog.class));
        return entryBlogDTO;
    }
}
