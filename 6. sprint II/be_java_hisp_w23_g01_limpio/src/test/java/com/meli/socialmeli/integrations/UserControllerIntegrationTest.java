package com.meli.socialmeli.integrations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test para verificar el camino bueno del endpoint GetALLUsers (US-0001)")
    void testGetAllUsersEndpoint() throws Exception {
        this.mockMvc.perform(get("/users")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString();
    }

    @Test
    @DisplayName("Test para verificar el camino malo del endpoint GetALLUsers (US-0001)")
    void testGetAllUsersEndpointBadWay() throws Exception {
        this.mockMvc.perform(get("/user")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andReturn().getResponse().getContentAsString();
    }

    @Test
    @DisplayName("Test para verificar el camino bueno del endpoint unfollowUser (US-0007)")
    void testUnfollowUserEndpoint() throws Exception {
        //Creacion de un seguidor
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/3100/follow/100")
                    .contentType(MediaType.APPLICATION_JSON));

        this.mockMvc.perform(post("/users/3100/unfollow/100")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString();
    }
    @Test
    @DisplayName("Test para verificar el camino bueno del endpoint unfollowUser (US-0007)")
    void testUnfollowUserEndpointBadWay() throws Exception {

        this.mockMvc.perform(post("/users/31030/unfollow/100")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andReturn().getResponse().getContentAsString();
    }

}
