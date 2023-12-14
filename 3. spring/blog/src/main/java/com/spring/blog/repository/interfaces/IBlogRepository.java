package com.spring.blog.repository.interfaces;

import com.spring.blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {

    List<Blog> getAll();

    Blog findBlogById(int id);

    Blog saveBlog(Blog blog);
}
