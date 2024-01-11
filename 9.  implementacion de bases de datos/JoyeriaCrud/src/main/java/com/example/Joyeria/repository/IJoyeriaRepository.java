package com.example.Joyeria.repository;

import com.example.Joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJoyeriaRepository extends JpaRepository<Joya, Long> {
    List<Joya> findByVentaONo(boolean vendido);
}
