package meli.bootcamp.sprint1.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.response.LastPostsDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static meli.bootcamp.sprint1.utils.Factory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Test adding a new post")
    void newPostTest() throws Exception {

        NewPostDto payloadNewPostDto = generateNewPostDto();

        ObjectWriter writer = new ObjectMapper().
                registerModule(new JavaTimeModule()).
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadNewPostDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Post added"));
    }

    @Test
    @DisplayName("Add Post with Non-Existent Category Should Throw BadRequestException")
    void addPostWithNonExistentCategoryShouldThrowBadRequestException() throws Exception {
        NewPostDto payloadNewPostDto = generateNewPostDtoCategoryNotFound();

        ObjectWriter writer = new ObjectMapper().
                registerModule(new JavaTimeModule()).
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadNewPostDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Category not found"));
    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    @Test
    @DisplayName("Get Followers Count Test")
    void getFollowersTest() throws Exception {
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(4))
                        .andReturn();
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

    @Test
    @DisplayName("Follow User Test")
    void followUserTest() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 5, 1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User followed"))
                        .andReturn();
    }

    @Test
    @DisplayName("Follow User - Already Followed")
    void alreadyfollowUserTest() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The user is already followed"))
                        .andReturn();
    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    @Test
    @DisplayName("Get Followers List Test")
    void getFollowersByIdTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}/followers/list", 1)
                        .param("order", "name_desc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Ailen Pereira"))
                .andExpect(jsonPath("$.followers[0].user_id").value(6))
                .andExpect(jsonPath("$.followers[0].user_name").value("Martin Marquez"))
                .andExpect(jsonPath("$.followers[1].user_id").value(4))
                .andExpect(jsonPath("$.followers[1].user_name").value("Geronimo Schmidt"))
                .andExpect(jsonPath("$.followers[2].user_id").value(3))
                .andExpect(jsonPath("$.followers[2].user_name").value("Fatima Noble"))
                .andExpect(jsonPath("$.followers[3].user_id").value(2))
                .andExpect(jsonPath("$.followers[3].user_name").value("Brenda Torrico"))
                .andReturn();
    }

    @Test
    @DisplayName("Get Followed List Test")
    void followedListTest() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$.followed[0].user_id").value(2))
                        .andExpect(jsonPath("$.followed[0].user_name").value("Brenda Torrico"))
                        .andReturn();
    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    @Test
    @DisplayName("Unfollow User Successfully")
    public void testUnfollowUser() throws Exception {
        // Simula una solicitud POST a /users/1/unfollow/2
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 4))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User 4 was unfollowed"))
                .andReturn();

    }

    @Test
    @DisplayName("Unfollow User with Empty Lists Should Throw BadRequestException")
    void unfollowUserEmptyListsShouldThrowBadRequestException() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 7, 8))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Followed list and following lists are empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Unfollow User That Was Not Followed Should Return Error Message")
    void unfollowUserNotFollowedShouldReturnErrorMessage() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 5, 8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Error unfollowing user, user 5 doesn't follow user 8"))
                .andReturn();
    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    private void addNewPost(NewPostDto newPostDto) throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(newPostDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Post added"));
    }

    @Test
    @DisplayName("Test getting last posts for a user")
    void getLastPostsTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        // Agrega un nuevo post para el usuario
        NewPostDto newPostDto = generateNewPostDto();
        //Reutilizo el metodo para crear un post
        addNewPost(newPostDto);

        //Agrega un post antiguo
        NewPostDto newPostDtooreThanTwoWeeksAgo = generateNewPostDtoMoreThanTwoWeeksAgo();
        addNewPost(newPostDtooreThanTwoWeeksAgo);

        // Obtiene los últimos posts para el usuario
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 6)
                        .param("order", "date_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.posts[0].user_id").value(1))
                .andExpect(jsonPath("$.posts[0].post_id").value(1))
                .andExpect(jsonPath("$.posts[0].date").value("01-01-2024"))
                .andExpect(jsonPath("$.posts[0].product.product_id").value(1))
                .andExpect(jsonPath("$.posts[0].product.product_name").value("Tele"))
                .andExpect(jsonPath("$.posts[0].product.type").value("Gamer"))
                .andExpect(jsonPath("$.posts[0].product.brand").value("Razer"))
                .andExpect(jsonPath("$.posts[0].product.color").value("Red Black"))
                .andExpect(jsonPath("$.posts[0].product.notes").value("Special Edition"))
                .andExpect(jsonPath("$.posts[0].category").value(1))
                .andExpect(jsonPath("$.posts[0].price").value(100.0))
                .andReturn();

        String responseJson = result.getResponse().getContentAsString();
        LastPostsDto lastPostsDto = objectMapper.readValue(responseJson, LastPostsDto.class);

        assertFalse(lastPostsDto.getPosts().isEmpty());

        //No tiene en cuenta el post de hace mas de dos semanas
        assertEquals(1, lastPostsDto.getPosts().size());

    }





}
