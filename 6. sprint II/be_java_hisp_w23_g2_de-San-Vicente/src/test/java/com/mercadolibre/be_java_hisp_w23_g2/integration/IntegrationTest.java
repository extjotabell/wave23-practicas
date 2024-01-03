package com.mercadolibre.be_java_hisp_w23_g2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.ErrorDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    void addPost() throws Exception{
        PostDTO payload = new PostDTO(
            1,
            LocalDate.now(),
            new ProductBasicDTO(302, "Mi producto", "Tipo", "Gucci", "Rojo", "No hay notas"),
            101,
            1000.0
        );
        MockHttpServletRequestBuilder req = post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payload));

        MessageDTO expectedResult = new MessageDTO("Publication successfully added.");
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }
    @Test
    void addInvalidPost() throws Exception{
        PostDTO payload = new PostDTO(
                1,
                LocalDate.now(),
                new ProductBasicDTO(302, "Mi producto", "Tipo", "Gucci", "&%$", "No hay notas"),
                101,
                1000.0
        );
        MockHttpServletRequestBuilder req = post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payload));

        ErrorDTO expectedResult = new ErrorDTO(
                "Se encontraron errores de validación",
                List.of(
                        "El color no puede poseer caracteres especiales"
                )
        );
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }

    @Test
    void getFollowedUser() throws Exception{
        MockHttpServletRequestBuilder req = get("/users/1/followed/list");

        UserFollowedDTO expectedResult = new UserFollowedDTO(
                1,
                "John Doe",
                List.of(
                        new UserBasicDTO(4, "Eve Wilson"),
                        new UserBasicDTO(5, "Charlie Brown")
                )
        );

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }

    @Test
    void getAll() throws Exception {
        MockHttpServletRequestBuilder req = get("/users/all");

        List<UserBasicDTO> expectedResult = List.of(
                new UserBasicDTO(1, "John Doe"),
                new UserBasicDTO(2, "Alice Smith"),
                new UserBasicDTO(3, "Bob Jones"),
                new UserBasicDTO(4, "Eve Wilson"),
                new UserBasicDTO(5, "Charlie Brown"),
                new UserBasicDTO(6, "Emma Green"),
                new UserBasicDTO(7, "Olivia White"),
                new UserBasicDTO(8, "Liam Black"),
                new UserBasicDTO(9, "Ava Baker"),
                new UserBasicDTO(10, "Noah Miller"),
                new UserBasicDTO(11, "Sophia Taylor"),
                new UserBasicDTO(12, "Oliver Cook"),
                new UserBasicDTO(13, "Scarlett Bell"),
                new UserBasicDTO(14, "Lucas King"),
                new UserBasicDTO(15, "Mia Wright")
        );

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }

    @Test
    void followUser() throws Exception {
        MockHttpServletRequestBuilder req = post("/users/1/follow/6");

        UserFollowedDTO expectedResult = new UserFollowedDTO(
                1,
                "John Doe",
                List.of(
                        new UserBasicDTO(4, "Eve Wilson"),
                        new UserBasicDTO(5, "Charlie Brown"),
                        new UserBasicDTO(6, "Emma Green")
                )
        );

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }
    @Test
    void unfollowUser() throws Exception {
        MockHttpServletRequestBuilder req = post("/users/1/unfollow/6");

        MessageDTO expectedResult = new MessageDTO("The current user does not follow the user to unfollow.");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isConflict();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }
}
