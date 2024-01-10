package com.ospina.miniSeries.repositorio;

import com.ospina.miniSeries.entidad.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiniSerieRepositorio extends JpaRepository<MiniSerie, Long> {
    /*List<MiniSerie> buscarPorNombre(String nombre);
    List<MiniSerie> buscarPorRating(Double rating);
    List<MiniSerie> buscarPorCantidadDePremios(Integer cantidadDePremios);
    List<MiniSerie> buscarPorNombreYRating(String nombre, Double rating);
    List<MiniSerie> buscarPorNombreYCantidadDePremios(String nombre, Integer cantidadDePremios);
    List<MiniSerie> buscarPorRatingYCantidadDePremios(Double rating, Integer cantidadDePremios);
    List<MiniSerie> buscarPorNombreRatingYCantidadDePremios(String nombre, Double rating, Integer cantidadDePremios); */
}
