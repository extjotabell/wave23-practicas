package com.mercadolibre.be_java_hisp_w23_g2.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerIntegrationTest {

    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    @Autowired
    MockMvc mockMvc;

    @DisplayName("User followers count integration test")
    @Test
    public void getFollowersCountSellerTest() throws Exception {
        UserFollowersCountDTO expected = new UserFollowersCountDTO(1,"John Doe",3);

        MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        
        assertEquals(writer.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());

    }

    @DisplayName("User followers list integration test")
    @Test
    public void getFollowersUserTest() throws Exception {
        UserFollowersDTO expected = new UserFollowersDTO(1,"John Doe", List.of(new UserBasicDTO(2,"Alice Smith"),
                new UserBasicDTO(3,"Bob Jones")));

        MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(writer.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());

    }

    @DisplayName("User followed list integration test")
    @Test
    public void getFollowedUserTest() throws Exception {
        UserFollowedDTO expected = new UserFollowedDTO(1,"John Doe", List.of(new UserBasicDTO(5,"Charlie Brown")));

        MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(writer.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());

    }

    @DisplayName("Unfollow user integration test")
    @Test
    public void unfollowUserTest() throws Exception {
        MessageDTO expected = new MessageDTO("Has stopped following Eve Wilson");

        MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}","1","4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(writer.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());

    }

    @DisplayName("Follow user integration test")
    @Test
    public void followUserTest() throws Exception {
        UserFollowedDTO expected = new UserFollowedDTO(2,"Alice Smith",
                List.of(new UserBasicDTO(4,"Eve Wilson"),
                        new UserBasicDTO(5,"Charlie Brown"),
                        new UserBasicDTO(1,"John Doe")));

        MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}","2","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(writer.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());

    }
}
