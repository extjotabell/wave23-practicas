package com.meli.bootcamp.jewerly.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.bootcamp.jewerly.dto.BaseResponseDto;
import com.meli.bootcamp.jewerly.dto.JewerlyDto;
import com.meli.bootcamp.jewerly.model.Jewerly;
import com.meli.bootcamp.jewerly.repository.IJewerlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewerlyServiceImpl implements IJewerlyService{
    private ObjectMapper mapper;
    private IJewerlyRepository repo;

    public JewerlyServiceImpl(ObjectMapper mapper, IJewerlyRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    public BaseResponseDto save(JewerlyDto jewerlyDto) {
        Jewerly jewerly = mapper.convertValue(jewerlyDto,Jewerly.class);
        Optional.ofNullable(jewerly)
                .ifPresentOrElse(repo::save, () -> {
                    throw new RuntimeException("La entidad Jewerly es nula.");
                });
        return new BaseResponseDto("Joya agregada con éxito. ID: " + jewerly.getId());
    }

    public List<JewerlyDto> getAll() {
        List<Jewerly> jewerlyList = Optional.ofNullable(repo.findAll()).
                orElseThrow(() -> new RuntimeException("No hay joyas cargadas"));
        return jewerlyList.stream()
                .map(jewerly -> mapper.convertValue(jewerly,JewerlyDto.class))
                .collect(Collectors.toList());
    }

    public BaseResponseDto delete(Long id) {
        Jewerly jewerly = this.repo.findById(id)
                .orElseThrow(() -> new RuntimeException("ID Not found"));

        jewerly.setVenta_o_no(false);
        repo.save(jewerly);

        return new BaseResponseDto("Joya eliminada correctamente");
    }

    public JewerlyDto update(Long id, JewerlyDto jewerlyDto) {
        Jewerly jewerly = this.repo.findById(id)
                .orElseThrow(() -> new RuntimeException("ID Not found"));

        jewerly.setNombre(jewerlyDto.getNombre());
        jewerly.setPeso(jewerlyDto.getPeso());
        jewerly.setMaterial(jewerlyDto.getMaterial());
        jewerly.setPosee_piedra(jewerlyDto.getPosee_piedra());
        jewerly.setParticularidad(jewerlyDto.getParticularidad());
        repo.save(jewerly);

        return mapper.convertValue(jewerly,JewerlyDto.class);
    }
}
