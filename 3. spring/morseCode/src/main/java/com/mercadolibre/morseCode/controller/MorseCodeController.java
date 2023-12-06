package com.mercadolibre.morseCode.controller;

import com.mercadolibre.morseCode.exception.InvalidMessageException;
import com.mercadolibre.morseCode.service.MorseCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/morseCode")
@RestController
public class MorseCodeController {

    private MorseCodeService morseCodeService;

    public MorseCodeController(MorseCodeService morseCodeService) {
        this.morseCodeService = morseCodeService;
    }

    @PostMapping("/encode")
    public ResponseEntity<String> encodeMessage(@RequestBody String message) {
        try {
            String encode = this.morseCodeService.encode(message);
            return ResponseEntity.ok(encode);
        } catch (InvalidMessageException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/decode")
    public ResponseEntity<String> decodeMessage(@RequestBody String message){
        return ResponseEntity.ok(this.morseCodeService.decode(message));
    }

}
