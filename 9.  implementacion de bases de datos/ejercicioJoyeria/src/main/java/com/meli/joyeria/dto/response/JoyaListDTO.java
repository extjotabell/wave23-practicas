package com.meli.joyeria.dto.response;

import com.meli.joyeria.model.Joya;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class JoyaListDTO {
    private List<Joya> jewerly;

}
