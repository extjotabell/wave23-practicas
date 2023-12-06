package com.cifrado.cesar.controller;
import com.cifrado.cesar.model.CifradoEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CifradoCesar {
    List<Character> abecedario = List.of('A','B','C','D','E','F','G','H','I',
            'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');

    public char encriptarMensaje(char letra, int n){
        return abecedario.get((abecedario.indexOf(letra)+n)%abecedario.size());
    }

    public char desencriptarMensaje(char letra, int n){
        return abecedario.get((abecedario.indexOf(letra)-n)%abecedario.size());
    }

    @PostMapping("/encriptar")
    public String encriptar(@RequestBody CifradoEntity cesar){
        String cifrado ="";
        for (int i = 0; i <cesar.getMensaje().length() ; i++) {
            int indiceClave = i % cesar.getClave().length();
            int n = Character.getNumericValue(cesar.getClave().charAt(indiceClave));
            cifrado += encriptarMensaje(cesar.getMensaje().charAt(i),n);
        }
        return cifrado;
    }
    @PostMapping("/desencriptar")
    public String desencriptar(@RequestBody CifradoEntity cesar){
        String cifrado ="";
        for (int i = 0; i <cesar.getMensaje().length() ; i++) {
            int indiceClave = i % cesar.getClave().length();
            int n = Character.getNumericValue(cesar.getClave().charAt(indiceClave));
            cifrado += desencriptarMensaje(cesar.getMensaje().charAt(i),n);
        }
        return cifrado;
    }

}
