package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Data
@Generated
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleMessageDTO {
    private String description;
    private List<String> messages;

    public SimpleMessageDTO(String description) {
        this.description = description;
    }
}
