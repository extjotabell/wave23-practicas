package main;

import java.util.*;

public class Repositorio {
    private List<Localizador> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public void setLocalizadores(Localizador localizador) {

        // Logica que revisa los descuentos a realizar
        // Revisamos si ya tiene 2 localizadores
        Cliente clienteARevisar = localizador.getCliente();
        int cantidad = 0;

        for (Localizador l : this.localizadores) {
            if (l.getCliente() == clienteARevisar) {
                cantidad += 1;
            }
        }

        if (cantidad >= 2) {
            // Le aplico el 5% al total
            localizador.setDescuentos(localizador.getTotalReservasSinDesc() * 0.05);
        }

    }
}
