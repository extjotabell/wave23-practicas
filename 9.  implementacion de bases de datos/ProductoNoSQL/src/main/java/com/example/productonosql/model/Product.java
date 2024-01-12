package com.example.productonosql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product")
@Data
public class Product {

  @Id
  private String id;
  private String nombre;
  private String tipo;
  private double precioVenta;
  private double precioCosto;
  private int cantidadDisponible;
}
