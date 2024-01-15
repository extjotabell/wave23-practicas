package com.ospina.showroom.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaUtilidad {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate convertirFecha(String fecha) {
        try {
            return LocalDate.parse(fecha, formatter);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Formato de fecha incorrecto. Por favor, use el formato dd/MM/yyyy", e.getParsedString(), e.getErrorIndex());
        }
    }
}