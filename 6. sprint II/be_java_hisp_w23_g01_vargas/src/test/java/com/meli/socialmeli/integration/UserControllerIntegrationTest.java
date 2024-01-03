package com.meli.socialmeli.integration;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("GET: /users - Retorna una lista de usuarios")
    void getAllUsersShouldReturnList() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST: /users/{userId}/follow/{userIdToFollow} - Verifica seguimiento - Retorna confirmación")
    void followSellerShouldReturnConfirmation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'message': 'Usuario seguido agregado'}";

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/4100/follow/2100")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST: /users/{userId}/follow/{userIdToFollow} - Vendedor seguido con anterioridad - Retorna explicación")
    void followSellerAlreadyFollowedShouldReturnExplanation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'message': 'El usuario ya sigue al usuario deseado'}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/100/follow/2100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/100/follow/2100")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST: /users/{userId}/follow/{userIdToFollow} - Usuario seguidor invalido - Retorna explicación")
    void followSellerInvalidIDFollowerShouldReturnExplanation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'message': 'Usuario seguidor no encontrado'}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/100/follow/2100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/1034340/follow/2100")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST: /users/{userId}/follow/{userIdToFollow} - Usuario vendedor invalido - Retorna explicación")
    void followSellerInvalidIDFollowedShouldReturnExplanation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'message': 'Usuario a seguir no encontrado'}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/100/follow/2100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/100/follow/22100")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET: /users/{userId}/followers/list?order=name_asc -Retorna una lista de seguidores - Ordenado por nombre ascendente")
    void getFollowersByIdShouldReturnListAsc() throws Exception {
        //Arrange
        String responseJSONExpected = "{'user_id': 100, 'user_name': 'Roach', " +
                "'followers': [{'user_id': 2100, 'user_name': 'Moreno'}, {'user_id': 3100, 'user_name': 'Peters'}]}";

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2100/follow/100")
                        .contentType(MediaType.APPLICATION_JSON));
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/3100/follow/100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/100/followers/list?order=name_asc")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET: /users/{userId}/followers/list?order=name_desc - Retorna una lista de seguidores - Ordenado por nombre descendente")
    void getFollowersByIdShouldReturnListDesc() throws Exception {
        //Arrange
        String responseJSONExpected = "{'user_id': 100, 'user_name': 'Roach', " +
                "'followers': [{'user_id': 3100, 'user_name': 'Peters'}, {'user_id': 2100, 'user_name': 'Moreno'}]}";

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2100/follow/100")
                        .contentType(MediaType.APPLICATION_JSON));
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/3100/follow/100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/100/followers/list?order=name_asc")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET: /users/{userId}/followers/list?order=name_desc - ID de Usuario invalido - Retorna explicación")
    void getFollowersByInvalidIdShouldReturnExplanation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'message':'No existe usuario con el id: 10999990'}";
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/10999990/followers/list?order=name_asc")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("GET: /{userId}/followers/count - Retorna el numero de seguidores del usuario")
    void getFollowersCountShouldReturnNumberOfFollowers() throws Exception {
        //Arrange
        String responseJSONExpected = "{'user_id': 100, 'user_name': 'Roach', 'followers_count': 2}";

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2100/follow/100")
                        .contentType(MediaType.APPLICATION_JSON));
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/3100/follow/100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/100/followers/count")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET: /{userId}/followers/count - ID  de usuario invalido - Retorna explicación")
    void getFollowersCountInvalidIdShouldReturnExplanation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'message':'Usuario no encontrado'}";
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/10999990/followers/count")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET: /users/{userId}/followed/list?order=name_asc - Retorna una lista de seguidos - Ordenado por nombre ascendente")
    void getFollowedByIdShouldReturnListAsc() throws Exception {
        //Arrange
        String responseJSONExpected = "{'user_id': 4100, 'user_name': 'Garner', " +
                "'followed': [{'user_id': 2100, 'user_name': 'Moreno'}, {'user_id': 3100, 'user_name': 'Peters'}]}";

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/4100/follow/2100")
                        .contentType(MediaType.APPLICATION_JSON));

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/4100/follow/3100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/4100/followed/list?order=name_asc")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET: /users/{userId}/followed/list?order=name_asc - Retorna una lista de seguidos - Ordenado por nombre descendente")
    void getFollowedByIdShouldReturnListDesc() throws Exception {
        //Arrange
        String responseJSONExpected = "{'user_id': 4100, 'user_name': 'Garner', " +
                "'followed': [{'user_id': 3100, 'user_name': 'Peters'},{'user_id': 2100, 'user_name': 'Moreno'}]}";

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/4100/follow/2100")
                        .contentType(MediaType.APPLICATION_JSON));

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/4100/follow/3100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/4100/followed/list?order=name_desc")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET: /users/{userId}/followed/list?order=name_asc - ID de usuario invalido - Retorna explicación")
    void getFollowedByInvalidIdShouldReturnExplanation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'message':'No existe usuario con el id: 10999990'}";
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/10999990/followed/list?order=name_asc")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST: /{userId}/unfollow/{userIdToUnfollow} - Retorna confirmación de dejar de seguir")
    void getUnfollowShouldReturnConfirmation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'userId':2100,'userIdToUnfollow':100}";

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2100/follow/100")
                        .contentType(MediaType.APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/2100/unfollow/100")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST: /{userId}/unfollow/{userIdToUnfollow} - Id de Usuario invalido - Retorna explicación")
    void getUnfollowInvalidFollowerShouldReturnExplanation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'message':'Usuario no encontrado'}";
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/10999990/unfollow/100")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isNotFound());
    }
}
