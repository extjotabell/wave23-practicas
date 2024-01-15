package com.example.showroom.repository;

import com.example.showroom.model.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClotheRepository extends JpaRepository<Clothe, Long> {
    List<Clothe> findClothesBySize(String size);

    List<Clothe> findClothesByNameContaining(String name);
}
