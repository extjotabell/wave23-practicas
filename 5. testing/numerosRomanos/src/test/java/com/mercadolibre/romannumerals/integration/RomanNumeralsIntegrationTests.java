package com.mercadolibre.romannumerals.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static com.mercadolibre.romannumerals.utils.RomanNumeralTestCases.testCases;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsIntegrationTests {

  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("All test cases return the correct roman numeral")
  void testCasesOk() throws Exception {
    for (Map.Entry<Integer, String> testCase : testCases.entrySet()) {
      performTest(testCase.getKey().toString(), testCase.getValue());
    }
  }

  private void performTest(String decimal, String roman) throws Exception {
    this.mockMvc.perform(get("/" + decimal))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string(containsString(roman)));
  }
}
