package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDto;
import com.example.joyeria.dto.ListJoyaDto;
import com.example.joyeria.dto.MessageDto;
import com.example.joyeria.entity.Joya;
import com.example.joyeria.repository.JoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImp implements JoyaService{

    private final JoyaRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public JoyaServiceImp(JoyaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ListJoyaDto getJoyasList() {
        List<Joya> joyas = repository.findAll();
        ListJoyaDto joyasDto = new ListJoyaDto();
        joyasDto.setJoyas(joyas.stream().
                map(joya -> mapper.convertValue(joya, JoyaDto.class))
                .toList());
        return joyasDto;
    }

    @Override
    public MessageDto addJoya(JoyaDto joya) {
        Joya newJoya = mapper.convertValue(joya, Joya.class);
        repository.save(newJoya);
        return new MessageDto("Nueva joya agregada");
    }

    @Override
    public ListJoyaDto deleteJoya(Long id) {
        repository.deleteById(id);
        return getJoyasList();
    }

    @Override
    public JoyaDto updateJoya(JoyaDto joya, Long id) {
        Joya update = repository.findById(id).orElse(null);
        update.setMaterial(joya.getMaterial());
        update.setPeso(joya.getPeso());
        update.setNombre(joya.getNombre());
        update.setParticularidad(joya.getParticularidad());
        update.setPosee_piedra(joya.getPosee_piedra());

        repository.save(update);
        return mapper.convertValue(update, JoyaDto.class);
    }


}
