package com.bootcamp.joyeriaLasPerlas.service;

import com.bootcamp.joyeriaLasPerlas.dto.request.JewerlyDto;
import com.bootcamp.joyeriaLasPerlas.model.Jewerly;
import com.bootcamp.joyeriaLasPerlas.repository.IJewerlyRespository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewerlyService implements IJewerlyService {

    private final IJewerlyRespository jewerlyRepo;

    public JewerlyService(IJewerlyRespository joyaRepoo){
        this.jewerlyRepo = joyaRepoo;
    }
    @Override
    @Transactional(readOnly=true)
    public List<Jewerly> getJewerlys() {

        return jewerlyRepo.findAll().stream().filter(jewerly -> jewerly.getVentaONo().equals(true)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveJewerly(@RequestBody Jewerly jewerly) {
        jewerly.setVentaONo(true);
         jewerlyRepo.save(jewerly);
    }

    @Override
    @Transactional
    public void deleteJewerly(long id) {

        Jewerly jewerly = this.findJewerly(id);
        jewerly.setVentaONo(false);
    }

    @Override
    @Transactional(readOnly=true)
    public Jewerly findJewerly(long id) {
        return jewerlyRepo.findById(id).orElse(null);
    }

    @Override
    public Jewerly updateJewerly(Jewerly originalJewerly, JewerlyDto jewerlyDto) {

        originalJewerly.setMaterial(jewerlyDto.getMaterial());
        originalJewerly.setNombre(jewerlyDto.getNombre());
        originalJewerly.setParticularidad(jewerlyDto.getParticularidad());
        originalJewerly.setVentaONo(jewerlyDto.getVentaONo());
        originalJewerly.setPeso(jewerlyDto.getPeso());
        originalJewerly.setPosee_piedra(jewerlyDto.getPosee_piedra());

        this.saveJewerly(originalJewerly);

        return originalJewerly;
    }


}
