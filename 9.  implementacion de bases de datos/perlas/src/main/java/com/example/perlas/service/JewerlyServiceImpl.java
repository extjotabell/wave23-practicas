package com.example.perlas.service;

import com.example.perlas.model.Jewerly;
import com.example.perlas.repository.IJewerlyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewerlyServiceImpl implements IJewerlyService{

    private final IJewerlyRepository repository;

    public JewerlyServiceImpl(IJewerlyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Jewerly> getJewerly() {
        return repository.findAll();
    }

    @Override
    public Integer saveJewerly(Jewerly jewerly) {
        repository.save(jewerly);
        return jewerly.getNro_identificatorio();
    }

    @Override
    public void deleteJewerly(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Jewerly findJewerly(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
