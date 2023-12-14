package com.spring.blog.repositories;

import com.spring.blog.dtos.BlogDto;
import com.spring.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    EntradaBlog save(EntradaBlog blog);

    EntradaBlog findById(Long id);

    List<EntradaBlog> getAll();
}
