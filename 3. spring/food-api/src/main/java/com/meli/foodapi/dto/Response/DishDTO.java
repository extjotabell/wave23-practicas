package com.meli.foodapi.dto.Response;

import com.meli.foodapi.dto.Request.DishEntryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private String name;
    private int weight;
    private List<IngredientDTO> ingredients;
    private IngredientDTO hightIngredient;

}
