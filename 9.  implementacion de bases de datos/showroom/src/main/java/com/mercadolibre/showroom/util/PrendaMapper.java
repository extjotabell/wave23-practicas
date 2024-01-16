package com.mercadolibre.showroom.util;

import com.mercadolibre.showroom.dto.PrendaDTO;
import com.mercadolibre.showroom.model.Prenda;

public class PrendaMapper {
    public static Prenda prendaDTOtoPrenda(PrendaDTO prendaDTO) {
        return new Prenda(prendaDTO.getCodigo(), prendaDTO.getNombre(), prendaDTO.getTipo(), prendaDTO.getMarca(), prendaDTO.getColor(), prendaDTO.getTalle(), prendaDTO.getCantidad(), prendaDTO.getPrecio_venta(), null);
    }

    public static PrendaDTO prendaToPrendaDTO(Prenda prenda) {
        return new PrendaDTO(prenda.getCodigo(), prenda.getNombre(), prenda.getTipo(), prenda.getMarca(), prenda.getColor(), prenda.getTalle(), prenda.getCantidad(), prenda.getPrecio_venta());
    }

}
