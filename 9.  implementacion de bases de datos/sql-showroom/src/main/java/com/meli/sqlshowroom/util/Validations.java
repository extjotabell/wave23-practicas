package com.meli.sqlshowroom.util;

import com.meli.sqlshowroom.exception.NotFoundException;

import java.util.List;

public class Validations {
    public static void checkIfEmptyList(List<?> list) {
        if (list.isEmpty()) {
            throw new NotFoundException("No se encontraron resultados");
        }
    }
}
