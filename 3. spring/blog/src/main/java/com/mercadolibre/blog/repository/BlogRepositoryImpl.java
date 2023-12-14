package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.InputBlog;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogRepositoryImpl implements IBLogRepository {

    private List<InputBlog> listOfBlogs = new ArrayList<>();

    public BlogRepositoryImpl() {
        loadDataBase();
    }

    @Override
    public List<InputBlog> findAll() {
        return listOfBlogs;
    }

    @Override
    public List<InputBlog> findIdBlog(Long id) {
        return listOfBlogs.stream().filter(blog -> blog.getIdBlog() == id).collect(Collectors.toList());
    }

    @Override
    public void addBlog(InputBlog blog) {
        listOfBlogs.add(blog);
    }

    private void loadDataBase(){

        List<InputBlog> blogs = new ArrayList<>();

        LocalDate date1 = LocalDate.of(2021, 1, 1);
        LocalDate date2 = LocalDate.of(2005, 5, 2);
        blogs.add(new InputBlog(1,"Blog 1","Author 1", date1));
        blogs.add(new InputBlog(2,"Blog 2","Author 2", date2));

        listOfBlogs = blogs;
    }
}
