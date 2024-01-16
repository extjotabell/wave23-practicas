package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.PrendaCodDTO;
import com.mercadolibre.showroom.dto.PrendaDTO;
import com.mercadolibre.showroom.dto.VentaCompleteDTO;
import com.mercadolibre.showroom.dto.VentaDTO;
import com.mercadolibre.showroom.dto.response.MessageDTO;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.model.Prenda;
import com.mercadolibre.showroom.model.Venta;
import com.mercadolibre.showroom.repository.IVentaRepository;
import com.mercadolibre.showroom.util.PrendaMapper;
import com.mercadolibre.showroom.util.VentaMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {

    private final IVentaRepository ventaRepository;
    public VentaService(IVentaRepository ventaReposository) {
        this.ventaRepository = ventaReposository;
    }

    @Override
    public VentaDTO addSale(VentaDTO ventaDTO) {
        List<Prenda> clothes = findClothes(ventaDTO.getPrendas());
        VentaCompleteDTO ventaCompleteDTO = new VentaCompleteDTO();
        ventaCompleteDTO.setNumero(ventaDTO.getNumero());
        ventaCompleteDTO.setFecha(ventaDTO.getFecha());
        ventaCompleteDTO.setTotal(ventaDTO.getTotal());
        ventaCompleteDTO.setMedio_pago(ventaDTO.getMedio_pago());
        ventaCompleteDTO.setPrendas(clothes.stream().map(PrendaMapper::prendaToPrendaDTO).toList());
        Integer cod = ventaRepository.save(VentaMapper.ventaCompleteDTOtoVenta(ventaCompleteDTO)).getNumero();
        ventaDTO.setNumero(cod);
        return ventaDTO;
    }

    private List<Prenda> findClothes(List<PrendaCodDTO> prendas) {
        return prendas.stream()
                .map(p -> ventaRepository.getInfoClothe(p.getCodigo()))
                .toList();
    }

    @Override
    public List<VentaCompleteDTO> getSales() {
        return ventaRepository.findAll().stream()
                .map(VentaMapper::ventaToVentaCompleteDTO)
                .toList();
    }

    @Override
    public VentaCompleteDTO getSaleByNumber(Integer number) {
        Optional<Venta> ventaOptional = Optional.ofNullable(ventaRepository.getBySaleNumber(number));
        if (ventaOptional.isEmpty()) {
            throw new NotFoundException("No se encontró la venta con código " + number);
        }

        return VentaMapper.ventaToVentaCompleteDTO(ventaOptional.get());
    }

    @Override
    public VentaCompleteDTO updateSaleByNumber(Integer number, VentaDTO ventaDTO) {
        VentaCompleteDTO ventaCompleteDTO = VentaMapper.ventaToVentaCompleteDTO(ventaRepository.getBySaleNumber(number));
        ventaCompleteDTO.setFecha(ventaDTO.getFecha());
        ventaCompleteDTO.setTotal(ventaDTO.getTotal());
        ventaCompleteDTO.setMedio_pago(ventaDTO.getMedio_pago());
        ventaCompleteDTO.setPrendas(findClothes(ventaDTO.getPrendas()).stream().map(PrendaMapper::prendaToPrendaDTO).toList());

        ventaRepository.save(VentaMapper.ventaCompleteDTOtoVenta(ventaCompleteDTO));

        return ventaCompleteDTO;
    }

    @Override
    public MessageDTO deleteSaleByNumber(Integer number) {
        VentaCompleteDTO ventaFound = getSaleByNumber(number);
        ventaRepository.delete(VentaMapper.ventaCompleteDTOtoVenta(ventaFound));
        return new MessageDTO("La venta con código " + number + " fue eliminada correctamente");
    }

    @Override
    public List<VentaCompleteDTO> getSalesByDate(LocalDate date) {
        return ventaRepository.getSalesByDate(date).stream()
                .map(VentaMapper::ventaToVentaCompleteDTO)
                .toList();
    }

    @Override
    public List<PrendaDTO> getClothesOfSale(Integer number) {
        return getSaleByNumber(number).getPrendas();
    }
}
