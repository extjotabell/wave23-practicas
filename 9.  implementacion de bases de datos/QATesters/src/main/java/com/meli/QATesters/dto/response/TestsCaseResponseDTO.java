package com.meli.QATesters.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TestsCaseResponseDTO {

    @JsonProperty("test_case_list")
    List<TestCaseResponseDTO> testCaseResponseDTOList;

}
