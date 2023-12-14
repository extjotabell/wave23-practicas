package com.spring.blog.repository;

import com.spring.blog.entity.Blog;
import com.spring.blog.repository.interfaces.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private List<Blog> data = new ArrayList<>();

    @Override
    public List<Blog> getAll() {
        return data;
    }

    @Override
    public Blog findBlogById(int id) {
        return data.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        data.add(blog);
        return blog;
    }
}
