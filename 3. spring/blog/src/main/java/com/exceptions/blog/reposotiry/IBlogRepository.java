package com.exceptions.blog.reposotiry;

import com.exceptions.blog.entity.Blog;

import java.util.Map;

public interface IBlogRepository {
    Blog saveBlog(Blog blog, int id);
    Blog searchBlog(int id);
    Map<Integer, Blog> listBlogs();
}
