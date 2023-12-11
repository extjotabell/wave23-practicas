package meli.demoW23Dto.service;

import meli.demoW23Dto.dto.request.PersonaDto;
import meli.demoW23Dto.dto.response.ResponseSaveDto;

import java.util.List;

public interface IPersonaService {
    List<PersonaDto> findCharacter(String Variable) throws Exception;
}
