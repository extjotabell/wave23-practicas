package com.mercadolibre.be_java_hisp_w23_g2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.PostsFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.utils.ObjectCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    ObjectMapper mapper = new ObjectMapper();

    @DisplayName("Add Post OK")
    @Test
    void addPostTestInt() throws Exception {
        // Arrange
        PostDTO postDto = ObjectCreator.createPostDTO();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products/post")
                .content(writer.writeValueAsString(postDto))
                .contentType(MediaType.APPLICATION_JSON);

        //Act & Assert
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Publication successfully added."));
    }

    @DisplayName("Add Post Exist")
    @Test
    void addPostExistTestInt() throws Exception {
        // Arrange
        PostDTO postDto = ObjectCreator.createPostDTOExists();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products/post")
                .content(writer.writeValueAsString(postDto))
                .contentType(MediaType.APPLICATION_JSON);

        //Act & Assert
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The product id already exists."));
    }

    @DisplayName("List Post")
    @Test
    void getPostsByFollowedUsersTestInt() throws Exception {
        // Arrange
        PostsFollowedDTO postsFollowedDTO = new PostsFollowedDTO(1, List.of());

        //Act
        MvcResult mvcResult = mockMvc.perform(get("/products/followed/{userId}/list", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        PostsFollowedDTO resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(), PostsFollowedDTO.class);

        //Assert
        assertEquals(postsFollowedDTO, resultDto);
    }
}
