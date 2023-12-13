package com.ospina.linkTracker.servicio;

import java.util.Map;

public interface ServicioLink {

        int crearLink(String url, String password);

        String redireccionarLink(int id, String password);

        Map<String, Integer> obtenerEstadisticas(int id);

        void invalidarLink(int id);
}
