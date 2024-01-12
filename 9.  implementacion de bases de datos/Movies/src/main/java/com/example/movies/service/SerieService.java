package com.example.movies.service;

import com.example.movies.dto.SerieDTO;
import com.example.movies.dto.SerieNumberSeasonDTO;
import com.example.movies.models.Serie;
import com.example.movies.repository.SerieRepository;
import com.example.movies.utils.Mapper;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SerieService {
  private final SerieRepository serieRepository;

  public SerieService(SerieRepository serieRepository) {
    this.serieRepository = serieRepository;
  }

  public List<SerieNumberSeasonDTO> getSeriesWithNumberSeasonsGreater(Integer numberSeasons){
    return serieRepository.findAllWithGreaterNumberSeasons(numberSeasons).stream().map(
        Mapper::serieToSerieNumberSeasonDTO).collect(Collectors.toList());
  }

  public List<Serie> getSeries(){
    return serieRepository.findAll();
  }

}
