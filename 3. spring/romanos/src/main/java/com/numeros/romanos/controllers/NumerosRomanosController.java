package com.numeros.romanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/numerosRomanos")
public class NumerosRomanosController {
    private final static TreeMap<Integer, String> numeros = new TreeMap<>();
     static{
     numeros.put(1,"I");
     numeros.put(4,"IV");
     numeros.put(5,"V");
     numeros.put(9,"IX");
     numeros.put(10,"X");
     numeros.put(40,"XL");
     numeros.put(50,"L");
     numeros.put(90,"XC");
     numeros.put(100,"C");
     numeros.put(400,"CD");
     numeros.put(500,"D");
     numeros.put(900,"CM");
     numeros.put(1000,"M");
     }

    @GetMapping("/convertir/{numero}")
    public String convertirNumero(@PathVariable int numero){
    String res ="";
     while(numero>0){
     if(numeros.get(numero)!=null){
     res+= numeros.get(numero);
     return res;
     }else{
     Integer piso = numeros.floorKey(numero);
     numero -= piso;
     res+= numeros.get(piso);
     }
     }
     return res;


    }


}
