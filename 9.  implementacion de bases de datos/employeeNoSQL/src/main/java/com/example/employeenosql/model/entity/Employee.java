package com.example.employeenosql.model.entity;

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
@TypeAlias("employees")
public class Employee {
    @Id
    private String id;
    private String nameEmployee;
    private String lastNameEmployee;
    private String ageEmployee;
    private String cityEmployee;
    private String provinceEmployee;
}
