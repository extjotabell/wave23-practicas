package com.example.libreria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "literature")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  @Id
  private String id;
  private String title;
  private String author;
  private int pageCount;
  private String publisher;
  private int publicationYear;
}
