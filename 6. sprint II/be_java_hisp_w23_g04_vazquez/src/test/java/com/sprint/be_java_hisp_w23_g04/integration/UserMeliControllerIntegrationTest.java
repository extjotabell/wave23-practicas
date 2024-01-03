package com.sprint.be_java_hisp_w23_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.dto.response.BuyerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SellerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserMeliControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Get all users")
    void test22() throws Exception {
        // Arrange
        List<UserDTO> expectedResponse = List.of(
                new UserDTO(1, "Juan Perez"),
                new UserDTO(2, "Maria Gonzalez"),
                new UserDTO(3, "Pablo Gonzalez"),
                new UserDTO(4, "Sofia Gomez"),
                new UserDTO(5, "Pedro Lopez"),
                new UserDTO(6, "Diego Lopez"),
                new UserDTO(7, "Penelope cruz"),
                new UserDTO(8, "Pablo Gonzalez")
        );

        ObjectMapper writer = new ObjectMapper();
        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(expectedResponse);

        // Act
        this.mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(payloadJson));
    }

    @Test
    @DisplayName("Follow seller user")
    void test1() throws Exception {
        // Arrange
        Integer userId = 2;
        Integer userIdToFollow = 1;
        SimpleMessageDTO expectedResponse = new SimpleMessageDTO("El usuario con id:" + userId + " ahora sigue a vendedor con id:" + userIdToFollow);

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());

        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(expectedResponse);


        // Act
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(payloadJson));
    }

    @Test
    @DisplayName("Follow seller user error because userId is not seller")
    void test2() throws Exception {
        // Arrange
        Integer userId = 2;
        Integer userIdToFollow = 4;

        // Act
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El id de usuario vendedor proporcionado no es valido."));
    }

    @Test
    @DisplayName("Follow seller user error because already is follow")
    void test13() throws Exception {
        // Arrange
        Integer userId = 4;
        Integer userIdToFollow = 1;

        // Act
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El usuario con id:4 ya sigue al vendedor con id:1"));
    }

    @Test
    @DisplayName("Follow seller user error because is the same userId")
    void test3() throws Exception {
        // Arrange
        Integer userId = 2;
        Integer userIdToFollow = 2;

        // Act
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El usuario y vendedor con id:2 no pueden ser el mismo."));
    }

    @Test
    @DisplayName("Follow seller user error because userId is ZERO")
    void test4() throws Exception {
        // Arrange
        Integer userId = 0;
        Integer userIdToFollow = 1;

        // Act
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"))
                .andExpect(jsonPath("$.messages").value("El id debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Follow seller user error because userId not exists")
    void test8() throws Exception {
        // Arrange
        Integer userId = 1;
        Integer userIdToFollow = 99;

        // Act
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 99."));
    }

    @Test
    @DisplayName("Get followers count")
    void test5() throws Exception {
        // Arrange
        Integer userId = 1;
        SellerDTO expectedResponse = new SellerDTO(1, "Juan Perez", 2);

        ObjectMapper writer = new ObjectMapper();
        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(expectedResponse);

        // Act
        this.mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(payloadJson));

    }

    @Test
    @DisplayName("Get followers count error because userId is ZERO")
    void test6() throws Exception {
        // Arrange
        Integer userId = 0;

        // Act
        this.mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"))
                .andExpect(jsonPath("$.messages").value("El id del usuario debe ser mayor a cero"));

    }

    @Test
    @DisplayName("Get followers count error because userId not exist")
    void test7() throws Exception {
        // Arrange
        Integer userId = 99;

        // Act
        this.mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 99."));

    }

    @Test
    @DisplayName("Get all followers user by user id")
    void test9() throws Exception {
        // Arrange
        Integer userId = 1;
        String criteriaOrder = "name_asc";
        BuyerDTO expectedResponse = new BuyerDTO(1, "Juan Perez", List.of(
                new UserDTO(6, "Diego Lopez"),
                new UserDTO(4, "Sofia Gomez")
        ));

        ObjectMapper writer = new ObjectMapper();
        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(expectedResponse);

        // Act
        this.mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", criteriaOrder))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(payloadJson));
    }

    @Test
    @DisplayName("Get all followers error user not have followers")
    void test12() throws Exception {
        // Arrange
        Integer userId = 4;
        String criteriaOrder = "name_asc";

        // Act
        this.mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", criteriaOrder))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Get all followers error because criteria not exist")
    void test10() throws Exception {
        // Arrange
        Integer userId = 1;
        String criteriaOrder = "name_false";

        // Act
        this.mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", criteriaOrder))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El criterio de ordenamiento no existe."));
    }

    @Test
    @DisplayName("Get all followers error because userId is ZERO")
    void test11() throws Exception {
        // Arrange
        Integer userId = 0;
        String criteriaOrder = "name_dsc";

        // Act
        this.mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", criteriaOrder))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"))
                .andExpect(jsonPath("$.messages").value("El id del usuario debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Get followed by userId")
    void test14() throws Exception {
        // Arrange
        Integer userId = 4;
        String criteriaOrder = "name_asc";
        BuyerDTO expectedResponse = new BuyerDTO(4, "Sofia Gomez", List.of(
                new UserDTO(1, "Juan Perez"),
                new UserDTO(3, "Pablo Gonzalez")
        ));

        ObjectMapper writer = new ObjectMapper();
        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(expectedResponse);

        // Act
        this.mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .param("order", criteriaOrder))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(payloadJson));

    }

    @Test
    @DisplayName("Get followed error user not have followers")
    void test15() throws Exception {
        // Arrange
        Integer userId = 2;
        String criteriaOrder = "name_asc";

        // Act
        this.mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .param("order", criteriaOrder))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Get followed error because criteria not exist")
    void test16() throws Exception {
        // Arrange
        Integer userId = 1;
        String criteriaOrder = "name_false";

        // Act
        this.mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .param("order", criteriaOrder))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El criterio de ordenamiento no existe."));
    }

    @Test
    @DisplayName("Get followed error because userId is ZERO")
    void test17() throws Exception {
        // Arrange
        Integer userId = 0;
        String criteriaOrder = "name_dsc";

        // Act
        this.mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .param("order", criteriaOrder))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"))
                .andExpect(jsonPath("$.messages").value("El id del usuario debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Unfollow user")
    void test18() throws Exception {
        // Arrange
        Integer userId = 4;
        Integer userIdToUnfollow = 1;
        SimpleMessageDTO expectedResponse = new SimpleMessageDTO("El usuario Juan Perez Id: 1 ya no es seguido por el usuario Sofia Gomez Id: 4");

        ObjectMapper writer = new ObjectMapper();
        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(expectedResponse);

        // Act
        this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isAccepted())
                .andExpect(content().json(payloadJson));
    }

    @Test
    @DisplayName("Unfollow user error because user is not follow")
    void test19() throws Exception {
        // Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 4;
        SimpleMessageDTO expectedResponse = new SimpleMessageDTO("El vendedor con id:1 no es seguido por el usuario con id:4");

        ObjectMapper writer = new ObjectMapper();
        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(expectedResponse);

        // Act
        this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(payloadJson));
    }

    @Test
    @DisplayName("Unfollow user error because user is ZERO")
    void test20() throws Exception {
        // Arrange
        Integer userId = 0;
        Integer userIdToUnfollow = 4;

        // Act
        this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"))
                .andExpect(jsonPath("$.messages").value("El id del usuario debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Unfollow user error because user is not exists")
    void test21() throws Exception {
        // Arrange
        Integer userId = 99;
        Integer userIdToUnfollow = 4;

        // Act
        this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 99."));
    }
}
