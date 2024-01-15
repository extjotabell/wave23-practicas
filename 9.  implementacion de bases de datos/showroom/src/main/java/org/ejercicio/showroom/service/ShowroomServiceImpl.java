package org.ejercicio.showroom.service;

import org.ejercicio.showroom.model.dto.ClothesDto;
import org.ejercicio.showroom.model.entty.Clothes;
import org.ejercicio.showroom.repository.IClothesRepository;
import org.ejercicio.showroom.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ShowroomServiceImpl implements IShowroomService {

    private final IClothesRepository clothesRepository;
    private final ISaleRepository saleRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public ShowroomServiceImpl(IClothesRepository clothesRepository, ISaleRepository saleRepository) {
        this.clothesRepository = clothesRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public ClothesDto saveClothes(ClothesDto clothesDto) {
        Clothes clothes = clothesRepository.save(modelMapper.map(clothesDto, Clothes.class));
        return modelMapper.map(clothes, ClothesDto.class);
    }

    @Override
    public List<ClothesDto> getClothes() {
        Iterable<Clothes> iterable = clothesRepository.findAll();
        return getClothesDtos(StreamSupport
                .stream(iterable.spliterator(), false));
    }

    @Override
    public ClothesDto getClothesCode(String code) {
        Clothes clothes = clothesRepository.findByCode(code);
        return modelMapper.map(clothes, ClothesDto.class);
    }

    @Override
    public ClothesDto editClothes(ClothesDto clothesDto, String code) {
        Clothes clothes = clothesRepository.findByCode(code);
        clothes.setCode(clothesDto.getCode());
        clothes.setName(clothesDto.getName());
        clothes.setType(clothesDto.getType());
        clothes.setBrand(clothesDto.getBrand());
        clothes.setColor(clothesDto.getColor());
        clothes.setSize(clothesDto.getSize());
        clothes.setCount(clothesDto.getCount());
        clothes.setPrice(clothesDto.getPrice());
        clothesRepository.save(clothes);
        return modelMapper.map(clothes, ClothesDto.class);
    }

    @Override
    public void deleteClothes(String code) {
        Clothes clothes = clothesRepository.findByCode(code);
        clothesRepository.delete(clothes);
    }

    @Override
    public List<ClothesDto> getClothesSize(Integer size) {
        List<Clothes> clothes = clothesRepository.findBySize(size);
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
        List<Clothes> clothes = clothesRepository.findByName(name);
        return getClothesDtos(clothes
                .stream());
    }
}
