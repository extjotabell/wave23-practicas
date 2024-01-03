package meli.bootcamp.sprint1.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UnFollowUserTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Unfollow user ok")
    void unFollowUserOkTest() throws Exception {
        BaseResponseDto expected = new BaseResponseDto("User 4 was unfollowed");

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}","1","4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("Unfollow user is not seller")
    void unFollowUserIsNotSellerTest() throws Exception {

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}","1","2"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
    @Test
    @DisplayName("Unfollow user equals id test")
    void unFollowUserEqualsIdTest() throws Exception {

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}","1","1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
    @Test
    @DisplayName("Unfollow user empty list followed-followers")
    void unFollowUserFollowerListAndFollowedListEmptyTest() throws Exception {

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}","2","8"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
    @Test
    @DisplayName("Unfollow user doesnt follow")
    void unFollowUserDoesntFollowTest() throws Exception {
        BaseResponseDto expected = new BaseResponseDto("Error unfollowing user, user 8 doesn't follow user 4");

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}","8","4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
}
