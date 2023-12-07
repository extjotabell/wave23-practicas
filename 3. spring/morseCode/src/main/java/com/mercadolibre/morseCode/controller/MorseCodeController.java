package com.mercadolibre.morseCode.controller;

import com.mercadolibre.morseCode.exception.InvalidMessageException;
import com.mercadolibre.morseCode.service.MorseCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling Morse code encoding and decoding requests.
 */
@RequestMapping("/morseCode")
@RestController
public class MorseCodeController {

    private final MorseCodeService morseCodeService;

    /**
     * Constructor to initialize the MorseCodeService.
     *
     * @param morseCodeService The MorseCodeService used for encoding and decoding Morse code messages.
     */
    public MorseCodeController(MorseCodeService morseCodeService) {
        this.morseCodeService = morseCodeService;
    }

    /**
     * Handles POST requests to encode a plain text message into Morse code.
     *
     * @param message The plain text message to be encoded.
     * @return A ResponseEntity containing the encoded Morse code or an error response.
     */
    @PostMapping("/encode")
    public ResponseEntity<String> encodeMessage(@RequestBody String message) {
        try {
            String encode = this.morseCodeService.encode(message);
            return ResponseEntity.ok(encode);
        } catch (InvalidMessageException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    /**
     * Handles POST requests to decode a Morse code message into plain text.
     *
     * @param message The Morse code message to be decoded.
     * @return A ResponseEntity containing the decoded plain text or an error response.
     */
    @PostMapping("/decode")
    public ResponseEntity<String> decodeMessage(@RequestBody String message){
        return ResponseEntity.ok(this.morseCodeService.decode(message));
    }

}
