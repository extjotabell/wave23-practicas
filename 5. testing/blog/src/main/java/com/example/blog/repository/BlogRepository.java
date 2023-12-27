package com.example.blog.repository;

import com.example.blog.entity.EntryBlog;
import com.example.blog.exception.EntryBlogDuplicateException;
import com.example.blog.exception.EntryBlogListEmptyException;
import com.example.blog.exception.EntryBlogNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository implements IBlogRepository {
    private final Map<Long, EntryBlog> blogs;

    public BlogRepository() {
        blogs = new HashMap<>();
    }

    @Override
    public Long addEntryBlog(EntryBlog entryBlog) {
        if (blogs.putIfAbsent(entryBlog.getId(), entryBlog) == null) {
            return entryBlog.getId();
        } throw new EntryBlogDuplicateException(entryBlog.getId());
    }

    @Override
    public EntryBlog getEntryBlogById(Long id) {
        EntryBlog blog = blogs.get(id);
        if(blog==null){
            throw new EntryBlogNotFoundException(id);
        }
        return blog;
    }

    @Override
    public List<EntryBlog> getAllEntryBlog() {
        if(blogs.isEmpty()){
            throw new EntryBlogListEmptyException();
        }
        return blogs.values().stream().toList();
    }

    public void deleteAll(){
        blogs.clear();
    }
}
