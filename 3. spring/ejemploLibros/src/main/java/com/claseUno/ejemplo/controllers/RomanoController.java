package com.claseUno.ejemplo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/romanos")
public class RomanoController {

    @GetMapping("/convertir/{numero}")
    public String convertirARomano(@PathVariable Integer numero) {
        return getRomano2(numero);
    }

    private String getRomano(Integer numero) {
        if (numero < 1 || numero > 3999) {
            return "El número debe estar entre 1 y 3999";
        }

        String[] simbolos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        Integer[] valores = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder resultado = new StringBuilder();

        int indice = valores.length - 1;

        while (numero > 0) {
            if (numero >= valores[indice]) {
                resultado.append(simbolos[indice]);
                numero -= valores[indice];
            } else {
                indice--;
            }
        }
        return resultado.toString();
    }

    private String getRomano2(Integer numero) {
        if (numero < 1 || numero > 3999) {
            return "El número debe estar entre 1 y 3999";
        }
        String resultado = "";
        while (numero > 0) {
            if (numero >= 1000) {
                resultado += "M";
                numero -= 1000;
                continue;
            }
            if (numero >= 900) {
                resultado += "CM";
                numero -= 900;
                continue;
            }
            if (numero >= 500) {
                resultado += "D";
                numero -= 500;
                continue;
            }
            if (numero >= 400) {
                resultado += "CD";
                numero -= 40;
                continue;
            }
            if (numero >= 100) {
                resultado += "C";
                numero -= 100;
                continue;
            }
            if (numero >= 90) {
                resultado += "XC";
                numero -= 90;
                continue;
            }
            if (numero >= 50) {
                resultado += "L";
                numero -= 50;
                continue;
            }
            if (numero >= 40) {
                resultado += "XL";
                numero -= 40;
                continue;
            }
            if (numero >= 10) {
                resultado += "X";
                numero -= 10;
                continue;
            }
            if (numero >= 9) {
                resultado += "IX";
                numero -= 9;
                continue;
            }
            if (numero >= 5) {
                resultado += "V";
                numero -= 5;
                continue;
            }
            if (numero >= 4) {
                resultado += "IV";
                numero -= 4;
                continue;
            }
            if (numero >= 1) {
                resultado += "I";
                numero -= 1;
                continue;
            }
        }
        return resultado;
    }

}

