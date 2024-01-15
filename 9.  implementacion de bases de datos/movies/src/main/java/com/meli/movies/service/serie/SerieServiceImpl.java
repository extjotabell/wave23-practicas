package com.meli.movies.service.serie;

import com.meli.movies.dto.EpisodeDTO;
import com.meli.movies.dto.EpisodesDTO;
import com.meli.movies.dto.SerieDTO;
import com.meli.movies.dto.SeriesDTO;
import com.meli.movies.repository.ISerieRepository;
import com.meli.movies.util.EpisodeMapper;
import com.meli.movies.util.SerieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService {

    ISerieRepository repository;

    public SerieServiceImpl(ISerieRepository repository) { this.repository = repository; }

    @Override
    public SeriesDTO findBySeasonGreaterThan(Integer seasons) {
        List<SerieDTO> series = repository.findBySeasonGreaterThan(seasons).stream()
                .map(SerieMapper::map)
                .toList();

        return new SeriesDTO(series);
    }

    @Override
    public EpisodesDTO findEpisodesByActor(String actor) {
        List<EpisodeDTO> episodes = repository.findEpisodesByActor(actor).stream()
                .map(EpisodeMapper::map)
                .toList();

        return new EpisodesDTO(episodes);
    }
}
