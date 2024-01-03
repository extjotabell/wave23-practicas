package com.sprint.be_java_hisp_w23_g04.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.be_java_hisp_w23_g04.dto.response.BuyerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SellerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserMeliIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @Test
    @DisplayName("US-001 - An user follows a buyer successfully.")
    public void successfulFollowUserTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{sellerId}", 5, 8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El usuario con id:5 ahora sigue a vendedor con id:8"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US-001 - A non-existent user tries to follow a buyer.")
    public void userNotFoundFollowUserTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{sellerId}", 66, 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 66."))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("US-001 - An user tries to follow a non-existent buyer.")
    public void sellerNotFoundFollowUserTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{sellerId}", 1, 66))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 66."))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("US-001 - An user tries to follow another user who is not a seller.")
    public void userNotSellerFollowUserTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{sellerId}", 66, 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 66."))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("US-002 - Get an user's followers count")
    public void successfulFollowerCountTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.followers_count").value(2))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US-002 - Get an user without follower's followers count")
    public void noFollowersFollowerCountTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("Sofia Gomez"))
                .andExpect(jsonPath("$.followers_count").value(0))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US-002 - Try to get an non-existent user followers count")
    public void userNotFoundFollowerCountTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 66))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 66."))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("US-003 - Get user's followers")
    public void successfulGetFollowersTest() throws Exception{
        List<String> followers =
                List.of(writer.writeValueAsString(new UserDTO(6, "Diego Lopez")), writer.writeValueAsString(new UserDTO(4, "Sofia Gomez")));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.followed[0].user_id").value(6))
                .andExpect(jsonPath("$.followed[0].user_name").value("Diego Lopez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(4))
                .andExpect(jsonPath("$.followed[1].user_name").value("Sofia Gomez"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US-003 - Get user's followers in ascending order")
    public void successfulGetFollowersAscendingOrderTest() throws Exception{
        List<String> followers =
                List.of(writer.writeValueAsString(new UserDTO(6, "Diego Lopez")), writer.writeValueAsString(new UserDTO(4, "Sofia Gomez")));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order=name_asc", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.followed[0].user_id").value(6))
                .andExpect(jsonPath("$.followed[0].user_name").value("Diego Lopez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(4))
                .andExpect(jsonPath("$.followed[1].user_name").value("Sofia Gomez"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US-003 - Get user's followers in descending order")
    public void successfulGetFollowersDescendingOrderTest() throws Exception{
        List<String> followers =
                List.of(writer.writeValueAsString(new UserDTO(6, "Diego Lopez")), writer.writeValueAsString(new UserDTO(4, "Sofia Gomez")));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order=name_dsc", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(6))
                .andExpect(jsonPath("$.followed[1].user_name").value("Diego Lopez"))
                .andExpect(jsonPath("$.followed[0].user_id").value(4))
                .andExpect(jsonPath("$.followed[0].user_name").value("Sofia Gomez"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US-003 - Get an user without followers' follower list")
    public void successfulGetFollowersWithNoFollowersOrderTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("US-003 - Try to get an non-existent user's follower list")
    public void userNotFoundFollowersTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 66))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 66."))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("US-004 - Get user's followed")
    public void successfulGetFollowedTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("Sofia Gomez"))
                .andExpect(jsonPath("$.followed[0].user_id").value(1))
                .andExpect(jsonPath("$.followed[0].user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(3))
                .andExpect(jsonPath("$.followed[1].user_name").value("Pablo Gonzalez"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US-004 - Get user's followed in ascending order")
    public void successfulGetFollowedAscendingOrderTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=name_asc", 4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("Sofia Gomez"))
                .andExpect(jsonPath("$.followed[0].user_id").value(1))
                .andExpect(jsonPath("$.followed[0].user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(3))
                .andExpect(jsonPath("$.followed[1].user_name").value("Pablo Gonzalez"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US-004 - Get user's followed in descending order")
    public void successfulGetFollowedDescendingOrderTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=name_dsc", 4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("Sofia Gomez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(1))
                .andExpect(jsonPath("$.followed[1].user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.followed[0].user_id").value(3))
                .andExpect(jsonPath("$.followed[0].user_name").value("Pablo Gonzalez"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US-004 - Try to get an non-existent user's followed list")
    public void userNotFoundFollowedTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 66))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 66."))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("US-007 - An user unfollows a buyer succesfully.")
    public void successfulSavePostTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{sellerId}", 5, 8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El usuario Pablo Gonzalez Id: 8 ya no es seguido por el usuario Pedro Lopez Id: 5"))
                .andExpect(status().isAccepted());
    }
}
