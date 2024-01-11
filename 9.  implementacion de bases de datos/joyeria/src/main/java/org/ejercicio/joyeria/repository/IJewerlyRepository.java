package org.ejercicio.joyeria.repository;

import org.ejercicio.joyeria.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewerly, Long> {
}
