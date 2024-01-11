package org.ejercicio.joyeria.utils;

import org.ejercicio.joyeria.DTO.JewerlyDTO;
import org.ejercicio.joyeria.exception.BadRequestException;
import org.ejercicio.joyeria.model.Jewerly;

public class Verification {

    public static void jewerlyExists(JewerlyDTO studentDTO, Long id) {
        if (studentDTO == null) {
            throw new BadRequestException("El estudiante con id: " + id + " no existe.");
        }
    }

    public static void jewerlyExists(Jewerly student, Long id) {
        if (student == null) {
            throw new BadRequestException("El estudiante con id: " + id + " no existe.");
        }
    }

    public static void jewelIsSaleOnTrue(JewerlyDTO jewerly) {
        if (!jewerly.getSaleOrNot()){
            throw new BadRequestException("La joya no cumple el requisito de que puede ser vendida.");
        }
    }

    public static void jewelIsSaleOnFalse(Jewerly jewerly) {
        if (jewerly.getSaleOrNot()){
            throw new BadRequestException("La joya sigue a la venta, no se puede eliminar.");
        }
    }
}
