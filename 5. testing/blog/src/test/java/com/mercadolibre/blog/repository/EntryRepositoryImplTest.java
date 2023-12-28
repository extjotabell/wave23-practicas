package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntryBlog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class EntryRepositoryImplTest {

    private final EntryBlog blog1 = new EntryBlog(1L, "Title", "Name", "2022-05-16");
    private final EntryBlog blog2 = new EntryBlog(2L, "Title 2", "Name 2", "2022-12-04");
    private final EntryBlog blog3 = new EntryBlog(3L, "Title 3", "Name 3", "2021-05-30");
    private EntryRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        List<EntryBlog> blogs = initializeBlogs();
        repository = new EntryRepositoryImpl(blogs);
    }

    private List<EntryBlog> initializeBlogs() {
        return new ArrayList<>(List.of(blog1, blog2, blog3));
    }

    @Test
    @DisplayName("Create blog")
    public void createBlogTest() {
        // arrange
        EntryBlog blog = new EntryBlog(4L, "Title 4", "Name 4", "2023-06-21");

        // act
        repository.createBlog(blog);

        // assert
        Assertions.assertEquals(blog, repository.getBlogById(blog.getId()));
    }

    @Test
    @DisplayName("Get Blog by ID")
    public void getBlogByIdTest() {
        // arrange
        EntryBlog expected = new EntryBlog(4L, "Title 4", "Name 4", "2023-06-21");
        repository.createBlog(expected);

        // act
        EntryBlog result = repository.getBlogById(expected.getId());

        // assert
        Assertions.assertEquals(expected, result);
    }

}