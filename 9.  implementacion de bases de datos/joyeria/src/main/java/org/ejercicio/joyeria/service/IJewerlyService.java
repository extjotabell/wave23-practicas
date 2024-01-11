package org.ejercicio.joyeria.service;


import org.ejercicio.joyeria.DTO.JewerlyDTO;
import org.ejercicio.joyeria.DTO.response.SimpleMessageDTO;

import java.util.List;

public interface IJewerlyService {
    List<JewerlyDTO> getJewels();

    SimpleMessageDTO saveJewerly(JewerlyDTO stu);

    List<JewerlyDTO> deleteJewerly(Long id);

    SimpleMessageDTO updateJewerly(Long id, JewerlyDTO jewerlyDTO);
}
