package meli.bootcamp.sprint1.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.sprint1.dto.response.UserDto;
import meli.bootcamp.sprint1.dto.response.UserWFollowedDto;
import meli.bootcamp.sprint1.exception.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowedListTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Followed list ok test")
    void followedListOkTest() throws Exception {
        UserWFollowedDto expected = new UserWFollowedDto(1,"Ailen Pereira", List.of(
                new UserDto(2,"Brenda Torrico"),
                new UserDto(3,"Fatima Noble"),
                new UserDto(4,"Geronimo Schmidt")
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(get("/users/{userId}/followed/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("Followed list ok order desc test")
    void followedListOkOrderDescTest() throws Exception {
        UserWFollowedDto expected = new UserWFollowedDto(1,"Ailen Pereira", List.of(
                new UserDto(4,"Geronimo Schmidt"),
                new UserDto(3,"Fatima Noble"),
                new UserDto(2,"Brenda Torrico")
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(get("/users/{userId}/followed/list",1)
                        .param("order","name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("Followed list user not found test")
    void followedListUserNotFoundTest() throws Exception {
        this.mockMvc.perform(get("/users/{userId}/followed/list",11111))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
    @Test
    @DisplayName("User no followers list test")
    void followedListUserNoFollowersTest() throws Exception {
        this.mockMvc.perform(get("/users/{userId}/followed/list",7))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
}
