package spring.CRUDJPA.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String dni;
    private String name;
    private String lastname;
}
