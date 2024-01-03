package com.mercadolibre.be_java_hisp_w23_g2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersDTO;
import com.mercadolibre.be_java_hisp_w23_g2.service.UserService;
import com.mercadolibre.be_java_hisp_w23_g2.utils.ObjectCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;
    ObjectMapper mapper = new ObjectMapper();

    @DisplayName("Count Followers OK")
    @Test
    void getFollowersCountSellerTestInt() throws Exception {
        // Arrange
        UserFollowersCountDTO followerExpected = ObjectCreator.createUserFollowersCountDTO();

        // Act
        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count", 10))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        UserFollowersCountDTO resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(), UserFollowersCountDTO.class);

        // Assert
        assertEquals(followerExpected, resultDto);
    }

    @DisplayName("Count Followers, Not found user")
    @Test
    void getFollowersCountSellerNotFoundTestInt() throws Exception {
        //Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/count", 99))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Current user with id = 99 not exists."));
    }

    @DisplayName("Followers List")
    @Test
    void getFollowersListUserTestInt() throws Exception {
        //Arrange
        UserFollowersDTO followerExpected = ObjectCreator.createUserFollowersDTO();

        //Act
        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        UserFollowersDTO resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(), UserFollowersDTO.class);

        //Assert
        assertEquals(followerExpected, resultDto);
    }

    @DisplayName("Unfollow user")
    @Test
    void unfollowUserTestInt() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 12, 15))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Has stopped following Mia Wright"));
    }

    @DisplayName("Unfollow user himself")
    @Test
    void unfollowUserHimselfTestInt() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 12, 12))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("A user cannot follow/unfollow himself"));
    }

    @DisplayName("Followed List order desc")
    @Test
    void getFollowedUserOrderDescTestInt() throws Exception {
        // Arrange
        UserFollowedDTO followerExpected = ObjectCreator.createUserFollowedDTOdesc();

        //Act
        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 1).param("order", "name_desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        UserFollowedDTO resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(), UserFollowedDTO.class);

        //Assert
        assertEquals(followerExpected, resultDto);
    }

    @DisplayName("Followed List order asc")
    @Test
    void getFollowedUserOrderAscTestInt() throws Exception {
        // Arrange
        UserFollowedDTO followerExpected = ObjectCreator.createUserFollowedDTOasc();

        //Act
        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 1).param("order", "name_asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        UserFollowedDTO resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(), UserFollowedDTO.class);

        //Assert
        assertEquals(followerExpected, resultDto);
    }

    @DisplayName("Follow user OK")
    @Test
    void getFollowersUserTestInt() throws Exception {
        // Arrange
        UserFollowedDTO followExpected = ObjectCreator.createUserFollowedDTO();

        //Act
        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2, 15))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        UserFollowedDTO resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(), UserFollowedDTO.class);

        // Assert
        assertEquals(followExpected, resultDto);
    }

    @DisplayName("Exist Follow user")
    @Test
    void getFollowersUserExistTestInt() throws Exception {
        //Act & Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 4))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The user 1 already follow 4"));
    }
}
