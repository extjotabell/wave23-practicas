package com.blog.blog.dto.response;

import com.blog.blog.dto.EntradaBlogDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodasLasEntradasDTO {
    List<EntradaBlogDTO> entradaBlogDTOList;
}
