package com.jpa_crud.jewerly.dto.response;

import com.jpa_crud.jewerly.model.Joya;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaJoya {
    private List<Joya> joyas;
}
