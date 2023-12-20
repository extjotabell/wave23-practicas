package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@Validated
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Size(min = 3, max = 50, message = "La longitud del nombre no puede ser menor a 3 ni superar los 50 caracteres.")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede estar vacía.")
    List<@Valid SubjectDTO> subjects;
}
