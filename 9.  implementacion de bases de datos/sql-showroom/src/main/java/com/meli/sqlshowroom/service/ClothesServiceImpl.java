package com.meli.sqlshowroom.service;

import com.meli.sqlshowroom.dto.ClothesDTO;
import com.meli.sqlshowroom.dto.ClothesListDTO;
import com.meli.sqlshowroom.entity.Clothes;
import com.meli.sqlshowroom.entity.Size;
import com.meli.sqlshowroom.exception.NotFoundException;
import com.meli.sqlshowroom.repository.IClothesRepository;
import com.meli.sqlshowroom.util.ClothesMapper;
import com.meli.sqlshowroom.util.Validations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Size> size = sizeService.findById(clothes.getSizeId());
        Validations.checkIfEmpty(size);

        repository.save(ClothesMapper.map(clothes, size.get()));
        return clothes;
    }

    @Override
    public ClothesListDTO findAll() {
        List<Clothes> clothes = repository.findAll();
        Validations.checkIfEmpty(clothes);

        return new ClothesListDTO(clothes.stream()
                .map(ClothesMapper::map)
                .toList()
        );
    }

    @Override
    public ClothesListDTO findByCode(String code) {
        List<Clothes> clothes = repository.findByCode(code);
        Validations.checkIfEmpty(clothes);

        return new ClothesListDTO(clothes.stream()
                .map(ClothesMapper::map)
                .toList()
        );
    }
}
