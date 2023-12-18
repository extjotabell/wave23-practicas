package com.spring.calculadoracalorias.service;

import com.spring.calculadoracalorias.dto.IngredienteDTO;
import com.spring.calculadoracalorias.dto.PlatoDto;
import com.spring.calculadoracalorias.entity.Ingrediente;
import com.spring.calculadoracalorias.entity.Plato;
import com.spring.calculadoracalorias.repository.PlatoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {

    @Autowired
    private PlatoRepositoryImpl platoRepository;
    @Override
    public PlatoDto informeCalorico( String nombre) {
        Plato plato = platoRepository.getPlatos(nombre);
        Integer totalCalorias = 0;
        Ingrediente maximo = null;
        Integer max = 0;
        for (Map.Entry<Ingrediente, Integer> entry : plato.getIngredientes().entrySet())
        {
            Integer calorias = entry.getKey().getCalorias();
            if (max < calorias) {
                maximo = entry.getKey();
                max = calorias;
            }
            totalCalorias += calorias * (entry.getValue() / 100);
        }
        return new PlatoDto(totalCalorias, plato.getIngredientes().entrySet().stream()
                .map(e -> new IngredienteDTO(e.getKey().getNombre(), e.getKey().getCalorias(), e.getValue())).toList()
                ,maximo.getNombre());
    }
}
