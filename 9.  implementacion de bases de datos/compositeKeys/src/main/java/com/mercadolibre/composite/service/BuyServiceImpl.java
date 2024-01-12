package com.mercadolibre.composite.service;

import com.mercadolibre.composite.entities.Buy;
import com.mercadolibre.composite.exception.BadRequestException;
import com.mercadolibre.composite.repository.IBuyRepository;

import org.springframework.stereotype.Service;

@Service
public class BuyServiceImpl implements IBuyService{

    private final IBuyRepository buyRepository;

    public BuyServiceImpl(IBuyRepository buyRepository){
        this.buyRepository = buyRepository;
    }

    @Override
    public void saveBuy(Buy buy) {
        if (buy.getClientId() == null || buy.getDate() == null) {
           throw new BadRequestException();
        }
        buyRepository.save(buy);
    }
}
