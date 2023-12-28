package meli.bootcamp.sprint1.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void calculateWorking() throws Exception {

    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 7);
    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // Body Part
    ResultMatcher bodyPart = MockMvcResultMatchers.jsonPath("$.followers_count").value(1);

    mockMvc.perform(request) // request
        .andExpect(status) // expected status
        .andExpect(contentType) // expected contentType
        .andExpect(bodyPart) // expected body
        .andDo(MockMvcResultHandlers.print()); // print req and resp
  }
}