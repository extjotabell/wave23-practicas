package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;

import java.util.List;


public interface IEntryService {


    EntryBlogDTO createBlog(EntryBlogDTO entry);


    EntryBlog getBlogById(Long id);


    List<EntryBlog> getAll();
}