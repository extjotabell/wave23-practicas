package com.meli.showroom.repositories;

import com.meli.showroom.entities.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClothesRepository extends JpaRepository<Clothes, Long>{
    Optional<Clothes> findByCode(String code);
}