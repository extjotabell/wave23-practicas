package com.spring.cifrado.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CifradoController {

    @GetMapping("/encriptar")
    public String encriptar(@RequestParam String mensaje){
        int clave = 23;
        return cifrarCesar(mensaje,clave);
    }

    private String cifrarCesar(String mensaje, int clave){
        StringBuilder resultado = new StringBuilder();

        for(int i = 0; i <mensaje.length(); i++){
            char letra = mensaje.charAt(i);

            if(Character.isLetter(letra)){
                char inicio = Character.isLowerCase(letra) ? 'a' : 'A';
                resultado.append((char) ((letra -inicio +clave) % 26 + inicio));
            }else{
                resultado.append(letra);
            }
        }
        return resultado.toString();
    }
}

