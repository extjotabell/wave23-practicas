package com.meli.sqlshowroom.service;

import com.meli.sqlshowroom.dto.ClothesDTO;
import com.meli.sqlshowroom.dto.ClothesListDTO;
import com.meli.sqlshowroom.dto.MessageDTO;
import com.meli.sqlshowroom.entity.Clothes;
import com.meli.sqlshowroom.entity.Size;
import com.meli.sqlshowroom.exception.NotFoundException;
import com.meli.sqlshowroom.repository.IClothesRepository;
import com.meli.sqlshowroom.util.ClothesMapper;
import com.meli.sqlshowroom.util.Validations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements IClothesService {

    private final IClothesRepository repository;
    private final ISizeService sizeService;

    public ClothesServiceImpl(IClothesRepository repository, SizeServiceImpl sizeService) {
        this.repository = repository;
        this.sizeService = sizeService;
    }

    @Override
    public ClothesDTO save(ClothesDTO clothes) {
        Size size = sizeService.findById(clothes.getSizeId());

        repository.save(ClothesMapper.map(clothes, size));
        return clothes;
    }

    @Override
    public ClothesListDTO findAll() {
        List<Clothes> clothes = repository.findAll();
        Validations.checkIfEmptyList(clothes);

        return new ClothesListDTO(clothes.stream()
                .map(ClothesMapper::map)
                .toList()
        );
    }

    @Override
    public ClothesDTO findByCode(Long code) {
        Clothes clothes = repository.findById(code)
                .orElseThrow(() -> new NotFoundException("No se encontraron resultados para la prenda con code: " + code));

        return ClothesMapper.map(clothes);
    }

    @Override
    public MessageDTO update(Long code, ClothesDTO clothes) {
        if (!repository.existsById(code)) {
            throw new NotFoundException("No se encontraron resultados para la prenda con code: " + code);
        }

        Size size = sizeService.findById(clothes.getSizeId());

        repository.save(ClothesMapper.map(clothes, size));
        return new MessageDTO("Se actualizó correctamente la prenda con code: " + code);
    }

    @Override
    public MessageDTO delete(Long code) {
        Clothes clothes = repository.findById(code)
                .orElseThrow(() -> new NotFoundException("No se encontraron resultados para la prenda con code: " + code));

        repository.delete(clothes);
        return new MessageDTO("Se eliminó correctamente la prenda con code: " + code);
    }

    @Override
    public ClothesListDTO findBySize(String size) {
        List<Clothes> clothes = repository.findBySize(size);
        Validations.checkIfEmptyList(clothes);

        return new ClothesListDTO(clothes.stream()
                .map(ClothesMapper::map)
                .toList()
        );
    }

    @Override
    public ClothesListDTO findByName(String name) {
        List<Clothes> clothes = repository.findByName(name);
        Validations.checkIfEmptyList(clothes);

        return new ClothesListDTO(clothes.stream()
                .map(ClothesMapper::map)
                .toList()
        );
    }
}
