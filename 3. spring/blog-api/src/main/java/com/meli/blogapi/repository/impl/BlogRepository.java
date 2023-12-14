package com.meli.blogapi.repository.impl;

import com.meli.blogapi.entity.EntryBlog;
import com.meli.blogapi.repository.IBlogRespository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRespository {

    private List<EntryBlog> blogs = new ArrayList<>();
    @Override
    public EntryBlog findById(long id) {
        return blogs.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntryBlog> getAll() {
        return this.blogs;
    }

    @Override
    public EntryBlog save(EntryBlog entryBlog) {
        this.blogs.add(entryBlog);
        return entryBlog;
    }
}
