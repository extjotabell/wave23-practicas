package com.edadPersona.servicio;

import com.edadPersona.excepcion.FechaNacimientoInvalidaException;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class ServicioEdad {

    public Integer calcularEdad(int dia, int mes, int anio) throws FechaNacimientoInvalidaException {
        try {
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();
            if (fechaNacimiento.isAfter(fechaActual)) throw new IllegalArgumentException("La fecha de nacimiento no puede ser mayor a la fecha actual");
            Period periodo = Period.between(fechaNacimiento, fechaActual);
            return periodo.getYears();
        } catch (DateTimeException e) {
            throw new FechaNacimientoInvalidaException();
        }
    }
}
