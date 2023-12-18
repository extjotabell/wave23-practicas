package com.meli.ejercicioBlog.repository;

import com.meli.ejercicioBlog.model.EntradaBlog;

import java.util.List;

public interface IEntradaRepository {
    String create(EntradaBlog entrada);
    EntradaBlog find(String id);
    List<EntradaBlog> getAll();
}
