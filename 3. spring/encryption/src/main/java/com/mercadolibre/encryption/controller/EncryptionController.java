package com.mercadolibre.encryption.controller;

import com.mercadolibre.encryption.entity.EncryptRequest;
import com.mercadolibre.encryption.entity.EncryptResult;
import com.mercadolibre.encryption.service.EncryptionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for message encryption using the Caesar cipher.
 */
@RestController
@RequestMapping("/encryption")
public class EncryptionController {

    private final EncryptionService encryptionService;

    /**
     * Constructor to initialize EncryptionController with an EncryptionService instance.
     *
     * @param encryptionService The service responsible for handling message encryption.
     */
    public EncryptionController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    /**
     * Endpoint to handle POST requests for message encryption.
     *
     * @param request The request object containing the text to encrypt and the encryption key.
     * @return An EncryptResult object containing the encrypted message using key '23' and the provided key.
     */
    @PostMapping(value = "/encrypt", consumes = "text/plain;charset=UTF-8", produces = "text/plain;charset=UTF-8")
    public EncryptResult encrypt(@RequestBody EncryptRequest request) {
        String text = request.getText();
        String key = request.getKey();
        return encryptionService.encrypt(text, key);
    }
}