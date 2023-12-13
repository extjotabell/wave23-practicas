package com.example.youtuber.repository;

import com.example.youtuber.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IYoutuberRepository {
    void create(EntradaBlog entradaBlog);
    Optional<EntradaBlog> get(int id);

    List<EntradaBlog> getAll();
}
