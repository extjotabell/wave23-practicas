package com.meli.elasticsearchempleados.domain.DTO;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String id;
    private String name;
    private String lastname;
    private Integer age;
    private String city;
    private String state;
}
