package com.ejercicioBlog.ejercicioBlog.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogsResponseDTO {
    private List<BlogResponseDTO> blogs;
}
