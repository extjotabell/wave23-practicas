package org.example.localizadores;

import org.example.clientes.Cliente;

import java.util.HashMap;
import java.util.Map;

public class RepositorioLocalizador {
    private final Map<Integer, Localizador> localizadores;

    public RepositorioLocalizador() {
        this.localizadores = new HashMap<>();
    }

    public Map<Integer, Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.put(localizador.getId(), localizador);
    }

    public Localizador buscarLocalizador(Integer id) {
        return localizadores.get(id);
    }
}
