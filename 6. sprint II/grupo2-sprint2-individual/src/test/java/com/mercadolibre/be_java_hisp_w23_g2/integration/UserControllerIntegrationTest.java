package com.mercadolibre.be_java_hisp_w23_g2.integration;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersDTO;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class UserControllerIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  @DirtiesContext
  void unfollowUser() throws Exception {
    mockMvc.perform(post("/users/{userId}/unfollow/{userToUnfollow}", 1, 4)).andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void getFollowersSeller() throws Exception {
    UserFollowersDTO expectedDTO = new UserFollowersDTO(1, "John Doe",
        List.of(new UserBasicDTO(2, "Alice Smith"), new UserBasicDTO(3, "Bob Jones")));

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        .writer();
    String responseJson = writer.writeValueAsString(expectedDTO);

    MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list", 1)).andDo(print())
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andReturn();

    assertEquals(responseJson, result.getResponse().getContentAsString());
  }
}
