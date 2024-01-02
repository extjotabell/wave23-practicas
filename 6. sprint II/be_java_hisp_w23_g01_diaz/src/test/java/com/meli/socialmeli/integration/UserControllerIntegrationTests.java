package com.meli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.socialmeli.dtos.response.FollowersCountDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.response.UserFollowersDTO;
import com.meli.socialmeli.dtos.response.UserInfoDTO;
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

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper writer = new ObjectMapper();

    /*
        US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
     */
    @Test
    @DisplayName("Follow seller: Ok")
    void followSellerOk() throws Exception{
        //Arrange

        //Preparing request
        int userId = 100;
        int userIdToFollow = 1100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario seguido agregado");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Followe seller: Seguidor no encontrado")
    void followSellerInvalidFollower() throws Exception {
        //Arrange

        //Preparing request
        int userId = 9999;
        int userIdToFollow = 1100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario seguidor no encontrado");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Followe seller: Usuario a seguir no encontrado")
    void followSellerInvalidFollowed() throws Exception {
        //Arrange

        //Preparing request
        int userId = 100;
        int userIdToFollow = 9999;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario a seguir no encontrado");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Followe seller: Usuario a seguir sin posts")
    void followSellerWithoutPosts() throws Exception {
        //Arrange

        //Preparing request
        int userId = 100;
        int userIdToFollow = 5100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario inválido para seguir");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Followe seller: Mismo usuario")
    void followSellerSameUser() throws Exception {
        //Arrange

        //Preparing request
        int userId = 100;
        int userIdToFollow = 100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario inválido para seguir");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    /*
        US-0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
     */
    @Test
    @DisplayName("Get followers count: Ok")
    void getFollowersCountOk() throws Exception{
        //Arrange

        //Pre-request to add follower
        int userIdFollowed = 100;
        int userIdToFollow = 1100;
        MockHttpServletRequestBuilder addFollowerRequest = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userIdFollowed,
                userIdToFollow
        );

        mockMvc.perform(addFollowerRequest);

        //Preparing request
        int userId = 1100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/count",
                userId
        );


        FollowersCountDTO expectedContent = new FollowersCountDTO();
        expectedContent.setFollowers_count(1);
        expectedContent.setUser_id(1100);
        expectedContent.setUser_name("Dudley");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Get followers count: Id de usuario inválido")
    void getFollowersCountInvalidUserid() throws Exception {
        //Arrange

        //Preparing request
        int userId = 9999;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/count",
                userId
        );

        MessageDTO expectedContent = new MessageDTO("Usuario no encontrado");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    /*
        US-0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
        US-0008: Ordenamiento alfabético ascendente y descendente.
     */
    @Test
    @DisplayName("Get followers by id: Ok orden asc")
    void getFollowersByIdOkAsc() throws Exception{
        //Arrange

        //Pre-requests to add followers
        int userIdFollowed = 100;
        int userIdToFollow = 1100;
        MockHttpServletRequestBuilder addFollowerRequest = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userIdFollowed,
                userIdToFollow
        );
        mockMvc.perform(addFollowerRequest);

        userIdFollowed = 2100;
        addFollowerRequest = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userIdFollowed,
                userIdToFollow
        );
        mockMvc.perform(addFollowerRequest);


        //Preparing request
        int userId = 1100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list",
                userId
        )
                .param("order", "name_asc");

        List<UserInfoDTO> userInfoDTOList = List.of(
                new UserInfoDTO(2100, "Moreno"),
                new UserInfoDTO(100, "Roach")
        );
        UserFollowersDTO expectedContent = new UserFollowersDTO(1100, "Dudley", userInfoDTOList);


        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Get followers by id: Ok orden desc")
    void getFollowersByIdOkDes() throws Exception{
        //Arrange

        //Pre-requests to add followers
        int userIdFollowed = 100;
        int userIdToFollow = 1100;
        MockHttpServletRequestBuilder addFollowerRequest = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userIdFollowed,
                userIdToFollow
        );
        mockMvc.perform(addFollowerRequest);

        userIdFollowed = 2100;
        addFollowerRequest = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userIdFollowed,
                userIdToFollow
        );
        mockMvc.perform(addFollowerRequest);


        //Preparing request
        int userId = 1100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                        "/users/{userId}/followers/list",
                        userId
                )
                .param("order", "name_desc");

        List<UserInfoDTO> userInfoDTOList = List.of(
                new UserInfoDTO(100, "Roach"),
                new UserInfoDTO(2100, "Moreno")
        );
        UserFollowersDTO expectedContent = new UserFollowersDTO(1100, "Dudley", userInfoDTOList);


        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Get followers by id: Sin especificación de ordenamiento")
    void getFollowersByIdNotOrder() throws Exception{
        //Arrange
        //Preparing request
        int userId = 1100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                        "/users/{userId}/followers/list",
                        userId
                );

        MessageDTO expectedContent = new MessageDTO("Debe indicar un parámetro de orden válido: 'name_asc' o 'name_desc'");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act & Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Get followers by id: Usuario inválido")
    void getFollowersByIdNotFound() throws Exception{
        //Arrange
        //Preparing request
        int userId = 9999;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list",
                userId
        );

        MessageDTO expectedContent = new MessageDTO("No existe usuario con el id: " + userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act & Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

}
