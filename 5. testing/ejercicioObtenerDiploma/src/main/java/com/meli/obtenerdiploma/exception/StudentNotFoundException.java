package com.meli.obtenerdiploma.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
public class StudentNotFoundException extends ObtenerDiplomaException {

    public StudentNotFoundException(Long id) {
        super("El alumno con Id " + id + " no se encuetra registrado.", HttpStatus.NOT_FOUND);
    }

    @Override
    public String toString() {
        return "StudentNotFoundException{}";
    }
}
