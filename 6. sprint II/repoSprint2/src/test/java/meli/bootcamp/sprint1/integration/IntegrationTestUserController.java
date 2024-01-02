package meli.bootcamp.sprint1.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.response.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static meli.bootcamp.sprint1.utils.Factory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestUserController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private FollowersDto followers;
    private BaseResponseDto responseDto;
    private UserWFollowerListDto user = generateUserDtoList("name_asc");
    private LastPostsDto lastPostsDto;
    private MockHttpServletRequestBuilder request;
    private MvcResult result;

    private ObjectWriter objectWriter = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    @DisplayName("Endpoint - GetFollowers -> OK")
    void testGetFollowers_Ok() throws Exception{
        followers = new FollowersDto(user.getUser_id(), user.getUser_name(), user.getFollowers().size());

        request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 4);

        result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(objectWriter.writeValueAsString(followers), result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Endpoint - GetFollowers -> Exception")
    void testGetFollowers_ThrowsBadRequestException() throws Exception{
        responseDto = new BaseResponseDto("User not found");

        request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 999);

        result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(objectWriter.writeValueAsString(responseDto), result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Endpoint - LastPost -> OK")
    void testGetLastPost_WithOrder_Ok() throws Exception{
        String order = "date_asc";
        lastPostsDto = generateLastPostDtoOrdered(order);
        /*
        List<PostDto> posts = new ArrayList<>(lastPostsDto.getPosts());
        posts.stream()
                .forEach(postDto -> service.addPost(objectMapper.convertValue(postDto, NewPostDto.class)));
        */

        request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2)
                .param("order", order);

        result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(objectWriter.writeValueAsString(lastPostsDto), result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Endpoint - LastPost -> Exception")
    void testGetLastPost_WithOrder_ThrowsBadRequestException() throws Exception{
        String order = "wrong_param";
        responseDto = new BaseResponseDto("Parameter '" + order + "' is not valid");

        request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2)
                .param("order", order);

        result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(objectWriter.writeValueAsString(responseDto), result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Endpoint - AddPost -> OK")
    void testAddPost_OK() throws Exception{
        responseDto = new BaseResponseDto("Post added");
        NewPostDto newPostDto = generateNewPost(1, 1);

        request = MockMvcRequestBuilders.post("/products/post")
                .content(objectWriter.writeValueAsString(newPostDto))
                .contentType(MediaType.APPLICATION_JSON);

        result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(objectWriter.writeValueAsString(responseDto), result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Endpoint - AddPost -> Exception: User Not Found")
    void testAddPost_ThrowsBadRequestException_UserNotFound() throws Exception{
        responseDto = new BaseResponseDto("User not found");
        NewPostDto newPostDto = generateNewPost(999,1);

        request = MockMvcRequestBuilders.post("/products/post")
                .content(objectWriter.writeValueAsString(newPostDto))
                .contentType(MediaType.APPLICATION_JSON);

        result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(objectWriter.writeValueAsString(responseDto), result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Endpoint - AddPost -> Exception: User Not Found")
    void testAddPost_ThrowsBadRequestException_CategoryNotFound() throws Exception{
        responseDto = new BaseResponseDto("Category not found");
        NewPostDto newPostDto = generateNewPost(1,999);

        request = MockMvcRequestBuilders.post("/products/post")
                .content(objectWriter.writeValueAsString(newPostDto))
                .contentType(MediaType.APPLICATION_JSON);

        result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(objectWriter.writeValueAsString(responseDto), result.getResponse().getContentAsString());
    }

}
