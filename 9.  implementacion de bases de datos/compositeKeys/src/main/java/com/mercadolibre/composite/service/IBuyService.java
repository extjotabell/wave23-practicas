package com.mercadolibre.composite.service;

import com.mercadolibre.composite.entities.Buy;
import org.apache.coyote.BadRequestException;

public interface IBuyService {

    void saveBuy(Buy buy);
}
