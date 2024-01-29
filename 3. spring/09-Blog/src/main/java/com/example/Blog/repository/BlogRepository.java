package com.example.Blog.repository;

import com.meli.blog.dto.BlogDTO;
import com.meli.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogRepository implements IBlogRepository{
    List<Blog> blogList = new ArrayList<>();
    @Override
    public Blog findById(long id) {
        for(Blog blog : blogList){
            if(blog.getId() == id){
                return blog;
            }
        }
        return null;
    }
    @Override
    public void save(Blog blog) {
        blogList.add(blog);
    }
    @Override
    public List<Blog> getAll() {
        return blogList;
    }
}
