package meli.bootcamp.sprint1.integration;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.NewProductDto;

import static org.hamcrest.Matchers.hasSize;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void us0001() throws Exception {
    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 7,
        1);

    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // Body Part
    ResultMatcher bodyPart = MockMvcResultMatchers.jsonPath("$.message").value("User followed");

    mockMvc.perform(request) // request
        .andExpect(status) // expected status
        .andExpect(contentType) // expected contentType
        .andExpect(bodyPart) // expected body
        .andDo(MockMvcResultHandlers.print()); // print req and resp
  }

  @Test
  void us0002() throws Exception {
    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 7);

    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // Body Part
    ResultMatcher bodyPart = MockMvcResultMatchers.jsonPath("$.followers_count").value(1);

    mockMvc.perform(request) // request
        .andExpect(status) // expected status
        .andExpect(contentType) // expected contentType
        .andExpect(bodyPart) // expected body
        .andDo(MockMvcResultHandlers.print()); // print req and resp
  }

  @Test
  void us0003() throws Exception {
    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", 7);

    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // Body Part
    ResultMatcher bodyPart1 = MockMvcResultMatchers.jsonPath("$.followers").value(hasSize(1));
    ResultMatcher bodyPart2 = MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("Lucas Salerno");

    mockMvc.perform(request) // request
        .andExpect(status) // expected status
        .andExpect(contentType) // expected contentType
        .andExpect(bodyPart1) // expected body 1
        .andExpect(bodyPart2) // expected body 2
        .andDo(MockMvcResultHandlers.print()); // print req and resp
  }

  @Test
  void us0004() throws Exception {
    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1);

    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // Body Part
    ResultMatcher bodyPart1 = MockMvcResultMatchers.jsonPath("$.followed").value(hasSize(3));
    ResultMatcher bodyPart2 = MockMvcResultMatchers.jsonPath("$.followed[1].user_name").value("Fatima Noble");

    mockMvc.perform(request) // request
        .andExpect(status) // expected status
        .andExpect(contentType) // expected contentType
        .andExpect(bodyPart1) // expected body 1
        .andExpect(bodyPart2) // expected body 2
        .andDo(MockMvcResultHandlers.print()); // print req and resp
  }

  @Test
  void us0005() throws Exception {
    NewProductDto newProduct = new NewProductDto(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition");
    NewPostDto newPost = new NewPostDto(7, LocalDate.now(), newProduct, 1, 1500.5);
    ObjectWriter writer = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        .writer();

    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
        .contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(newPost));

    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // // Body Part
    ResultMatcher bodyPart = MockMvcResultMatchers.jsonPath("$.message").value("Post added");

    mockMvc.perform(request) // request
        .andExpect(status) // expected status
        .andExpect(contentType) // expected contentType
        .andExpect(bodyPart) // expected body
        .andDo(MockMvcResultHandlers.print()); // print req and resp
  }

  @Test
  void us0006() throws Exception {
    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1);

    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // // Body Part
    ResultMatcher bodyPart = MockMvcResultMatchers.jsonPath("$.posts").value(hasSize(0));

    mockMvc.perform(request) // request
        .andExpect(status) // expected status
        .andExpect(contentType) // expected contentType
        .andExpect(bodyPart) // expected body
        .andDo(MockMvcResultHandlers.print()); // print req and resp
  }
}