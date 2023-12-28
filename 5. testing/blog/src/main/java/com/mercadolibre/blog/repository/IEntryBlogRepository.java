package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntryBlog;

import java.util.List;

/**
 * Interface for the blog entry repository.
 */
public interface IEntryBlogRepository {

    /**
     * Retrieves all blog entries from the repository.
     *
     * @return a list of all blog entries.
     */
    List<EntryBlog> getAll();

    /**
     * Creates a new blog entry and adds it to the repository.
     *
     * @param blog the blog entry to be created and added.
     */
    void createBlog(EntryBlog blog);

    /**
     * Retrieves a blog entry by its ID from the repository.
     *
     * @param id the ID of the blog entry to retrieve.
     * @return the blog entry with the specified ID, or null if not found.
     */
    EntryBlog getBlogById(Long id);
}