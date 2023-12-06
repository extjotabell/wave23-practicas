package com.bootcamp.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/romanos")
public class RomanosRestController {

    private final Integer[] decimales = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] romanos = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @GetMapping("/{num}")
    public String decimalARomano(@PathVariable Integer num){
        StringBuilder resultado = new StringBuilder();
        int i = 0;
        while(num > 0 || decimales.length == (i - 1)){
            while ((num - decimales[i]) >= 0) {
                num -= decimales[i];
                resultado.append(romanos[i]);
            }
            i++;
        }
        return resultado.toString();
    }

}
