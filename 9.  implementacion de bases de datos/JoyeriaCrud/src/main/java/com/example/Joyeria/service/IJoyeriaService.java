package com.example.Joyeria.service;

import com.example.Joyeria.dto.request.NewJoyaDto;
import com.example.Joyeria.dto.response.BaseResponseDto;
import com.example.Joyeria.model.Joya;

import java.util.List;

public interface IJoyeriaService {

     BaseResponseDto saveJoya(NewJoyaDto joya);
     List<Joya> getJoyas();
     BaseResponseDto deleteJoya(Long id);
     Joya editJoya(Long id_modificar, Joya joya_modif);

}
