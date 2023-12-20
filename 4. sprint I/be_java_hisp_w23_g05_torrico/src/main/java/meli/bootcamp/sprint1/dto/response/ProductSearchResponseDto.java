package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchResponseDto {
    private int id;
    private String name;
    private String type;
    private String brand;
    private String notes;
    private String color;
    private String category;
}
