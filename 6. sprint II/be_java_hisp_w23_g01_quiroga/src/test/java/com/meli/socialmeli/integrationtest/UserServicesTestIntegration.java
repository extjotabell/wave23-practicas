package com.meli.socialmeli.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.socialmeli.dtos.response.MessageDTO;
import org.junit.jupiter.api.DisplayName;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class UserServicesTestIntegration {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    @DisplayName("Integración de US-0001")
    void followSeller () throws Exception {
        //Arrange

        MessageDTO devolucion = new MessageDTO("Usuario seguido agregado");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/100/follow/1100");
        //Expected Status - ContentType - Body

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher bodyExpected = content().json(writer.writeValueAsString(devolucion));

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Integración de US-0002")
    void getFollowerCount () throws Exception {
        //Arrange

        String responseJSONExpected = "{'user_id': 100, 'user_name': 'Roach', 'followers_count': 2}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2100/follow/100")
                        .contentType(MediaType.APPLICATION_JSON));
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/3100/follow/100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/100/followers/count");
        //Expected Status - ContentType - Body

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher bodyExpected = content().json(responseJSONExpected);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Devuelve lista de usuarios")
    void getListOfAllUsers() throws Exception {
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users");

        //Expected Status - ContentType - Body

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andDo(MockMvcResultHandlers.print());
    }
}
