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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
    @DisplayName("Test para verificar el camino bueno del endpoint GetFollowersCount (US-0002)")
    void testGetFollowersCountEndpoint() throws Exception{

        this.mockMvc.perform(get("/users/100/followers/count")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString();
    }
    @Test
    @DisplayName("Test para verificar el camino malo del endpoint GetFollowersCount (US-0002)")
    void testGetFollowersCountEndpointBadWay() throws Exception{
        String expectedResponse = "{'message':'Usuario no encontrado'}";
        this.mockMvc.perform(get("/users/1/followers/count")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(content().json(expectedResponse))
                    .andExpect(status().isNotFound())
                    .andReturn().getResponse().getContentAsString();
    }

    @Test
    @DisplayName("Test para verificar el camino bueno del endpoint GetFollowersById (US-0003)")
    void testGetFollowersByIdEndpoint() throws Exception{
        this.mockMvc.perform(get("/users/100/followers/list")
                    .param("order", "name_asc")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString();
    }

    @Test
    @DisplayName("Test para verificar el camino malo del endpoint GetFollowersById (US-0003)")
    void testGetFollowersByIdEndpointBadWay() throws Exception{
        this.mockMvc.perform(get("/users/100/followers/list")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andReturn().getResponse().getContentAsString();
    }

    @Test
    @DisplayName("Test para verificar el camino bueno del endpoint GetFollowedById (US-0004)")
    void testGetFollowedByIdEndpoint() throws Exception{
        this.mockMvc.perform(get("/users/100/followed/list")
                    .param("order", "name_desc")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString();
    }

    @Test
    @DisplayName("Test para verificar el camino malo del endpoint GetFollowedById (US-0004)")
    void testGetFollowedByIdEndpointBadWay() throws Exception{
        String expectedResponse = "{'message':'No existe usuario con el id: 10210'}";
        this.mockMvc.perform(get("/users/10210/followed/list")
                    .param("order", "name_desc")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(content().json(expectedResponse))
                    .andExpect(status().isNotFound())
                    .andReturn().getResponse().getContentAsString();
    }

    @Test
    @DisplayName("Test para verificar el camino bueno del endpoint unfollowUser (US-0007)")
    void testUnfollowUserEndpoint() throws Exception {
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
