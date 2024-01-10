package com.ospina.joyeria.servicio;

import com.ospina.joyeria.modelo.entidad.Joya;
import com.ospina.joyeria.modelo.request.JoyaCompletaRequestDTO;
import com.ospina.joyeria.modelo.request.JoyaRequestDTO;

import java.util.List;

public interface JoyaServicio {

    List<Joya> obtenerJoyas();
    Long guardarJoya(JoyaRequestDTO joya);
    void borrarJoya(Long id);
    Joya actualizarJoya(Long id, JoyaCompletaRequestDTO joyaCompletaRequestDTO);
}
