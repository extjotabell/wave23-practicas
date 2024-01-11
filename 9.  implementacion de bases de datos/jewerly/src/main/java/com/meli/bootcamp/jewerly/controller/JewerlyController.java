package com.meli.bootcamp.jewerly.controller;

import com.meli.bootcamp.jewerly.dto.BaseResponseDto;
import com.meli.bootcamp.jewerly.dto.JewerlyDto;
import com.meli.bootcamp.jewerly.service.JewerlyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {
    private JewerlyServiceImpl serv;

    public JewerlyController(JewerlyServiceImpl serv) {
        this.serv = serv;
    }

    @PostMapping("/new")
    ResponseEntity<BaseResponseDto> save(@RequestBody JewerlyDto jewerlyDto){
        return new ResponseEntity<>(serv.save(jewerlyDto), HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<JewerlyDto>> getAll(){
        return new ResponseEntity<>(serv.getAll(),HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    ResponseEntity<BaseResponseDto> delete(@PathVariable Long id){
        return new ResponseEntity<>(serv.delete(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<JewerlyDto> update(@PathVariable Long id, @RequestBody JewerlyDto jewerlyDto){
        return new ResponseEntity<>(serv.update(id,jewerlyDto), HttpStatus.OK);
    }

}
