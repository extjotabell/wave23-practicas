package com.meli.blog.service;

import com.meli.blog.dto.EntryRequestDto;
import com.meli.blog.dto.EntryResponseDto;
import com.meli.blog.entity.Entry;
import com.meli.blog.exception.AlreadyUsedIdException;
import com.meli.blog.exception.EntryNotFoundException;
import com.meli.blog.repository.IBlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class BlogServiceTests {

    @Mock
    IBlogRepository repository;

    @InjectMocks
    BlogServiceImp service;

    @BeforeEach
    void setUp() { openMocks(this); }

    @Test
    @DisplayName("Create correct entry")
    void createEntry() {
        // Arrange
        EntryRequestDto request = new EntryRequestDto(1, "Title", "Content");
        when(repository.createEntry(any(Entry.class))).thenReturn(new Entry(1, "Title", "Content"));

        // Act
        EntryResponseDto result = service.createEntry(request);

        // Assert
        assertEquals(request.getId(), result.getId());
        assertEquals(request.getTitle(), result.getTitle());
        assertEquals(request.getAuthor(), result.getAuthor());
    }

    @Test
    @DisplayName("Create correct entry with id already used id")
    void createEntryWithAlreadyUsedId() {
        // Arrange
        EntryRequestDto request = new EntryRequestDto(1, "Title", "Content");
        when(repository.createEntry(any(Entry.class))).thenThrow(new AlreadyUsedIdException(""));

        // Act & Assert
        assertThrows(AlreadyUsedIdException.class, () -> service.createEntry(request));
    }

    @Test
    @DisplayName("Get correct entry")
    void getEntry() {
        // Arrange
        Entry entry = new Entry(1, "Title", "Content");
        when(repository.getEntry(1)).thenReturn(entry);

        // Act
        EntryResponseDto result = service.getEntry(1);

        // Assert
        assertEquals(entry.getId(), result.getId());
        assertEquals(entry.getTitle(), result.getTitle());
        assertEquals(entry.getAuthor(), result.getAuthor());
    }

    @Test
    @DisplayName("Get entry with incorrect id")
    void getEntryWithIncorrectId() {
        // Arrange
        when(repository.getEntry(1)).thenThrow(new EntryNotFoundException(""));

        // Act & Assert
        assertThrows(EntryNotFoundException.class, () -> service.getEntry(1));
    }

    @Test
    @DisplayName("Get all entries")
    void getAllEntries() {
        // Arrange
        Entry entry1 = new Entry(1, "Title", "Content");
        Entry entry2 = new Entry(2, "Title", "Content");
        when(repository.getAllEntries()).thenReturn(List.of(entry1, entry2));

        // Act
        List<EntryResponseDto> result = service.getAllEntries();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Get all entries with empty list")
    void getAllEntriesWithEmptyList() {
        // Arrange
        when(repository.getAllEntries()).thenReturn(List.of());

        // Act
        List<EntryResponseDto> result = service.getAllEntries();

        // Assert
        assertEquals(0, result.size());
    }

}
