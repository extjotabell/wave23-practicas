package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.InputBlogDto;
import com.mercadolibre.blog.entity.InputBlog;
import com.mercadolibre.blog.repository.BlogRepositoryImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.mercadolibre.blog.util.Factory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlogServiceImplTest {

    @Mock
    BlogRepositoryImpl blogRepository;

    @InjectMocks
    BlogServiceImpl blogService;

    @Test
    @DisplayName("Test to verify the add of a blog")
    void testAddBlog(){
        //Arrange
        InputBlog expectedBlog = new InputBlog(blogDto1().getIdBlog(), blogDto1().getTitleBlog(),
                blogDto1().getAuthorBlog(), blogDto1().getPostDateBlog());
        when(blogRepository.findIdBlog((long) blogDto1().getIdBlog())).thenReturn(Collections.emptyList());

        //Act
        InputBlogDto result = blogService.addBlog(blogDto1());

        //Assert
        verify(blogRepository).addBlog(expectedBlog);
        assertEquals(blogDto1(), result);
    }

    @Test
    @DisplayName("Test to verify the return of a blog per id")
    void testSearchIdBlogs(){
        //Arrange
        InputBlog expectedBlog = blog1();
        when(blogRepository.findIdBlog((long) expectedBlog.getIdBlog())).thenReturn(Collections.singletonList(expectedBlog));

        //Act
        InputBlogDto result = blogService.searchIdBlogs((long) expectedBlog.getIdBlog());

        //Assert
        assertEquals(new InputBlogDto(expectedBlog.getIdBlog(), expectedBlog.getTitleBlog(),
                expectedBlog.getAuthorBlog(), expectedBlog.getPostDateBlog()), result);
    }

    @Test
    @DisplayName("Test to verify the return of a list of blogs")
    void testSearchAllBlogs(){
        //Arrange
        List<InputBlog> expectedBlogs = Arrays.asList(blog1(), blog2());
        when(blogRepository.findAll()).thenReturn(expectedBlogs);

        //Act
        List<InputBlogDto> result = blogService.searchAllBlogs();

        //Assert
        List<InputBlogDto> expectedDtoBlogs = expectedBlogs.stream()
                .map(blog -> new InputBlogDto(blog.getIdBlog(), blog.getTitleBlog(), blog.getAuthorBlog(), blog.getPostDateBlog()))
                .collect(Collectors.toList());
        assertEquals(expectedDtoBlogs, result);
    }

}
