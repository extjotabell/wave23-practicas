package spring.elastic.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
//@Document(indexName = "blog")
public class Autor {
    private String nombre;
}
