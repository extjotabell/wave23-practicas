package com.melibootcamp.blog.dto.response;

import com.melibootcamp.blog.dto.EntradaBlogDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TodasLasEntradasResponseDTO {
    List<EntradaBlogDTO> entradas;
}
