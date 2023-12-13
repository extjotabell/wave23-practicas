package com.meli.blog.service;

import com.meli.blog.dto.EntryRequestDto;
import com.meli.blog.dto.EntryResponseDto;

import java.util.List;

public interface IBlogService {
    EntryResponseDto createEntry(EntryRequestDto entryDto);

    EntryResponseDto getEntry(Integer id);

    List<EntryResponseDto> getAllEntries();
}
