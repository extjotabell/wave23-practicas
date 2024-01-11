package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.JewelCreationDTO;
import com.example.joyerialasperlas.dto.JewelDTO;
import com.example.joyerialasperlas.dto.JewelIdDTO;
import com.example.joyerialasperlas.dto.MessageJewelDTO;
import com.example.joyerialasperlas.service.IJewelService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jewerly")
public class JewelController {

  private final IJewelService service;

  public JewelController(IJewelService service) {
    this.service = service;
  }

  @PostMapping("/new")
  public ResponseEntity<JewelIdDTO> createJewel(@RequestBody JewelCreationDTO jewel) {
    return ResponseEntity.status(200).body(service.createJewel(jewel));
  }

  @GetMapping()
  public ResponseEntity<List<JewelDTO>> getAll(){
    return ResponseEntity.status(200).body(service.getAll());
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteJewel(@PathVariable Long id){
    return ResponseEntity.status(200).body(service.deleteJewel(id));
  }

  @PutMapping("/update/{id_modificar}")
  public ResponseEntity<MessageJewelDTO> updateJewel(@PathVariable Long id_modificar, @RequestBody JewelCreationDTO jewelDTO){
    return ResponseEntity.status(200).body(service.updateJewel(jewelDTO, id_modificar));
  }
}
