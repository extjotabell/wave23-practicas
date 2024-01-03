package meli.bootcamp.sprint1.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowUserTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Follor user ok test")
    void followUserOkTest() throws Exception {
        BaseResponseDto expected =new BaseResponseDto("User followed");

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("Follor user not seller test")
    void followUserNotSellerTest() throws Exception {
        BaseResponseDto expected =new BaseResponseDto("User 2 is not a seller");

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,2))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("Follor user already followed test")
    void followUserAlreadyFollowedTest() throws Exception {
        BaseResponseDto expected =new BaseResponseDto("The user is already followed");

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",4,1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Follor user bad test")
    void followUserBadTest() throws Exception {
        BaseResponseDto expected =new BaseResponseDto("You can't follow yourself!");

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = objecTWriter.writeValueAsString(expected);
        MvcResult mvcResult = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",4,4))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }

}
