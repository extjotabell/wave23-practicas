package com.meli.blogapi.service;

import com.meli.blogapi.dto.request.EntryBlogDTO;

import java.util.List;

public interface IBlogService {

    EntryBlogDTO getById(long id);
    List<EntryBlogDTO> getAll();

    EntryBlogDTO save(EntryBlogDTO entryBlogDTO);
}
