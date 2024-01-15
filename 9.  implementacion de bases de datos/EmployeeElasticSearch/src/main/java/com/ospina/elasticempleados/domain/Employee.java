package com.ospina.elasticempleados.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@Document(indexName = "employee")
public class Employee {

    @Id
    String id;
    String name;
    String lastName;
    Integer age;
    String city;
    String department;
}
