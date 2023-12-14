package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {

    List<Blog> findAll();

    Blog findId(int variable);

    Blog saveBlog(Blog variable);

}
