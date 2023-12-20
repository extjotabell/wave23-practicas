package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductComparisonDTO {
    @JsonProperty("product_id")
    private int id;
    @JsonProperty("product_name")
    private String name;
    List<ComparisonDTO> comparisons;
}
