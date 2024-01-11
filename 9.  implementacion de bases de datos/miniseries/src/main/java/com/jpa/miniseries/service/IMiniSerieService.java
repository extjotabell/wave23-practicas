package com.jpa.miniseries.service;

import com.jpa.miniseries.model.MiniSerie;

import java.util.List;

public interface IMiniSerieService {

    List<MiniSerie> getMiniSeries();

    void saveMiniSerie(MiniSerie miniSerie);

    void deleteMiniSerie(Long id);

    MiniSerie findMiniSerie(Long id);
}
