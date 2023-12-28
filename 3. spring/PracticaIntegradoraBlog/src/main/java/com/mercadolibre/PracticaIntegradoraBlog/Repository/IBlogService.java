package com.mercadolibre.PracticaIntegradoraBlog.Repository;

import com.mercadolibre.PracticaIntegradoraBlog.Entity.EntityBlog;

import java.util.List;

public interface IBlogService {

    public List<EntityBlog> getAll();

}
