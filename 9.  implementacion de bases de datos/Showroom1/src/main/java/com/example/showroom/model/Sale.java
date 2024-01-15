package com.example.showroom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int number;
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate date;
  private double total;
  private String paymentMethod;
  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(name = "SaleClothes")
  private List<Clothes> clothesList;
}
