package com.meli.elasticsearchobras.service;

import com.meli.elasticsearchobras.domain.DTO.ObraDTO;
import com.meli.elasticsearchobras.domain.DTO.ObrasDTO;

public interface IObraService {
    ObraDTO save(ObraDTO obra);
    ObrasDTO findAll();
    ObrasDTO findByAutor(String autor);
    ObrasDTO findByNombre(String nombre);
}
