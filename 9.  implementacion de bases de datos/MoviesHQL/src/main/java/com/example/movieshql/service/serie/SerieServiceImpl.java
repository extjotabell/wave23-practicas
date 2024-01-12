package com.example.movieshql.service.serie;

import com.example.movieshql.dto.ActorDto;
import com.example.movieshql.dto.SeriesDto;
import com.example.movieshql.model.Serie;
import com.example.movieshql.repository.SerieRepository;
import com.example.movieshql.utils.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {

    private final SerieRepository serieRepository;

    public SerieServiceImpl(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SeriesDto> findSeriesBySeasonAmountHigherThan(int amount) {
        return serieRepository.findSeriesBySeasonAmountHigherThan(amount)
                .stream().map(DTOMapper::mapToSerieDTO).toList();
    }
}
