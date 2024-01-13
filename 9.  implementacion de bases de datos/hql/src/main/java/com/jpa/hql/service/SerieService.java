package com.jpa.hql.service;

import com.jpa.hql.model.dto.SerieDTO;
import com.jpa.hql.repository.ISerieRepository;
import com.jpa.hql.utils.IMappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService{
    @Autowired
    private ISerieRepository serieRepository;
    @Autowired
    private IMappingUtility mappingUtility;
    @Override
    public Set<SerieDTO> getSeriesWithNumberOfSeasonsGreaterThan(Integer numberSeasons) {
        return serieRepository.findByNumberOfSeasonsGreaterThan(numberSeasons).stream()
                .map(sE -> mappingUtility.serieEntityToDTO(sE))
                .collect(Collectors.toSet());
    }
}
