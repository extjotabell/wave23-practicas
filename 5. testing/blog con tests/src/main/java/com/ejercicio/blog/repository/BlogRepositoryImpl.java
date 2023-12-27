package com.ejercicio.blog.repository;

import com.ejercicio.blog.dto.request.RequestBlogDto;
import com.ejercicio.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    Map<Integer, Blog> data = new HashMap<>();

    @Override
    public Blog crearBlog(Blog blog) {
        data.put(blog.getId(), blog);
        return blog;
    }

    @Override
    public Blog getBlogById(Integer id) {
        return data.get(id);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return data.values().stream().toList();
    }
}
