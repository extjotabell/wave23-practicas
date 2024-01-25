package com.bootcampmeli.deportistas.DTO;

import com.bootcampmeli.deportistas.Model.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DeportesDisponiblesReponseDTO {
    List<Deporte> deportes = new ArrayList<>();

}
