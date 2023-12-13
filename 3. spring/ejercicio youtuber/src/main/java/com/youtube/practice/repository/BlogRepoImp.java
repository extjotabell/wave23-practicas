package com.youtube.practice.repository;

import com.youtube.practice.entity.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BlogRepoImp implements IBlogRepo {
    ArrayList<BlogEntry> blogEntries = new ArrayList<>();

    @Override
    public void addNewEntry(BlogEntry blogEntry) {
        blogEntries.add(blogEntry);
    }

    @Override
    public BlogEntry findById(int id) {
        return blogEntries.stream().filter(b -> b.getIdBlog() == id).findFirst().orElse(null);
    }

    @Override
    public ArrayList<BlogEntry> getAll() {
        return blogEntries;
    }

    public BlogEntry findByTitle (String title) {
        return blogEntries.stream().filter(b -> b.getBlogTitle().equals(title)).findFirst().orElse(null);
    }
}
