package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;

import java.util.List;

/**
 * Service interface for managing blog entries.
 */
public interface IEntryService {

    /**
     * Creates a new blog entry.
     *
     * @param entry the DTO representing the blog entry to be created.
     * @return the created blog entry DTO.
     */
    EntryBlogDTO createBlog(EntryBlogDTO entry);

    /**
     * Retrieves a blog entry by its ID.
     *
     * @param id the ID of the blog entry to retrieve.
     * @return the blog entry with the specified ID.
     */
    EntryBlogDTO getBlogById(Long id);

    /**
     * Retrieves all blog entries.
     *
     * @return a list of all blog entries.
     */
    List<EntryBlog> getAll();
}