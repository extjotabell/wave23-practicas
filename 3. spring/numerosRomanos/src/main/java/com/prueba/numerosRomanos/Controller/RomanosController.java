package com.prueba.numerosRomanos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api-romanos")
public class RomanosController {
    Map<Integer,String> numerosRomanos = new HashMap<Integer, String>(){{
        put(1,"I");
        put(2,"II");
        put(3,"III");
        put(4,"IV");
        put(5,"V");
        put(7,"VII");
        put(10,"X");
        put(13,"XIII");
        put(50,"L");
        put(100,"C");
        put(500,"D");
        put(1000,"M");
    }};

    @GetMapping("/{numero}")
    public String getNumeroRomano(@PathVariable int numero){
        if(numerosRomanos.containsKey(numero)) {
            return numerosRomanos.get(numero);
        } else {
            return "El número: " + numero + " no tiene su equivalente en romano";
        }
    }
}
