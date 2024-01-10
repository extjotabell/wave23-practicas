package com.ospina.joyeria.repositorio;

import com.ospina.joyeria.modelo.entidad.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JoyaRepositorio extends JpaRepository<Joya, Long> {

}
