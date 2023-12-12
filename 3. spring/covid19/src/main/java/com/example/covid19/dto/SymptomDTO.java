package com.example.covid19.dto;

import com.example.covid19.enums.NAMESYMPTOM;
import com.example.covid19.enums.SEVERITY;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SymptomDTO {
    NAMESYMPTOM nameSymptom;
    SEVERITY severity;

    public SymptomDTO(NAMESYMPTOM nameSymptom) {
        this.nameSymptom = nameSymptom;
    }
}
