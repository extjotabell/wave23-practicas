package org.ejercicio.crud.utils;

import org.ejercicio.crud.DTO.StudentDTO;
import org.ejercicio.crud.exception.BadRequestException;
import org.ejercicio.crud.model.Student;

public class Verification {

    public static void studentExists(StudentDTO studentDTO, Long id) {
        if (studentDTO == null) {
            throw new BadRequestException("El estudiante con id: " + id + " no existe.");
        }
    }

    public static void studentExists(Student student, Long id) {
        if (student == null) {
            throw new BadRequestException("El estudiante con id: " + id + " no existe.");
        }
    }
}
