package org.ejercicio.showroom.repository;

import org.ejercicio.showroom.model.entty.Clothes;
import org.ejercicio.showroom.model.entty.Sale;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends ElasticsearchRepository<Sale, String> {
    @Query("{\"term\": {\"number\": \"?0\"}}")
    Sale findByNumber(Integer number);

    List<Sale> findAllByDate(LocalDate date);
}
