package com.meli.sqlshowroom.util;

import com.meli.sqlshowroom.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public class Validations {
    public static void checkIfEmpty(List<?> list) {
        if (list.isEmpty()) {
            throw new NotFoundException("No se encontraron resultados");
        }
    }

    public static void checkIfEmpty(Optional<?> optional) {
        if (optional.isEmpty()) {
            throw new NotFoundException("No se encontraron resultados");
        }
    }
}
