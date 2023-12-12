package com.example.covid19.entities;

import com.example.covid19.enums.NAMESYMPTOM;
import com.example.covid19.enums.SEVERITY;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Symptom {
    private int code;
    NAMESYMPTOM nameSymptom;
    SEVERITY severity;
}
