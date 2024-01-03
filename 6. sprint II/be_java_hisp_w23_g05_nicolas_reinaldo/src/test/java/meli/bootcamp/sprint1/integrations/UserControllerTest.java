package meli.bootcamp.sprint1.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.NewProductDto;
import meli.bootcamp.sprint1.dto.response.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import static meli.bootcamp.sprint1.utils.Factory.*;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test get followers by id successfully")
    void getFollowersByIdTestOk() throws Exception {

        UserWFollowerListDto responseDto = generateUserDtoList("name_asc");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult result = this.mockMvc.perform(get("/users/{id}/followers/list", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("Test get followers count successfully")
    void getFollowersCountTestOk() throws Exception {

        FollowersDto responseDto = new FollowersDto(4,"Geronimo Schmidt", 3);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult result = this.mockMvc.perform(get("/users/{userId}/followers/count", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("Test follow user already followed")
    void followUserTestAlreadyFollowed() throws Exception {

        BaseResponseDto responseDto = new BaseResponseDto("The user is already followed");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult result = this.mockMvc.perform(post("/users/1/follow/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("Test last posts ok")
    void lastPostsTestOk() throws Exception {

        LastPostsDto responseDto = new LastPostsDto(1, Collections.emptyList());

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult result = this.mockMvc.perform(get("/products/followed/{userId}/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("Test followed list ok")
    void followedListTestOk() throws Exception {

        UserWFollowedDto responseDto = generateUserWFollowedDtoList();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult result = this.mockMvc.perform(get("/users/{userId}/followed/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("Test unfollowed list empty")
    void unfollowUserTestListEmpty() throws Exception {

        BaseResponseDto responseDto = new BaseResponseDto("Followed list and following lists are empty");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult result = this.mockMvc.perform(post("/users/7/unfollow/6"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("Test added post ok")
    void newPostTestOk() throws Exception {

        BaseResponseDto responseDto = new BaseResponseDto("Post added");

        NewPostDto payload = generateNewPostDto();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String responseJson = writer.writeValueAsString(responseDto);
        String payloadJson = writer.writeValueAsString(payload);

        MvcResult result = this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
}
