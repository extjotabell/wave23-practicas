package com.youtube.practice.service;

import com.youtube.practice.dto.BlogEntriesDTO;
import com.youtube.practice.dto.BlogEntryDTO;
import com.youtube.practice.dto.response.BlogEntryResponse;

public interface IBlogService {
    BlogEntryResponse addNewEntry(BlogEntryDTO blogEntry);
    BlogEntryDTO findById(int id);
    BlogEntriesDTO getAll();
}
