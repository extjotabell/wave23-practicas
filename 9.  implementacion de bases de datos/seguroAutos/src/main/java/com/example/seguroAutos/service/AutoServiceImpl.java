package com.example.seguroAutos.service;

import com.example.seguroAutos.dto.AutoDto;
import com.example.seguroAutos.dto.MessageDto;
import com.example.seguroAutos.repository.AutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.seguroAutos.utils.Mapper.autoDtoToAuto;

@Service
public class AutoServiceImpl implements  AutoService{

    private final AutoRepository autoRepository;

    public AutoServiceImpl(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public List<String> getPatentes() {
        return autoRepository.getPatentes();
    }

    @Override
    public MessageDto addAuto(AutoDto auto) {
        autoRepository.save(autoDtoToAuto(auto));
        return new MessageDto("Nuevo auto registrado");
    }

    @Override
    public List<String> getPatenteMarcaOrdenado() {
        return autoRepository.getPatenteMarcaOrdenado();
    }
}
