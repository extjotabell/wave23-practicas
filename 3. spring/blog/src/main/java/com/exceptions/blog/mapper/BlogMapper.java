package com.exceptions.blog.mapper;

import com.exceptions.blog.dto.request.RequestBlogDTO;
import com.exceptions.blog.dto.response.ResponseBlogDTO;
import com.exceptions.blog.entity.Blog;

public class BlogMapper {
    public static Blog toBlog(RequestBlogDTO dto) {
        Blog blog = new Blog();
        blog.setTitle(dto.getTitle());
        blog.setName(dto.getName());
        blog.setDate(dto.getDate());

        return blog;
    }

    public static ResponseBlogDTO toResponseDTO(Blog blog, int id) {
        ResponseBlogDTO blogDTO = new ResponseBlogDTO();
        blogDTO.setId(id);
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setName(blog.getName());
        blogDTO.setDate(blog.getDate());

        return blogDTO;
    }
}
