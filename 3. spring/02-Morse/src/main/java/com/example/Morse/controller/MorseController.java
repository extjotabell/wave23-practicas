package com.example.Morse.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-morse")
public class MorseController {
    @Autowired
    private MorseService morseService;

    @GetMapping("/decoder/{message}")
    public String getMessageDecoded(@PathVariable String message){
        return  morseService.decodeMorse(message);
    }
    @GetMapping("/encoder/{message}")
    public String getMessageCoded(@PathVariable String message){
        return  morseService.codeMorse(message);
    }
}
