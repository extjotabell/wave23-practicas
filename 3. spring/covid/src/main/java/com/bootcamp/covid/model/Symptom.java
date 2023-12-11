package com.bootcamp.covid.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Symptom {
    private int code;
    private String name;
    private String severityLevel;
}
