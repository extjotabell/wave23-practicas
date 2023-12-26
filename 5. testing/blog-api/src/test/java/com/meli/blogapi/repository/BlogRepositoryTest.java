package com.meli.blogapi.repository;

import com.meli.blogapi.entity.EntryBlog;
import com.meli.blogapi.repository.impl.BlogRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogRepositoryTest {

    @Autowired
    BlogRepository blogRepository;

    @Test
    @DisplayName("Save a valid entry blog")
    void saveBlogShouldReturnEntryBog(){
        //Arrange
        EntryBlog entryBlogTest = new EntryBlog(100L, "The Blog Test","The developer",
                                                    LocalDate.of(2023, 12, 26));
        //Act
        EntryBlog entryBlogResult = blogRepository.save(entryBlogTest);
        //Assert
        assertEquals(entryBlogTest, entryBlogResult);

        blogRepository.resetBlogs();

    }

    @Test
    @DisplayName("Get an entry blog by existing id ")
    void getBlogByIdShouldReturnEntryBog(){
        //Arrange
        EntryBlog entryBlogTest = new EntryBlog(200L, "The Blog Test","The developer",
                                                    LocalDate.of(2023, 12, 26));
        blogRepository.save(entryBlogTest);
        //Act
        EntryBlog entryBlogResult = blogRepository.findById(200L);
        //Assert
        assertEquals(entryBlogTest, entryBlogResult);

        blogRepository.resetBlogs();
    }

    @Test
    @DisplayName("Get a empty entry blog by non existing id ")
    void getBlogByIdShouldReturnNull(){
        //Arrange
        //Act
        EntryBlog entryBlogResult = blogRepository.findById(300L);
        //Assert
        assertNull(entryBlogResult);

        blogRepository.resetBlogs();
    }

    @Test
    @DisplayName("Get entry blog list")
    void getlistOfBlogsShouldReturnList(){
        //Arrange
        EntryBlog entryBlogTest = new EntryBlog(200L, "The Blog Test","The developer",
                                                    LocalDate.of(2023, 12, 26));
        blogRepository.findById(200L);
        //Act
        List<EntryBlog> entryBlogResult = blogRepository.getAll();
        //Assert
        assertNotNull(entryBlogResult);

        blogRepository.resetBlogs();
    }





}
