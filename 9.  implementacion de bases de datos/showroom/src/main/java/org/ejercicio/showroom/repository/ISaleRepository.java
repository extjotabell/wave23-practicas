package org.ejercicio.showroom.repository;

import org.ejercicio.showroom.model.entty.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {

}
