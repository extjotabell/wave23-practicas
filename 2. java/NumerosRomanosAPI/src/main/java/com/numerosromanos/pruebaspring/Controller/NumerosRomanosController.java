package com.numerosromanos.pruebaspring.Controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @PostMapping("/{romano}")
    public String convertirNumeroDecimal(@RequestParam double decimalConvertir){

        ConvertirNumeroRomanos convertirNumeroRomanos = new ConvertirNumeroRomanos();

        String numeroRomano = convertirNumeroRomanos.convertirDecimalNumerosRomano(decimalConvertir);

        return "El numero decimal " + decimalConvertir + " fue convertido a romano y el resultado es este:  " + numeroRomano;
    }

}
