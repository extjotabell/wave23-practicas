package com.spring.blog.repositories;

import com.spring.blog.dtos.BlogDto;
import com.spring.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{
    private List<EntradaBlog> blogsDBList;

    public BlogRepository(){
        blogsDBList = new ArrayList<>();
    }


    @Override
    public EntradaBlog save(EntradaBlog blog) {
        blogsDBList.add(blog);
        return blog;
    }

    @Override
    public EntradaBlog findById(Long id) {
        return blogsDBList.stream().filter(b->b.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> getAll() {
        return blogsDBList;
    }


}
