package com.example.literatura.repository;

import com.example.literatura.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ObraRepository extends ElasticsearchRepository<Obra, String> {
}
