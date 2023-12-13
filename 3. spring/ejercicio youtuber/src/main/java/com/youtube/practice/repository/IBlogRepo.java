package com.youtube.practice.repository;

import com.youtube.practice.dto.BlogEntriesDTO;
import com.youtube.practice.dto.BlogEntryDTO;
import com.youtube.practice.dto.response.BlogEntryResponse;
import com.youtube.practice.entity.BlogEntry;

import java.util.ArrayList;

public interface IBlogRepo {
    void addNewEntry(BlogEntry blogEntry);
    BlogEntry findById(int id);
    ArrayList<BlogEntry> getAll();
    BlogEntry findByTitle(String title);
}
