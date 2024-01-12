package meli.bootcamp.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import meli.bootcamp.jpa.model.MiniSerie;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {

}
