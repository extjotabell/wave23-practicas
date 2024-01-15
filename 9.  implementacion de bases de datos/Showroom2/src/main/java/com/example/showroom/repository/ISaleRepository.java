package com.example.showroom.repository;

import com.example.showroom.model.Sale;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends ElasticsearchRepository<Sale, String> {

  List<Sale> findAllByDate(LocalDate date);

}
