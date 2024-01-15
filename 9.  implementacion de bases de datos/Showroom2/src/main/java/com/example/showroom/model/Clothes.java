package com.example.showroom.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "clothes")
public class Clothes {
  @Id
  private String code;
  private String name;
  private String brand;
  private String type;
  private String color;
  private int size;
  private String quantity;
  private double salePrice;
}
