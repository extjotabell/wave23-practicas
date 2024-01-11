package com.example.joyeria.repository;

import com.example.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoyeriaRepository extends JpaRepository<Joya,Long> {
    List<Joya> findAllByPoseeVentaTrue();
}
