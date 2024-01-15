package com.example.literaryworks.repository;

import com.example.literaryworks.model.entity.LiteraryWorks;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILiteraryWorksRepository extends ElasticsearchRepository<LiteraryWorks, String> {

    /**
     *
     * Return all the literary works of an author given by the user.
     */
    @Query("{\"bool\": {\"filter\": [{\"match\": {\"authorLiteraryWorks\": \"?0\"}}]}}")
    public List<LiteraryWorks> findByAuthorLiteraryWorks(String authorLiteraryWorks);

    /**
     * Return all the literary works that contain words given by the user in their titles.
     */
    @Query("{\"bool\": {\"filter\": [{\"match\": {\"nameLiteraryWorks\":{\"query\": \"?0\"}}}]}}")
    public List<LiteraryWorks> findByNameLiteraryWorks(String nameLiteraryWorks);

    /**
     * Return all the literary works with more pages than those indicated by the user.
     */
    @Query("{\"bool\": {\"filter\": [{\"range\": {\"quantityPagesLiteraryWorks\":{\"gt\": \"?0\"}}}]}}")
    public List<LiteraryWorks> findByQuantityPagesLiteraryWorksByRange(Integer quantityPagesLiteraryWorks);

    /**
     * Return all the literary works that were published before a year given by the user
     */

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"yearFirstEditionLiteraryWorks\":{\"lt\": \"?0\"}}}]}}")
    public List<LiteraryWorks> findByYearBeforeFirstEditionLiteraryWorksByRange(Integer yearFirstEditionLiteraryWorks);

    /**
     * Return all the literary works that were published after a year given by the user
     */
    @Query("{\"bool\": {\"filter\": [{\"range\": {\"yearFirstEditionLiteraryWorks\":{\"gt\": \"?0\"}}}]}}")
    public List<LiteraryWorks> findByYearAfterFirstEditionLiteraryWorksByRange(Integer yearFirstEditionLiteraryWorks);

    /**
     * Return all the literary works of the same publisher.
     */
    @Query("{\"bool\": {\"filter\": [{\"match\": {\"editorialLiteraryWorks\": \"?0\"}}]}}")
    public List<LiteraryWorks> findByEditorialLiteraryWorks(String editorialLiteraryWorks);
}