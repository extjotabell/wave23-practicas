package com.example.showroom.model;

import static org.springframework.data.elasticsearch.annotations.FieldType.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "sale")
public class Sale {
  @Id
  private String number;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Field(type = Date,pattern = "yyyy-MM-dd")
  private LocalDate date;
  private Double total;
  private String paymentMethod;
  private List<Clothes> clothesList;
}
