package com.mercadolibre.jeweler.controller;

import com.mercadolibre.jeweler.dto.request.JewerlyRequestDTO;
import com.mercadolibre.jeweler.dto.response.JewerlyEditedDTO;
import com.mercadolibre.jeweler.dto.response.JewerlyResponseDTO;
import com.mercadolibre.jeweler.dto.response.MessageDTO;
import com.mercadolibre.jeweler.service.IJewelerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewerlyController {

    private final IJewelerService jewServ;

    public JewerlyController(IJewelerService jewServ) {
        this.jewServ = jewServ;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<MessageDTO> addJewerly(@RequestBody JewerlyRequestDTO jewerlyRequestDTO) {
        return new ResponseEntity<>(jewServ.addJewerly(jewerlyRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JewerlyResponseDTO>> getJewerlys() {
        return new ResponseEntity<>(jewServ.getJewerlys(), HttpStatus.OK);
    }

    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<MessageDTO> deleteJewerly(@PathVariable long id) {
        return new ResponseEntity<>(jewServ.deleteJewerly(id), HttpStatus.OK);
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<JewerlyEditedDTO> updateJewerly(@PathVariable Long id_modificar,
                                                        @RequestBody JewerlyRequestDTO jewerlyRequestDTO) {
        return new ResponseEntity<>(jewServ.updateJewerly(id_modificar, jewerlyRequestDTO), HttpStatus.OK);
    }

}
