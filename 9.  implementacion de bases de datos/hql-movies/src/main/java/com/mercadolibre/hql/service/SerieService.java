package com.mercadolibre.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.hql.dto.SerieDTO;
import com.mercadolibre.hql.repository.SerieRepository;
import com.mercadolibre.hql.utils.SerieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {

    SerieRepository serieRepository;
    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieDTO> findAllByMinimumNumberOfSeasons(Integer numberSeasons) {
        return serieRepository.findAllByMinimumNumberOfSeasons(numberSeasons).stream()
                .map(SerieMapper::serieMap)
                .toList();
    }
}
