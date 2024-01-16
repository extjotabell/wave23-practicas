package org.ejercicio.showroom.model.entty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "clothes")
@TypeAlias("clothes")
public class Clothes {
    @Id
    private String id;
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private Integer size;
    private Integer count;
    private Double price;
}
