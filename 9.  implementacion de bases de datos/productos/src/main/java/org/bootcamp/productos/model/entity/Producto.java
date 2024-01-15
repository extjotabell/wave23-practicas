package org.bootcamp.productos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "productos")
@TypeAlias("producto")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Producto {

    @Id
    private String id;

    private String nombre;
    private String tipo;
    private Double precio;
    private Double precioCosto;
    private Integer cantidad;

}
