package com.example.miniserie.repository;

import com.example.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMiniserieRepository extends JpaRepository <MiniSerie, Long> {
}
