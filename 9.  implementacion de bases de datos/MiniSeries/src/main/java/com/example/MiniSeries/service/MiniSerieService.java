package com.example.MiniSeries.service;

import org.springframework.stereotype.Service;
import com.example.MiniSeries.repository.MiniSerieRepository;

@Service
public class MiniSerieService {

    private final MiniSerieRepository repository;

    public MiniSerieService(MiniSerieRepository repository) {
        this.repository = repository;
    }
}
