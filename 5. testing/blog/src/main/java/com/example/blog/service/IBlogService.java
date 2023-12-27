package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import com.example.blog.entity.EntryBlog;

import java.util.List;

public interface IBlogService {
    Long addEntryBlog(EntryBlog entryBlog);
    BlogDTO getEntryBlogById(Long id);
    List<BlogDTO> getAllEntryBlog();
}
