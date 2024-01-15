package com.meli.sqlshowroom.repository;

import com.meli.sqlshowroom.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClothesRepository extends JpaRepository<Clothes, Long> {
}
