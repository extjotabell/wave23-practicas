package com.meli.blog.service;

import com.meli.blog.dto.EntryRequestDto;
import com.meli.blog.dto.EntryResponseDto;
import com.meli.blog.entity.Entry;
import com.meli.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImp implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public EntryResponseDto createEntry(EntryRequestDto entryDto) {
        Entry entry = new Entry(
            entryDto.getId(),
            entryDto.getTitle(),
            entryDto.getAuthor()
        );

        Entry createdEntry = blogRepository.createEntry(entry);

        return new EntryResponseDto(
            createdEntry.getId(),
            createdEntry.getTitle(),
            createdEntry.getAuthor(),
            createdEntry.getDate()
        );
    }

    @Override
    public EntryResponseDto getEntry(Integer id) {
        Entry entry = blogRepository.getEntry(id);

        if (entry == null) return null;

        return new EntryResponseDto(
            entry.getId(),
            entry.getTitle(),
            entry.getAuthor(),
            entry.getDate()
        );
    }

    @Override
    public List<EntryResponseDto> getAllEntries() {
        List<Entry> entries = blogRepository.getAllEntries();

        return entries.stream()
            .map(entry -> new EntryResponseDto(
                entry.getId(),
                entry.getTitle(),
                entry.getAuthor(),
                entry.getDate()
            ))
            .toList();
    }
}
