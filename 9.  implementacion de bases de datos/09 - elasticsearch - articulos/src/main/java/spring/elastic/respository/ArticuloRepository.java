package spring.elastic.respository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import spring.elastic.domain.Articulo;

public interface ArticuloRepository extends ElasticsearchRepository<Articulo, String> {
}
