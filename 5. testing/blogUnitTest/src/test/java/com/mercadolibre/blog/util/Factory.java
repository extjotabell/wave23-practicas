package com.mercadolibre.blog.util;

import com.mercadolibre.blog.dto.InputBlogDto;
import com.mercadolibre.blog.entity.InputBlog;

import java.time.LocalDate;

public class Factory {

    public static InputBlog blog1(){
        return new InputBlog(1, "Title 1", "Content 1", LocalDate.of(2021, 1, 1));
    }

    public static InputBlog blog2(){
        return new InputBlog(2, "Title 2", "Content 2", LocalDate.of(2023, 5, 12));
    }

    public static InputBlogDto blogDto1() {
        return new InputBlogDto(1, "Test Title 1", "Test Author 1", LocalDate.now());
    }

    public static InputBlogDto blogDto2() {
        return new InputBlogDto(2, "Test Title 2", "Test Author 2", LocalDate.now());
    }

}
