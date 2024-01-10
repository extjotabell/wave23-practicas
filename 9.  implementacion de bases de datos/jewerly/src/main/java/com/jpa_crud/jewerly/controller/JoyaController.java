package com.jpa_crud.jewerly.controller;

import com.jpa_crud.jewerly.dto.response.ListaJoya;
import com.jpa_crud.jewerly.dto.response.NoIdentificatorioJoya;
import com.jpa_crud.jewerly.model.Joya;
import com.jpa_crud.jewerly.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class JoyaController {

    @Autowired
    IJoyaService joyaServ;

    @PostMapping("/jewerly/new")
    public ResponseEntity<NoIdentificatorioJoya> saveJoya (@RequestBody Joya joya) {
        return ResponseEntity.ok(joyaServ.createJewel(joya));
    }

    @GetMapping("/jewerly")
    public ResponseEntity<ListaJoya> getJoyas () {

        return ResponseEntity.ok(joyaServ.getAllJewelLogical());
    }

    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<String> deleteJoya (@PathVariable Long id) {
        return ResponseEntity.ok(joyaServ.deleteJewelLogical(id));
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<Joya> editJoya (@PathVariable Long id_modificar,
                            @RequestBody Joya joya) {
        return ResponseEntity.ok(joyaServ.updateJewel(id_modificar, joya));
    }


}
