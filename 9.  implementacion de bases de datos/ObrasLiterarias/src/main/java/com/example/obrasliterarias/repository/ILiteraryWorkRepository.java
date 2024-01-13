package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.entity.LiteraryWork;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {
    @Query("{\"match\": {\"author\":{\"query\": \"?0\"}}}")
    public List<LiteraryWork> findByAuthor(String author);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"title\": \"?0\"}}]}}")
    public List<LiteraryWork> findByTitle(String title);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"pageCount\":{\"gte\": \"?0\"}}}]}}")
    public List<LiteraryWork> findByPageCountGreaterThan(String pageCount);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"firstPublicationYear\":{\"gte\": \"?0\"}}}]}}")
    public List<LiteraryWork> findByFirstPublicationYearGreaterThan(String firstPublicationYear);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"firstPublicationYear\":{\"lte\": \"?0\"}}}]}}")
    public List<LiteraryWork> findByFirstPublicationYearLessThan(String firstPublicationYear);

    @Query("{\"match\": {\"publisher\":{\"query\": \"?0\"}}}")
    public List<LiteraryWork> findByPublisher(String publisher);

    @Query("{\"match_all\": {}}")
    public List<LiteraryWork> findAll();
}
