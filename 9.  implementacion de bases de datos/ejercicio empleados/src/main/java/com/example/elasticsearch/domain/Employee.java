package com.example.elasticsearch.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String age;
    private String city;
    private String state;
}
