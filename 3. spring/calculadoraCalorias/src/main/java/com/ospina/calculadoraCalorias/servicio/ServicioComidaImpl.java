package com.ospina.calculadoraCalorias.servicio;

import com.ospina.calculadoraCalorias.excepcion.PlatoNoEncontradoExcepcion;
import com.ospina.calculadoraCalorias.modelo.dto.PlatoDTO;
import com.ospina.calculadoraCalorias.modelo.entidad.Ingrediente;
import com.ospina.calculadoraCalorias.modelo.entidad.Plato;
import com.ospina.calculadoraCalorias.modelo.request.RequestPlato;
import com.ospina.calculadoraCalorias.repositorio.plato.RepositorioPlato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class ServicioComidaImpl implements ServicioComida {

    private final RepositorioPlato repositorioPlato;

    public ServicioComidaImpl(RepositorioPlato repositorioPlato) {
        this.repositorioPlato = repositorioPlato;
    }

    @Override
    public PlatoDTO obtenerDatos(RequestPlato requestPlato) throws PlatoNoEncontradoExcepcion {
        try{
            Plato platoEncontrado = repositorioPlato.obtenerPorNombre(requestPlato.getNombre());
            if (platoEncontrado == null) {
                throw new PlatoNoEncontradoExcepcion();
            }
            platoEncontrado = multiplicarPorGramos(platoEncontrado, requestPlato.getGramos());
            PlatoDTO platoDTO = new PlatoDTO();
            platoDTO.setNombre(platoEncontrado.getNombre());
            platoDTO.setTotalCalorias(platoEncontrado.getTotalCalorias());
            platoDTO.setIngredientes(platoEncontrado.getIngredientes());
            platoDTO.setIngredienteMasCalorico(ingredienteMasCalorico(platoEncontrado));
            return platoDTO;
        } catch (Exception e) {
            System.err.println("Error encontrando plato: " + e.getMessage());
            throw new PlatoNoEncontradoExcepcion();
        }
    }

    public Ingrediente ingredienteMasCalorico(Plato plato) {
        Ingrediente ingredienteMasCalorico = null;
        for (Ingrediente ingrediente : plato.getIngredientes()) {
            if (ingredienteMasCalorico == null) {
                ingredienteMasCalorico = ingrediente;
            } else if (ingrediente.getCalorias() > ingredienteMasCalorico.getCalorias()) {
                ingredienteMasCalorico = ingrediente;
            }
        }
        return ingredienteMasCalorico;
    }

    public Plato multiplicarPorGramos(Plato plato, int gramos) {
        Plato platoMultiplicado = new Plato();
        platoMultiplicado.setNombre(plato.getNombre());
        //Recorrer lista de ingredientes y multiplicar sus calorias por gramos/1000
        platoMultiplicado.setIngredientes((ArrayList<Ingrediente>) plato.getIngredientes().stream().map(ingrediente -> {
            Ingrediente ingredienteMultiplicado = new Ingrediente();
            ingredienteMultiplicado.setNombre(ingrediente.getNombre());
            ingredienteMultiplicado.setCalorias(ingrediente.getCalorias() * gramos / 1000);
            return ingredienteMultiplicado;
        }).collect(Collectors.toList()));
        platoMultiplicado.setTotalCalorias(plato.getTotalCalorias() * gramos / 1000);
        return platoMultiplicado;
    }
}
