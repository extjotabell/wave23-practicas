package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntryBlog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of the blog entry repository interface.
 */
@Repository
public class EntryRepositoryImpl implements IEntryBlogRepository{
    /**
     * List to store blog entries.
     */
    private final List<EntryBlog> blogs;

    /**
     * Constructs an instance of EntryRepositoryImpl with the provided list of blog entries.
     *
     * @param blogs the list of blog entries.
     */
    public EntryRepositoryImpl(List<EntryBlog> blogs) {
        this.blogs = blogs;
    }

    /**
     * Retrieves all blog entries from the repository.
     *
     * @return a list of all blog entries.
     */
    public List<EntryBlog> getAll(){
        return this.blogs;
    }

    /**
     * Creates a new blog entry and adds it to the repository.
     *
     * @param blog the blog entry to be created and added.
     */
    public void createBlog(EntryBlog blog){
        this.blogs.add(blog);
    }

    /**
     * Retrieves a blog entry by its ID from the repository.
     *
     * @param id the ID of the blog entry to retrieve.
     * @return the blog entry with the specified ID, or null if not found.
     */
    public EntryBlog getBlogById(Long id){
        return this.blogs.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
