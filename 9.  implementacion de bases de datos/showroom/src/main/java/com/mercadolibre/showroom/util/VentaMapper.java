package com.mercadolibre.showroom.util;

import com.mercadolibre.showroom.dto.VentaCompleteDTO;
import com.mercadolibre.showroom.dto.VentaDTO;
import com.mercadolibre.showroom.model.Venta;

public class VentaMapper {

    public static Venta ventaCompleteDTOtoVenta(VentaCompleteDTO ventaDTO) {
        return new Venta(ventaDTO.getNumero(), ventaDTO.getFecha(), ventaDTO.getTotal(), ventaDTO.getMedio_pago(), ventaDTO.getPrendas().stream().map(PrendaMapper::prendaDTOtoPrenda).toList());
    }

    public static VentaCompleteDTO ventaToVentaCompleteDTO(Venta venta) {
        return new VentaCompleteDTO(venta.getNumero(), venta.getFecha(), venta.getTotal(), venta.getMedio_pago(), venta.getPrendas().stream().map(PrendaMapper::prendaToPrendaDTO).toList());
    }
}
