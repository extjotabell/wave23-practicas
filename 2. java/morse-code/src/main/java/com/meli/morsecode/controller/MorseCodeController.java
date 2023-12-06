package com.meli.morsecode.controller;

import com.meli.morsecode.service.MorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/codemorse")
public class MorseCodeController {

    @Autowired
    MorseCodeService mcs;

    @GetMapping("/decode")
    public String decode(@RequestBody String message){
        return mcs.decode(message);
    }

    @GetMapping("/encode")
    public String encode(@RequestBody String message){
        return mcs.encode(message);
    }
}
