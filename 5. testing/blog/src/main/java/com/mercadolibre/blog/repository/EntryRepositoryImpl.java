package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntryBlog;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EntryRepositoryImpl implements IEntryBlogRepository {

    private final List<EntryBlog> blogs;


    public EntryRepositoryImpl(List<EntryBlog> blogs) {
        this.blogs = blogs;
    }


    public List<EntryBlog> getAll() {
        return this.blogs;
    }


    public void createBlog(EntryBlog blog) {
        this.blogs.add(blog);
    }


    public EntryBlog getBlogById(Long id) {
        return this.blogs.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
