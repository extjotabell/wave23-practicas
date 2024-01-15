package com.example.carga_literaria.repository;

import com.example.carga_literaria.model.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraRepository extends ElasticsearchRepository<Obra,String> {
    @Query("{\"term\": {\"author.keyword\": \"?0\"}}")
    public List<Obra> findAuthor(String name);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"pages\": {\"gt\": ?0}}}]}}")
    public List<Obra> findPages(Integer pages);

    @Query("{\"term\": {\"editorial.keyword\": \"?0\"}}")
    public List<Obra> findEditorial(String editorial);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"year\": {\"lt\": ?0}}}]}}")
    public List<Obra> findLowerYear(Integer year);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"year\": {\"gt\": ?0}}}]}}")
    public List<Obra> findGreaterYear(Integer year);

    @Query("{\"match\": {\"name\":{\"query\": \"?0\"}}}")
    public List<Obra> findTitle(String title);
}
