package com.spring.codigoMorse.controllers;

import com.spring.codigoMorse.dto.MorseCodeRequest;
import com.spring.codigoMorse.entities.MorseCode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/morse")
public class MorseCodeController {

    private final MorseCode morseCode;

    public MorseCodeController(MorseCode morseCode) {
        this.morseCode = morseCode;
    }

    @PostMapping("/morseToText")
    public String morseToText(@RequestBody MorseCodeRequest request){
        return morseCode.morseToText(request.getMessage());
    }

    @PostMapping("/textToMorse")
    public String textToMorse(@RequestBody MorseCodeRequest request){
        return morseCode.textToMorse(request.getMessage());
    }


}
