package com.example.youtuber.service;

import com.example.youtuber.dto.EntradaBlogDTO;

import java.util.List;

public interface IYoutuberService {
    void create(EntradaBlogDTO entradaBlogDTO);

    EntradaBlogDTO get(int id);

    List<EntradaBlogDTO> getAll();
}
