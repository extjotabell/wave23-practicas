package com.meli.sqlshowroom.service;

import com.meli.sqlshowroom.entity.Size;

import java.util.Optional;

public interface ISizeService {
    Optional<Size> findById(Long id);
}
