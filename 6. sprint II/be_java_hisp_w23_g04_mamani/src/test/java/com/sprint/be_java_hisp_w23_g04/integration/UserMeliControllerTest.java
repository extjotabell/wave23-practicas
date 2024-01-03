package com.sprint.be_java_hisp_w23_g04.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO;
import com.sprint.be_java_hisp_w23_g04.repository.UserMediaRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserMeliControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserMediaRepositoryImpl userMediaRepository;

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    @DisplayName("Get All Users: Successful")
    void getAllUsersOKTest() throws Exception {
        //Act y Assert
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = result.getResponse().getContentAsString();
        List<UserDTO> studentsDTOs = mapper.readValue(jsonResponse, new TypeReference<List<UserDTO>>(){});
        assertEquals(8, studentsDTOs.size());
    }

    @Test
    @DisplayName("Follow User Seller: Successful")
    void followSellerUserOKTest() throws Exception {
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 6, 3))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("El usuario con id:6 ahora sigue a vendedor con id:3"));
    }

    @Test
    @DisplayName("Follow User Seller: Fails with Not Found when User Id does not exist")
    void followSellerUserException1Test() throws Exception {
        String expectedMsg= "No se encontró usuario con el id 99.";

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 99, 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Follow User Seller: Fails with Not Found when Seller Id does not exist")
    void followSellerUserException2Test() throws Exception {
        String expectedMsg= "No se encontró usuario con el id 99.";

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 99))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Follow User Seller: Fails with Bad Request when User and Seller Id are the same")
    void followSellerUserException3Test() throws Exception {
        String expectedMsg= "El usuario y vendedor con id:1 no pueden ser el mismo.";

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Follow User Seller: Fails with Bad Request when Seller Id provided is not a Seller")
    void followSellerUserException4Test() throws Exception {
        String expectedMsg= "El id de usuario vendedor proporcionado no es valido.";

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 4))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Follow User Seller: Fails with Bad Request when User already follows Seller")
    void followSellerUserException5Test() throws Exception {
        String expectedMsg= "El usuario con id:4 ya sigue al vendedor con id:1";

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 4, 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Follow User Seller: Fails with Bad Request when ids are negative")
    void followSellerUserValidationExceptionTest() throws Exception {
        String expectedMsg= "Se encontraron los siguientes errores en las validaciones:";
        String expectedMsgError = "El id debe ser mayor a cero";

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", -2, 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value(expectedMsg))
                .andExpect(jsonPath("$.messages", contains(expectedMsgError)));
    }

    @Test
    @DisplayName("Get Followers Count: Successful")
    void getFollowersOkTest() throws Exception {
        int expectedFollowersCount = 2;
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(expectedFollowersCount));
    }

    @Test
    @DisplayName("Get Followers Count: Fails with when")
    void getFollowersExceptionTest() throws Exception {
        int expectedFollowersCount = 2;
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(expectedFollowersCount));
    }

    @Test
    @DisplayName("Get Followers Count: Fails with Not Found when user does not exist")
    void getFollowersException1Test() throws Exception {
        String expectedMsg= "No se encontró usuario con el id 99.";
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 99))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Get Followers Count: Fails with Not Found when user does not exist")
    void getFollowersException3Test() throws Exception {
        String expectedMsg = "Se encontraron los siguientes errores en las validaciones:";
        String expectedMsgError = "El id del usuario debe ser mayor a cero";
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 0))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value(expectedMsg))
                .andExpect(jsonPath("$.messages", contains(expectedMsgError)));
    }

    @Test
    @DisplayName("Get All Followers By User Id Order Asc: Successful")
    void getAllFollowersByUserIdOrderAscOkTest() throws Exception {
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order={order}", 1, "name_asc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed").isArray())
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[*].user_name", contains("Diego Lopez", "Sofia Gomez")));
    }

    @Test
    @DisplayName("Get All Followers By User Id Order Dsc: Successful")
    void getAllFollowersByUserIdOrderDscOkTest() throws Exception {
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order={order}", 1, "name_dsc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed").isArray())
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[*].user_name", contains("Sofia Gomez", "Diego Lopez")));
    }

    @Test
    @DisplayName("Get All Followers By User Id: Fails with Not Found when user does not exist")
    void getAllFollowersByUserIdOrderDscExceptionTest() throws Exception {
        String expectedMsg= "No se encontró usuario con el id 99.";
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order={order}", 99, "name_dsc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Get All Followers By User Id: Returns No Content when user does not have followers")
    void getAllFollowersByUserIdOrderDscNoContentTest() throws Exception {
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order={order}", 4, "name_dsc"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Get All Followed By User Id Order Asc: Successful")
    void getAllFollowedByUserIdOrderAscOkTest() throws Exception {
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order={order}", 4, "name_asc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed").isArray())
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[*].user_name", contains("Juan Perez", "Pablo Gonzalez")));
    }

    @Test
    @DisplayName("Get All Followed By User Id Order Dsc: Successful")
    void getAllFollowedByUserIdOrderDscOkTest() throws Exception {
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order={order}", 4, "name_dsc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed").isArray())
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[*].user_name", contains("Pablo Gonzalez", "Juan Perez")));
    }

    @Test
    @DisplayName("Get All Followed By User Id: Fails with Not Found when user does not exist")
    void getAllFollowedByUserIdOrderDscExceptionTest() throws Exception {
        String expectedMsg= "No se encontró usuario con el id 99.";
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order={order}", 99, "name_dsc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Get All Followed By User Id: Returns No Content when user does not have followed")
    void getAllFollowedByUserIdOrderDscNoContentTest() throws Exception {
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order={order}", 2, "name_dsc"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Unfollow User Seller: Successful")
    void unfollowSellerUserOKTest() throws Exception {
        String msg = "El usuario Penelope cruz Id: 7 ya no es seguido por el usuario Diego Lopez Id: 6";
        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 6, 7))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.description").value(msg));
    }

    @Test
    @DisplayName("Unfollow User Seller: Fails with Not Found when User Id does not exist")
    void unfollowSellerUserException1Test() throws Exception {
        String expectedMsg= "No se encontró usuario con el id 99.";

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 99, 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Unfollow User Seller: Fails with Not Found when Seller Id does not exist")
    void unfollowSellerUserException2Test() throws Exception {
        String expectedMsg= "No se encontró usuario con el id 99.";

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 1, 99))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }

    @Test
    @DisplayName("Unfollow User Seller: Fails with Not Found when Seller Id does not exist")
    void unfollowSellerUserException3Test() throws Exception {
        String expectedMsg= "El usuario con id:6 no sigue al vendedor con id:1";

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 6, 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value(expectedMsg));
    }


}
