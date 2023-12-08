package com.numerosRomanos.numerosRomanos.controllers;
import com.numerosRomanos.numerosRomanos.entities.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("numtoromano/{numero}")
    public String getNumeroRomano (@PathVariable int numero){
        return NumeroRomano.numeroARomano(numero);
    }

    @GetMapping("romanotonum/{numeroromano}")
    public String getNumero (@PathVariable String numeroromano){
        return NumeroRomano.romanoANumero(numeroromano);
    }
}
