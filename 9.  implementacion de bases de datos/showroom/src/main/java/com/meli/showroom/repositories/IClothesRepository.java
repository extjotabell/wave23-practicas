package com.meli.showroom.repositories;

import com.meli.showroom.entities.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClothesRepository extends JpaRepository<Clothes, Long>{
    Clothes findByCode(String code);
}