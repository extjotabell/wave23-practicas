package com.meli.bootcamp.obraliteraria.util;

import com.meli.bootcamp.obraliteraria.dto.ObraDto;
import com.meli.bootcamp.obraliteraria.entity.Obra;

public class Mapper {
    public static ObraDto mapToObraDto(Obra obra){
        if(obra == null) return null;
        return new ObraDto(obra.getId(), obra.getNombre(), obra.getAutor(), obra.getCantidadPaginas(), obra.getEditorial(), obra.getFechaPublicacion());
    }
    public static Obra mapToObra(ObraDto obraDto){
        if(obraDto == null) return null;
        return new Obra(obraDto.getId(), obraDto.getNombre(), obraDto.getAutor(), obraDto.getCantidadPaginas(), obraDto.getEditorial(), obraDto.getFechaPublicacion());
    }
}
