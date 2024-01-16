package org.ejercicio.showroom.service;

import org.ejercicio.showroom.model.dto.ClothesDto;
import org.ejercicio.showroom.model.entty.Clothes;
import org.ejercicio.showroom.repository.IClothesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ClothesServiceImpl implements IClothesService {

    private final IClothesRepository repository;

    private final ModelMapper modelMapper = new ModelMapper();

    public ClothesServiceImpl(IClothesRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClothesDto saveClothes(ClothesDto clothesDto) {
        Clothes clothes = repository.save(modelMapper.map(clothesDto, Clothes.class));
        return modelMapper.map(clothes, ClothesDto.class);
    }

    @Override
    public List<ClothesDto> getClothes() {
        Iterable<Clothes> iterable = repository.findAll();
        return getClothesDtos(StreamSupport
                .stream(iterable.spliterator(), false));
    }

    @Override
    public ClothesDto getClothesCode(String code) {
        Clothes clothes = repository.findByCode(code);
        return modelMapper.map(clothes, ClothesDto.class);
    }

    @Override
    public ClothesDto editClothes(ClothesDto clothesDto, String code) {
        Clothes clothes = repository.findByCode(code);
        clothes.setCode(clothesDto.getCode());
        clothes.setName(clothesDto.getName());
        clothes.setType(clothesDto.getType());
        clothes.setBrand(clothesDto.getBrand());
        clothes.setColor(clothesDto.getColor());
        clothes.setSize(clothesDto.getSize());
        clothes.setCount(clothesDto.getCount());
        clothes.setPrice(clothesDto.getPrice());
        repository.save(clothes);
        return modelMapper.map(clothes, ClothesDto.class);
    }

    @Override
    public void deleteClothes(String code) {
        Clothes clothes = repository.findByCode(code);
        repository.delete(clothes);
    }

    @Override
    public List<ClothesDto> getClothesSize(Integer size) {
        List<Clothes> clothes = repository.findBySize(size);
        return getClothesDtos(clothes
                .stream());
    }

    private List<ClothesDto> getClothesDtos(Stream<Clothes> clothes) {
        return clothes
                .map(cloth -> modelMapper.map(cloth, ClothesDto.class))
                .toList();
    }

    @Override
    public List<ClothesDto> getClothesName(String name) {
        List<Clothes> clothes = repository.findByName(name);
        return getClothesDtos(clothes
                .stream());
    }
}
