package org.ejercicio.literaryworks.repository;

import org.ejercicio.literaryworks.model.entity.LiteraryWork;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {

    @Query("{\"match\": {\"author\": \"?0\"}}")
    List<LiteraryWork> findByAuthor(String author);

    @Query("{\"match\": {\"name\": \"*?0*\"}}")
    List<LiteraryWork> findByTitle(String title);

    @Query("{\"term\": {\"editorial.keyword\": \"?0\"}}")
    List<LiteraryWork> findByEditorial(String editorial);

    @Query("{\"range\": {\"pages\": {\"gte\": ?0}}}}")
    List<LiteraryWork> findByPages(Integer count);

    @Query("{\"range\": {\"yearOfPublication\": {\"gte\": ?0}}}}")
    List<LiteraryWork> findByYearAfter(Integer year);

    @Query("{\"range\": {\"yearOfPublication\": {\"lte\": ?0}}}}")
    List<LiteraryWork> findByYearBefore(Integer year);
}
