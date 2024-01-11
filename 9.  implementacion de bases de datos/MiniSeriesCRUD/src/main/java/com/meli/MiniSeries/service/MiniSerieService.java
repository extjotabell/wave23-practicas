package com.meli.MiniSeries.service;

import com.meli.MiniSeries.dto.MessageDTO;
import com.meli.MiniSeries.dto.MiniSerieReqDTO;
import com.meli.MiniSeries.dto.MiniSerieResDTO;
import com.meli.MiniSeries.exception.NotFoundException;
import com.meli.MiniSeries.model.MiniSerie;
import com.meli.MiniSeries.repository.IMiniSerieRepository;
import com.meli.MiniSeries.utils.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniSerieService implements IMiniSerieService {

    IMiniSerieRepository repository;

    public MiniSerieService(IMiniSerieRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MiniSerieResDTO> findAll() {
        return repository.findAll().stream()
            .map(DTOMapper::toDTO)
            .toList();
    }

    @Override
    public MiniSerieResDTO find(Long id) {
        return repository.findById(id)
            .map(DTOMapper::toDTO)
            .orElseThrow(() -> new NotFoundException("MiniSerie not found"));
    }

    @Override
    public MiniSerieResDTO save(MiniSerieReqDTO miniSerieReqDTO) {
        MiniSerie reqMiniSerie = DTOMapper.toModel(miniSerieReqDTO);
        MiniSerie savedMiniSerie = repository.save(reqMiniSerie);

        return DTOMapper.toDTO(savedMiniSerie);
    }

    @Override
    public MiniSerieResDTO update(Long id, MiniSerieReqDTO miniSerieReqDTO) {
        MiniSerie miniSerie = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("MiniSerie not found"));

        miniSerie.setName(miniSerieReqDTO.getName());
        miniSerie.setRating(miniSerieReqDTO.getRating());
        miniSerie.setAmountOfAwards(miniSerieReqDTO.getAmountOfAwards());

        MiniSerie updatedMiniSerie = repository.save(miniSerie);

        return DTOMapper.toDTO(updatedMiniSerie);
    }

    @Override
    public MessageDTO delete(Long id) {
        MiniSerie miniSerie = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("MiniSerie not found"));

        repository.delete(miniSerie);

        return new MessageDTO("MiniSerie " + miniSerie.getName() + " deleted");
    }
}
