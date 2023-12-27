package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntryBlog;

import java.util.List;


public interface IEntryBlogRepository {


    List<EntryBlog> getAll();

    void createBlog(EntryBlog blog);


    EntryBlog getBlogById(Long id);
}