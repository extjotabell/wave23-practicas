package com.example.showroom.repository;

import com.example.showroom.model.Clothes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClothesRepository extends JpaRepository<Clothes, String> {

  List<Clothes> findBySize(int size);

  List<Clothes> findByNameContaining(String name);
}
