package org.example.modelo;

import org.example.repositorios.ClienteRepositorio;
import org.example.repositorios.LocalizadorRepositorio;
import org.example.repositorios.ReservaRepositorio;

public class Agencia {

    private LocalizadorRepositorio localizador;

    public Agencia() {
        this.localizador = new LocalizadorRepositorio();
    }

    public LocalizadorRepositorio getLocalizador() {
        return localizador;
    }

    public void setLocalizador(LocalizadorRepositorio localizador) {
        this.localizador = localizador;
    }
}
