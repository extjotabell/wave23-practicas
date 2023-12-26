package com.meli.blog.repository;

import com.meli.blog.entity.Entry;
import com.meli.blog.exception.AlreadyUsedIdException;
import com.meli.blog.exception.EntryNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BlogRepositoryTests {

    IBlogRepository repository;

    @BeforeEach
    void setUp() { repository = new BlogRepositoryImp(); }

    @Test
    @DisplayName("Create correct entry")
    void createEntry() {
        // Arrange
        Entry entry = new Entry(1, "Title", "Content");

        // Act
        Entry result = repository.createEntry(entry);

        // Assert
        assertEquals(entry, result);
    }

    @Test
    @DisplayName("Create correct entry with id already used id")
    void createEntryWithAlreadyUsedId() {
        // Arrange
        Entry entry1 = new Entry(1, "Title", "Content");
        Entry entry2 = new Entry(1, "Title", "Content");
        repository.createEntry(entry1);

        // Act & Assert
        assertThrows(AlreadyUsedIdException.class, () -> repository.createEntry(entry2));
    }

    @Test
    @DisplayName("Get correct entry")
    void getEntry() {
        // Arrange
        Entry entry = new Entry(1, "Title", "Content");
        repository.createEntry(entry);

        // Act
        Entry result = repository.getEntry(1);

        // Assert
        assertEquals(entry, result);
    }

    @Test
    @DisplayName("Get entry with not found id")
    void getEntryWithNotFoundId() {
        // Act & Assert
        assertThrows(EntryNotFoundException.class, () -> repository.getEntry(1));
    }

    @Test
    @DisplayName("Get all entries")
    void getAllEntries() {
        // Arrange
        Entry entry1 = new Entry(1, "Title", "Content");
        Entry entry2 = new Entry(2, "Title", "Content");
        repository.createEntry(entry1);
        repository.createEntry(entry2);

        // Act
        List<Entry> result = repository.getAllEntries();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Get all entries with empty list")
    void getAllEntriesWithEmptyList() {
        // Act
        List<Entry> result = repository.getAllEntries();

        // Assert
        assertEquals(0, result.size());
    }
}
