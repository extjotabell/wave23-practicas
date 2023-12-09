package modelo;

import repositorios.LocalizadorRepositorio;

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