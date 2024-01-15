package org.ejercicio.showroom.repository;

import org.ejercicio.showroom.model.entty.Clothes;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepository extends ElasticsearchRepository<Clothes, String> {
    @Query("{\"term\": {\"code.keyword\": \"?0\"}}")
    Clothes findByCode(String code);

    @Query("{\"match\": {\"size\": \"?0\"}}")
    List<Clothes> findBySize(Integer size);


    @Query("{\"match\": {\"name\": \"?0\"}}")

    List<Clothes> findByName(String name);
}
