package com.example.Employees.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employees")
@TypeAlias("employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String lastname;
    private String age;
    private String city;
    private String province;
}
