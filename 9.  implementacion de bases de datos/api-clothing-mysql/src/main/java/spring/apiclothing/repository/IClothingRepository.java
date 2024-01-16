package spring.apiclothing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.apiclothing.model.Prenda;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClothingRepository extends JpaRepository<Prenda, Long> {

    void deleteByCodigo(Long id);

    List<Prenda> findByTalle(Integer talle);

    List<Prenda> findByNombreContaining(String parametro);

    Optional<Prenda> findByCodigo(Long prenda);
}

