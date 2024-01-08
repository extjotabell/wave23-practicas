package com.youtube.practice.unit.controller;

import com.youtube.practice.controller.BlogController;
import com.youtube.practice.dto.BlogEntriesDTO;
import com.youtube.practice.dto.BlogEntryDTO;
import com.youtube.practice.dto.response.BlogEntryResponse;
import com.youtube.practice.service.BlogServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.youtube.practice.utils.UserData.getBlogEntires;
import static com.youtube.practice.utils.UserData.getBlogEntry;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BlogControllerTests {
    @Mock
    BlogServiceImp service;

    @InjectMocks
    BlogController controller;

    @Test
    @DisplayName("Add blog entry")
    void addBlogEntry() {
        BlogEntryDTO entry = getBlogEntry();
        BlogEntryResponse response = new BlogEntryResponse();
        response.setMessage("Blog added");

        when(service.addNewEntry(entry)).thenReturn(response);

        BlogEntryResponse result = controller.newBlogEntry(entry).getBody();

        verify(service, atLeastOnce()).addNewEntry(entry);
        assertEquals(response, result);
    }

    @Test
    @DisplayName("Add empty blog")
    void addEmptyBlog() {
        BlogEntryDTO entry = new BlogEntryDTO();

        when(service.addNewEntry(entry)).thenReturn(null);

        BlogEntryResponse result = controller.newBlogEntry(entry).getBody();

        verify(service, atLeastOnce()).addNewEntry(entry);
        assertNull(result);
    }

    @Test
    @DisplayName("Find blog by id")
    void findBlogById() {
        int id = 1;
        BlogEntryDTO expected = getBlogEntry();

        when(service.findById(id)).thenReturn(expected);

        BlogEntryDTO result = controller.findById(id).getBody();

        verify(service, atLeastOnce()).findById(id);
        assertEquals(expected, result);
    }


    @Test
    @DisplayName("Find all blogs")
    void getAll() {
        BlogEntriesDTO expected = getBlogEntires();

        when(service.getAll()).thenReturn(expected);

        BlogEntriesDTO result = controller.getAll().getBody();

        verify(service, atLeastOnce()).getAll();
        assertEquals(expected, result);
    }
}
