package com.mercadolibre.blog.util;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {

    public static EntryBlog createBlog(){
        return new EntryBlog(1L, "Test", "Test Name", "2023-12-26");
    }

    public static List<EntryBlog> createListBlogs(){
        return new ArrayList<>(List.of(
                new EntryBlog(1L, "Test", "Test Name", "2023-12-26")
        ));
    }

    public static EntryBlogDTO createEntryBlogDTO(){
        return new EntryBlogDTO(2L, "Test 2", "Test 2", "2023-12-27");
    }

    public static EntryBlogDTO createEntryBlogSameDTO(){
        return new EntryBlogDTO(1L, "Test 2", "Test 2", "2023-12-27");
    }

}
