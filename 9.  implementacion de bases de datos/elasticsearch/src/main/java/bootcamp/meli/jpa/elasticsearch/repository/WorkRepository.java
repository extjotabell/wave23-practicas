package bootcamp.meli.jpa.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import bootcamp.meli.jpa.elasticsearch.model.Work;

@Repository
public interface WorkRepository extends ElasticsearchRepository<Work, String> {
  public List<Work> findByFinishedInfoIsNotNull();

  public List<Work> findByCreatedAtGreaterThanEqual(String date);
}