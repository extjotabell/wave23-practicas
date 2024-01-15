package com.example.miniserie.service;

import com.example.miniserie.dto.MiniSerieDTO;
import com.example.miniserie.dto.MiniSeriesDTO;
import com.example.miniserie.dto.ResponseDTO;
import com.example.miniserie.model.MiniSerie;
import com.example.miniserie.repository.IMiniserieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiniserieServiceImp implements IMiniserieService {
    private final IMiniserieRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public MiniserieServiceImp(IMiniserieRepository repository) {
        this.repository = repository;
    }

    @Override
    public MiniSeriesDTO getAll() {
        List<MiniSerie> miniSerie = repository.findAll();
        List<MiniSerieDTO> miniSerieDTOS = miniSerie.stream().map(serie -> objectMapper.convertValue(serie, MiniSerieDTO.class)).toList();
        return new MiniSeriesDTO(miniSerieDTOS);
    }

    @Override
    public ResponseDTO save(MiniSerieDTO miniSerieDTO) {
        MiniSerie miniSerie = objectMapper.convertValue(miniSerieDTO, MiniSerie.class);
        repository.save(miniSerie);
        return new ResponseDTO("Saved successfully - " + miniSerie);
    }

    @Override
    public ResponseDTO delete(Long id) {
        repository.deleteById(id);
        return new ResponseDTO("Deleted successfully");
    }

    @Override
    public MiniSerieDTO findById(Long id) {
        Optional<MiniSerie> miniSerieOptional = repository.findById(id);

        if (miniSerieOptional.isPresent()) {
            MiniSerie miniSerie = miniSerieOptional.get();
            return objectMapper.convertValue(miniSerie, MiniSerieDTO.class);
        } else {
            return null;
        }
    }
}
