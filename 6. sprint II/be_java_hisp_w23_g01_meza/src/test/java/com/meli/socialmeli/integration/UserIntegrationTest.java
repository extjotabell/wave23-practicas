package com.meli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.socialmeli.dtos.response.FollowersCountDTO;
import com.meli.socialmeli.repositories.IUserRepository;
import com.meli.socialmeli.services.IUserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRepository userRepository;
    private static ObjectWriter objectWriter;

    @BeforeAll
    public static void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    public void initialization() {
        userRepository.loadData();
    }

    @AfterEach
    public void clean() {
        userRepository.clearData();
    }

    @Test
    @DisplayName("/users/{userId}/follow/{userIdToFollow} ; T-0010: Usuario logra seguir al otro usuario con éxito.")
    void AddFollowerIntegrationTest() throws Exception{
        // Arrange & Act & Assert
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "2100"
                ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Usuario seguido agregado"));
    }

    @Test
    @DisplayName("/users/{userId}/follow/{userIdToFollow} ; " +
            "T-0011: Usuario no logra seguir al otro usuario porque ya lo esta siguiendo.")
    void AddFollowerItsFollowingIntegrationTest() throws Exception{
        // Arrange
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "1100"
                ));
        // Act & Assert
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "1100"
                ))
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.message").value("El usuario ya sigue al usuario deseado")
                );
    }

    @Test
    @DisplayName("/users/{userId}/follow/{userIdToFollow} ; T-0012: Usuario no puede seguirse a el mismo.")
    void AddFollowerTryFollowsItselfIntegrationTest() throws Exception{
        // Arrange & Act & Assert
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "100"
                ))
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.message").value("Usuario inválido para seguir")
                );
    }

    @Test
    @DisplayName("/users/{userId}/follow/{userIdToFollow} ; T-0015: Usuario no puede seguir a usuario no existente.")
    void AddFollowerTryFollowInexistenUserIntegrationTest() throws Exception{
        // Arrange & Act & Assert
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "1213"
                ))
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.message").value("Usuario a seguir no encontrado")
                );
    }

    @Test
    @DisplayName("/users/{userId}/follow/{userIdToFollow} ; T-0016: Usuario no existente no puede seguir a nadie.")
    void AddFollowerInexistenUserIntegrationTest() throws Exception{
        // Arrange & Act & Assert
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "1213", "100"
                ))
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.message").value("Usuario seguidor no encontrado")
                );
    }

    @Test
    @DisplayName("/users/{userId}/followers/count ; " +
            "T-0013: Consigue la respuesta correcta y el numero correcto de usuarios que lo siguen.")
    void countFollowersIntegrationTest() throws Exception {
        // Arrange & Act
        String expected = objectWriter.writeValueAsString(new FollowersCountDTO(1100,"Dudley", 0));
        MvcResult mvcResult = this.mockMvc
                .perform(get(
                        "/users/{userId}/followers/count", "1100"
                ))
                .andDo(print())
        // Assert
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn();

        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("/users/{userId}/followers/list?order=name_asc ; " +
            "T-0017: Retorna una lista de seguidores de forma ascendente.")
    void getFollowersByIdShouldReturnListAsc() throws Exception {
        //Arrange
        String expected = "{'user_id': 100, 'user_name': 'Roach', " +
                "'followers': [{'user_id': 2100, 'user_name': 'Moreno'}, {'user_id': 3100, 'user_name': 'Peters'}]}";

        this.mockMvc.perform(
                post("/users/2100/follow/100")
                        .contentType(APPLICATION_JSON));
        this.mockMvc.perform(
                post("/users/3100/follow/100")
                        .contentType(APPLICATION_JSON));

        //Act - Assert
        this.mockMvc.perform(
                        get("/users/100/followers/list?order=name_asc")
                                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(expected))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("/users/{userId}/followed/list?order=name_asc ; " +
            "T-0019: Verificar que si el usuario no existe mande un mensaje de error.")
    void getFollowedByInvalidIdShouldReturnExplanation() throws Exception {
        //Arrange . Act - Assert
        this.mockMvc.perform(
                        get("/users/1/followed/list?order=name_asc")
                                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No existe usuario con el id: 1"))
                .andExpect(status().isNotFound());
    }

}
