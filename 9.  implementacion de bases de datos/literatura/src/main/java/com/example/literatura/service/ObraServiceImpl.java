package com.example.literatura.service;

import com.example.literatura.entity.Obra;
import com.example.literatura.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraServiceImpl implements ObraService {
    @Autowired
    ObraRepository repository;
    @Override
    public Obra save(Obra obra) {
        repository.save(obra);
        return obra;
    }
}
