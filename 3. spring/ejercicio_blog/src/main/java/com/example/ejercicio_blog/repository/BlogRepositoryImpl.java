package com.example.ejercicio_blog.repository;

import com.example.ejercicio_blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    public BlogRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    private List<Blog> data;

    @Override
    public List<Blog> findAll() {
        return data;
    }

    @Override
    public Blog findId(int variable) {
        Blog blog = data.stream().filter(aux -> aux.getId() == variable).findFirst().orElse(null);
        return blog;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        data.add(blog);
        return blog;
    }
}
