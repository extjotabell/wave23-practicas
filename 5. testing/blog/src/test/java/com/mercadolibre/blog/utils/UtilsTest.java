package com.mercadolibre.blog.utils;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;

import java.util.List;

public class UtilsTest {

    public static EntryBlogDTO getEntryBlogDto() {
        return new EntryBlogDTO(1L, "Harry Potter", "El prisionero de azkaban", "08-07-1999");
    }

    public static EntryBlog getEntryBlog() {
        return new EntryBlog(1L, "Harry Potter", "El prisionero de azkaban", "08-07-1999");
    }

    public static List<EntryBlog> getEntryBlogs() {
        return List.of(
                new EntryBlog(1L, "Harry Potter", "El prisionero de azkaban", "08-07-1999"),
                new EntryBlog(2L, "Harry Potter", "La piedra filosofal", "26-06-1997")
        );
    }
}
