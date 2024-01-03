package meli.bootcamp.sprint1.integration.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.sprint1.dto.response.UserDto;
import meli.bootcamp.sprint1.dto.response.UserWFollowerListDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GetFollowersByIdTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("getFollowersById test ok")
    void getFollowersByIdTest() throws Exception{

        UserWFollowerListDto expected = new UserWFollowerListDto(4,"Geronimo Schmidt",List.of(
                new UserDto(1, "Ailen Pereira"),
                new UserDto(2,"Brenda Torrico"),
                new UserDto(3,"Fatima Noble")
        ));
        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(get("/users/{id}/followers/list","4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("getFollowersById order asc test ok")
    void getFollowersByIdOrderAscTest() throws Exception{
        // /users/{id}/followers/list

        UserWFollowerListDto expected = new UserWFollowerListDto(4,"Geronimo Schmidt",List.of(
                new UserDto(1, "Ailen Pereira"),
                new UserDto(2,"Brenda Torrico"),
                new UserDto(3,"Fatima Noble")
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(get("/users/{id}/followers/list","4")
                        .param("order","name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("getFollowersById order desc test ok")
    void getFollowersByIdOrderDescTest() throws Exception{
        // /users/{id}/followers/list

        UserWFollowerListDto expected = new UserWFollowerListDto(4,"Geronimo Schmidt",List.of(
                new UserDto(3,"Fatima Noble"),
                new UserDto(2,"Brenda Torrico"),
                new UserDto(1, "Ailen Pereira")
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(get("/users/{id}/followers/list","4")
                        .param("order","name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("getFollowersById UserNotFound Test")
    void getFollowersByIdUserNotFoundTest() throws Exception{
        mockMvc.perform(get("/users/{id}/followers/list","4555")
                        .param("order","name_desc"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

}
