package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.response.MessageDTO;
import com.mercadolibre.showroom.dto.PrendaDTO;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.model.Prenda;
import com.mercadolibre.showroom.repository.IPrendaRepository;
import com.mercadolibre.showroom.util.PrendaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrendaService implements IPrendaService {

    private final IPrendaRepository prendaRepository;
    public PrendaService(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public PrendaDTO addPrenda(PrendaDTO prendaDTO) {
        prendaRepository.save(PrendaMapper.prendaDTOtoPrenda(prendaDTO));
        return prendaDTO;
    }

    @Override
    public List<PrendaDTO> getAll() {
        return prendaRepository.findAll().stream()
                .map(PrendaMapper::prendaToPrendaDTO)
                .toList();
    }

    @Override
    public PrendaDTO getByCode(Integer code) {
        Optional<Prenda> prendaOptional = Optional.ofNullable(prendaRepository.getByCode(code));
        if (prendaOptional.isEmpty()) {
            throw new NotFoundException("No se encontró la prenda con código " + code);
        }

        return PrendaMapper.prendaToPrendaDTO(prendaOptional.get());
    }

    @Override
    public PrendaDTO updateByCode(Integer code, PrendaDTO prendaDTO) {
        PrendaDTO prendaFound = getByCode(code);
        prendaFound.setNombre(prendaDTO.getNombre());
        prendaFound.setTipo(prendaDTO.getTipo());
        prendaFound.setMarca(prendaDTO.getMarca());
        prendaFound.setColor(prendaDTO.getColor());
        prendaFound.setTalle(prendaDTO.getTalle());
        prendaFound.setCantidad(prendaDTO.getCantidad());
        prendaFound.setPrecio_venta(prendaDTO.getPrecio_venta());

        prendaRepository.save(PrendaMapper.prendaDTOtoPrenda(prendaFound));

        return prendaFound;
    }

    @Override
    public MessageDTO deleteByCode(Integer code) {
        PrendaDTO prendaFound = getByCode(code);
        prendaRepository.delete(PrendaMapper.prendaDTOtoPrenda(prendaFound));
        return new MessageDTO("La prenda con código " + code + " fue eliminada correctamente");
    }

    @Override
    public List<PrendaDTO> getBySize(Integer size) {
        return prendaRepository.getBySize(size).stream()
                .map(PrendaMapper::prendaToPrendaDTO)
                .toList();
    }

    @Override
    public List<PrendaDTO> getByName(String name) {
        return prendaRepository.getByName(name).stream()
                .map(PrendaMapper::prendaToPrendaDTO)
                .toList();
    }

}
