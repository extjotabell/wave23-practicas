package com.meli.encrypted.controller;


import com.meli.encrypted.exception.EncyptorException;
import com.meli.encrypted.model.Request;
import com.meli.encrypted.service.EncryptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/encryptor")
public class EncryptorController {

    @Autowired
    EncryptorService encryptorService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping()  {
        return  new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> encryptKeyTwo(@RequestBody Request request) throws EncyptorException {
        return request.getMovements() != null ? new ResponseEntity<>(encryptorService.encryptKey( request.getSentence(), request.getMovements()), HttpStatus.OK)
                : new ResponseEntity<>(encryptorService.encryptKeyDefault(request.getSentence()), HttpStatus.OK);
    }
}
