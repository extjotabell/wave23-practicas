package com.example.servicio_cifrado.services;

import org.springframework.stereotype.Service;

@Service
public class ServicioCifradoService {
    public static String cifrar(String mensaje, String clave) {
        StringBuilder res = new StringBuilder();
        String alfabeto = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

        int posClave = 0;

        for (int i = 0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);
            if (c == ' ') continue;

            int desplazamiento = Character.getNumericValue(clave.charAt(posClave));
            posClave = (posClave + 1) % clave.length();

            int posOriginal = alfabeto.indexOf(Character.toUpperCase(c));
            int posNueva = (posOriginal + desplazamiento) % alfabeto.length();

            res.append(alfabeto.charAt(posNueva));
        }

        return res.toString();
    }
}
