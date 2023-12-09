package repositorios;

import modelo.CRUD;
import modelo.Localizador;

import java.util.List;

public class LocalizadorRepositorio extends CRUD<Localizador> {
    public List<Localizador> obtenerTodosPorIdCliente(String idCliente) {
        return modelos.stream()
                .filter(localizador -> localizador.getCliente().getId().equals(idCliente))
                .toList();
    }
}
