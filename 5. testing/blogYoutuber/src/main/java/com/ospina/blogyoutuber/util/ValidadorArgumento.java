package com.ospina.blogyoutuber.util;

import com.ospina.blogyoutuber.excepcion.ValidacionExcepcion;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorArgumento {
	
	private ValidadorArgumento() {}

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ValidacionExcepcion(mensaje);
        }
    }

}
