package com.jpa_crud.jewerly.service;

import com.jpa_crud.jewerly.dto.response.ListaJoya;
import com.jpa_crud.jewerly.dto.response.NoIdentificatorioJoya;
import com.jpa_crud.jewerly.model.Joya;

public interface IJoyaService {
    NoIdentificatorioJoya createJewel(Joya joya);
    ListaJoya getAllJewelLogical();
    String deleteJewelLogical(Long id);
    Joya updateJewel(Long id, Joya joya);
}
