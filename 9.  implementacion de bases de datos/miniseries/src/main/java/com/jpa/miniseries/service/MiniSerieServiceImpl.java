package com.jpa.miniseries.service;

import com.jpa.miniseries.model.MiniSerie;
import com.jpa.miniseries.repository.IMiniserieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MiniSerieServiceImpl implements IMiniSerieService {
    private final IMiniserieRepository repository;

    public MiniSerieServiceImpl(IMiniserieRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<MiniSerie> getMiniSeries() {
        return repository.findAll();
    }

    @Override
    public void saveMiniSerie(MiniSerie miniSerie) {
        repository.save(miniSerie);
    }

    @Override
    public void deleteMiniSerie(Long id) {
        repository.deleteById(id);
    }

    @Override
    public MiniSerie findMiniSerie(Long id) {
        return repository.findById(id).orElse(null);
    }
}
