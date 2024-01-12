package com.meli.obrasliterarias.services;


import com.meli.obrasliterarias.dtos.ObraLiterariaDTO;
import com.meli.obrasliterarias.mappers.ObraLiterariaMapper;
import com.meli.obrasliterarias.repositories.IObrasLiterariasRepository;
import org.springframework.stereotype.Service;

@Service
public class ObraLiterariaService {

    private IObrasLiterariasRepository obrasLiterariasRepository;

    public ObraLiterariaService(IObrasLiterariasRepository obrasLiterariasRepository) {
        this.obrasLiterariasRepository = obrasLiterariasRepository;
    }

    public ObraLiterariaDTO save(ObraLiterariaDTO obraLiteraria) {
        return ObraLiterariaMapper.toDTO(obrasLiterariasRepository.save(ObraLiterariaMapper.toEntity(obraLiteraria)));
    }
}
