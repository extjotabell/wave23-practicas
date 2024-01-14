package org.ejercicio.elasticsearch.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "employees")
@TypeAlias("employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String surname;
    private Byte age;
    private String province;
    private String city;

    public Employee(String name, String surname, Byte edad, String province, String city) {
        this.name = name;
        this.surname = surname;
        this.age = edad;
        this.province = province;
        this.city = city;
    }
}
