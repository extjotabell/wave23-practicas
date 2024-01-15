package com.ospina.elasticempleados.domain.dto;

import lombok.Value;

@Value
public class EmployeeDTO {
    String name;
    String lastName;
    Integer age;
    String city;
    String department;

}
