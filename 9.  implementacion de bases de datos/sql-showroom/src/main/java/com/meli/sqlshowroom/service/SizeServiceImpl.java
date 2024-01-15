package com.meli.sqlshowroom.service;

import com.meli.sqlshowroom.entity.Size;
import com.meli.sqlshowroom.repository.ISizeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SizeServiceImpl implements ISizeService {
    ISizeRepository repository;

    public SizeServiceImpl(ISizeRepository repository) { this.repository = repository; }

    @Override
    public Optional<Size> findById(Long id) {
        return repository.findById(id);
    }
}
