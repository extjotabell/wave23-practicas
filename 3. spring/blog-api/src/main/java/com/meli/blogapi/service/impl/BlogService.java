package com.meli.blogapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    public BlogService(IBlogRespository blogRespository) {
        this.blogRepository = blogRespository;
    }

    @Override
    public EntryBlogDTO getById(long id) {
        EntryBlog entryBlog = blogRepository.findById(id);
        if (entryBlog != null) return new ObjectMapper().convertValue(entryBlog, EntryBlogDTO.class);
        else throw new NotFoundException("There is no blog with the given id ");
    }

    @Override
    public List<EntryBlogDTO> getAll() {
        return blogRepository.getAll().stream().map(b ->new ObjectMapper().convertValue(b, EntryBlogDTO.class)).toList();
    }

    @Override
    public EntryBlogDTO save(EntryBlogDTO entryBlogDTO) {
        if (blogRepository.getAll().stream().map(EntryBlog::getId).toList().contains(entryBlogDTO.getId()))
            throw new DuplicateIdException("The given id has been previously registered");
        blogRepository.save(new ObjectMapper().convertValue(entryBlogDTO, EntryBlog.class));
        return entryBlogDTO;
    }
}
