package com.example.joyerialasperlas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageJewelDTO {
  private int status;
  private JewelDTO jewel;

}
