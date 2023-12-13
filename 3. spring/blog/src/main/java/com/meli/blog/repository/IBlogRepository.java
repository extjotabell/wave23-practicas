package com.meli.blog.repository;

import com.meli.blog.entity.Entry;

import java.util.List;

public interface IBlogRepository {

    Entry createEntry(Entry entry);

    Entry getEntry(Integer id);

    List<Entry> getAllEntries();
}
