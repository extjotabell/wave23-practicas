package meli.bootcamp.sprint1.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
  @JsonAlias("product_id")
  private int id;
  @JsonAlias("product_name")
  private String name;
  private String type;
  private String brand;
  private String notes;
  private String color;
}