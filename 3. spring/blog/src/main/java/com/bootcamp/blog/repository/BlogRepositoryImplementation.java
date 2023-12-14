package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImplementation implements IBlogRepository{

    public BlogRepositoryImplementation() {
        this.data = new ArrayList<>();
    }

    private List<Blog> data;

    @Override
    public List<Blog> findAll() {
        return data;
    }

    @Override
    public Blog findId(int variable) {
        return data.stream().filter(aux -> aux.getId() == variable).findFirst().orElse(null);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        data.add(blog);
        return blog;
    }

}
