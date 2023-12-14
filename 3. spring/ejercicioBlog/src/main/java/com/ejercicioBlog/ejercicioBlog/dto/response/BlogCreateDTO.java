package com.ejercicioBlog.ejercicioBlog.dto.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogCreateDTO {
    private Integer id;
}
