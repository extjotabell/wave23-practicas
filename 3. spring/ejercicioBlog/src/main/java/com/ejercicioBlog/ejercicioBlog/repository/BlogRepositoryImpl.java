package com.ejercicioBlog.ejercicioBlog.repository;

import com.ejercicioBlog.ejercicioBlog.entity.Blog;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    HashMap<Integer, Blog> data = new HashMap<>();

    @Override
    public Blog buscarId(Integer id) {
        return data.get(id);
    }

    @Override
    public Blog crearBlog(Blog blogrequest) {
        data.put(blogrequest.getId(), blogrequest);
        return blogrequest;
    }

    @Override
    public List<Blog> buscarTodos() {
        return data.values().stream().toList();
    }
}
