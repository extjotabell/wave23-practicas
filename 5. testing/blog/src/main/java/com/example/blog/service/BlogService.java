package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import com.example.blog.entity.EntryBlog;
import com.example.blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Long addEntryBlog(EntryBlog entryBlog) {
        return blogRepository.addEntryBlog(entryBlog);
    }

    @Override
    public BlogDTO getEntryBlogById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(blogRepository.getEntryBlogById(id), BlogDTO.class);
    }

    @Override
    public List<BlogDTO> getAllEntryBlog() {
        ObjectMapper mapper = new ObjectMapper();
        return blogRepository.getAllEntryBlog()
                             .stream()
                             .map(entryBlog -> mapper.convertValue(entryBlog, BlogDTO.class))
                             .toList();
    }
}
