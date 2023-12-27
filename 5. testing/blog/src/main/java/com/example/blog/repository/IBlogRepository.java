package com.example.blog.repository;

import com.example.blog.entity.EntryBlog;

import java.util.List;

public interface IBlogRepository {
    Long addEntryBlog(EntryBlog entryBlog);
    EntryBlog getEntryBlogById(Long id);
    List<EntryBlog> getAllEntryBlog();
}
