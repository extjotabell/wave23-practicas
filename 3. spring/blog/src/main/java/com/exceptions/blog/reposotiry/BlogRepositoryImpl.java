package com.exceptions.blog.reposotiry;

import com.exceptions.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{
    Map<Integer, Blog> listBlog = new HashMap<>();

    @Override
    public Blog saveBlog(Blog blog, int id) {
        listBlog.put(id, blog);

        return blog;
    }

    @Override
    public Blog searchBlog(int id) {
        return listBlog.get(id);
    }

    @Override
    public Map<Integer, Blog> listBlogs() {
        return listBlog;
    }
}
