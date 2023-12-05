package com.cifrado.Cesar;

import org.springframework.web.bind.annotation.*;

@RestController
public class CifradoController {

    static private boolean esValidoTexto(String texto) {
        for(Character c : texto.toCharArray()) {
            if (!Character.isLetter(c)) return false;
        }
        return true;
    }

    static private boolean esValidaClave(String clave) {
        for(Character c : clave.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    @PostMapping("/encriptar")
    public String cifrar(@RequestBody CesarEntitity cesar){
        String texto = cesar.getTexto();
        String clave = cesar.getClave();

        if (!esValidoTexto(texto)) return "El texto sólo permite carácteres";
        if (!esValidaClave(clave)) return "La clave sólo admite dìgitos";

        texto = texto.toLowerCase();
        return ServicioCifrado.cifrar(texto, clave);
    }

    @PostMapping("/desencriptar")
    public String descifrar(@RequestBody CesarEntitity cesar){
        String texto = cesar.getTexto();
        String clave = cesar.getClave();

        if (!esValidoTexto(texto)) return "El texto sólo permite carácteres";
        if (!esValidaClave(clave)) return "La clave sólo admite dìgitos";

        texto = texto.toLowerCase();
        return ServicioCifrado.descifrar(texto, clave);
    }

}
