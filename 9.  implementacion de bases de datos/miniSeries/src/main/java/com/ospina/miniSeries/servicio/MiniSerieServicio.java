package com.ospina.miniSeries.servicio;

import com.ospina.miniSeries.repositorio.MiniSerieRepositorio;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieServicio {
    private final MiniSerieRepositorio miniSerieRepositorio;

    public MiniSerieServicio(MiniSerieRepositorio miniSerieRepositorio) {
        this.miniSerieRepositorio = miniSerieRepositorio;
    }
}
