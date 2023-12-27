package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;
import com.mercadolibre.blog.exception.EntryBlogAlreadyExistsException;
import com.mercadolibre.blog.exception.EntryBlogNotExistsException;
import com.mercadolibre.blog.repository.IEntryBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EntryServiceImpl implements IEntryService {

    private final IEntryBlogRepository repository;


    public EntryServiceImpl(IEntryBlogRepository repository) {
        this.repository = repository;
    }


    @Override
    public EntryBlogDTO createBlog(EntryBlogDTO entry) {
        if (this.repository.getBlogById(entry.getId()) != null) {
            throw new EntryBlogAlreadyExistsException("El blog con ese id ya existe");
        }
        this.repository.createBlog(new EntryBlog(entry.getId(), entry.getTitle(), entry.getName(), entry.getDate()));
        return entry;
    }


    @Override
    public EntryBlog getBlogById(Long id) {
        EntryBlog blog = this.repository.getBlogById(id);
        if (blog == null) {
            throw new EntryBlogNotExistsException("El blog solicitado no existe");
        }
        return blog;
    }

    @Override
    public List<EntryBlog> getAll() {
        return this.repository.getAll();
    }
}