package com.example.empleadosnorelacional.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleados")
@Data
@TypeAlias("empleado")
public class Empleado {
  @Id
  private String id;
}
