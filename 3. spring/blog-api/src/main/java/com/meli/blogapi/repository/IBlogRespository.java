package com.meli.blogapi.repository;

import com.meli.blogapi.entity.EntryBlog;

import java.util.List;

public interface IBlogRespository {

    EntryBlog findById(long id);
    List<EntryBlog> getAll();

    EntryBlog save(EntryBlog entryBlog);
}
