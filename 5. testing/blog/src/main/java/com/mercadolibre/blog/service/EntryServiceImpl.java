package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;
import com.mercadolibre.blog.exception.EntryBlogAlreadyExistsException;
import com.mercadolibre.blog.exception.EntryBlogNotExistsException;
import com.mercadolibre.blog.repository.IEntryBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing blog entries.
 */
@Service
public class EntryServiceImpl implements IEntryService {

    private final IEntryBlogRepository repository;

    /**
     * Constructor for the EntryServiceImpl class.
     *
     * @param repository the repository for managing blog entries.
     */
    public EntryServiceImpl(IEntryBlogRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new blog entry.
     *
     * @param entry the DTO representing the blog entry to be created.
     * @return the created blog entry DTO.
     * @throws EntryBlogAlreadyExistsException if a blog entry with the same ID already exists.
     */
    @Override
    public EntryBlogDTO createBlog(EntryBlogDTO entry) {
        if (this.repository.getBlogById(entry.getId()) != null) {
            throw new EntryBlogAlreadyExistsException("El blog con ese id ya existe");
        }
        this.repository.createBlog(new EntryBlog(entry.getId(), entry.getName(), entry.getTitle(), entry.getDate()));
        return entry;
    }

    /**
     * Retrieves a blog entry by its ID.
     *
     * @param id the ID of the blog entry to retrieve.
     * @return the blog entry with the specified ID.
     * @throws EntryBlogNotExistsException if the requested blog entry does not exist.
     */
    @Override
    public EntryBlogDTO getBlogById(Long id) {
        EntryBlog blog = this.repository.getBlogById(id);
        if (blog == null) {
            throw new EntryBlogNotExistsException("El blog solicitado no existe");
        }
        return new EntryBlogDTO(blog.getId(), blog.getTitle(), blog.getName(), blog.getDate());
    }

    /**
     * Retrieves all blog entries.
     *
     * @return a list of all blog entries.
     */
    @Override
    public List<EntryBlog> getAll() {
        return this.repository.getAll();
    }
}