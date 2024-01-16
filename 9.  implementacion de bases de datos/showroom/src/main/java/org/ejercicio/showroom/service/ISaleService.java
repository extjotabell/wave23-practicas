package org.ejercicio.showroom.service;

import org.ejercicio.showroom.model.dto.SaleDto;

import java.util.List;

public interface ISaleService {
    SaleDto saveSale(SaleDto saleDto);

    List<SaleDto> getSales();
}
