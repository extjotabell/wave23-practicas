package com.meli.blog.repository;

import com.meli.blog.entity.Entry;
import com.meli.blog.exception.AlreadyUsedIdException;
import com.meli.blog.exception.EntryNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImp implements IBlogRepository {

    private final List<Entry> entries;

    public BlogRepositoryImp() {
        this.entries = new ArrayList<>();
    }

    @Override
    public Entry createEntry(Entry entry) {
        // Check if id is already used
        for (Entry e : entries) {
            if (e.getId().equals(entry.getId())) {
                throw new AlreadyUsedIdException("Id already used");
            }
        }

        entries.add(entry);
        return entry;
    }

    @Override
    public Entry getEntry(Integer id) {
        Entry entry = entries.stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .orElse(null);

        if (entry == null) {
            throw new EntryNotFoundException("Entry not found");
        }

        return entry;
    }

    @Override
    public List<Entry> getAllEntries() {
        return entries;
    }
}
