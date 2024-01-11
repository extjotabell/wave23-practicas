package com.meli.compositekey.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "orders")
@IdClass(OrderKey.class)
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "customer_id")
    private Integer customerId;
    @Id
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
}
