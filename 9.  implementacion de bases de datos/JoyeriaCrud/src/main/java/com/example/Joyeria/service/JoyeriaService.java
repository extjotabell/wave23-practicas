package com.example.Joyeria.service;

import com.example.Joyeria.dto.request.NewJoyaDto;
import com.example.Joyeria.dto.response.BaseResponseDto;
import com.example.Joyeria.exception.NotFoundException;
import com.example.Joyeria.model.Joya;
import com.example.Joyeria.repository.IJoyeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaService implements IJoyeriaService{

    @Autowired
    IJoyeriaRepository repository;

    @Override
    public BaseResponseDto saveJoya(NewJoyaDto joya) {
        Joya newJoya = repository.save(newJoyaDtoToJoya(joya));

        return new BaseResponseDto("Joya guardada correctamente con id " + newJoya.getNro_id());
    }

    private Joya newJoyaDtoToJoya(NewJoyaDto newJoyaDto) {
        Joya joya = new Joya();
        joya.setNombre(newJoyaDto.getNombre());
        joya.setMaterial(newJoyaDto.getMaterial());
        joya.setPeso(newJoyaDto.getPeso());
        joya.setParticularidad(newJoyaDto.getParticularidad());
        joya.setPosee_piedra(newJoyaDto.getPoseePiedra());
        joya.setVentaONo(false);
        return joya;
    }

    @Override
    public List<Joya> getJoyas() {
        return repository.findByVentaONo(false);
    }

    @Override
    public BaseResponseDto deleteJoya(Long id) {
        Joya joya = repository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró la joya id: " + id));
        joya.setVentaONo(true);
        repository.save(joya);
        return new BaseResponseDto("Joya borrada");
    }

    @Override
    public Joya editJoya(Long id_modificar, Joya joya_modif) {
        Joya joyaOriginal = repository.findById(id_modificar).orElseThrow(() -> new NotFoundException("No se encontró la joya id: " + id_modificar));

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.isPosee_piedra());
        joyaOriginal.setVentaONo(joya_modif.isVentaONo());

        return repository.save(joyaOriginal);
    }
}
