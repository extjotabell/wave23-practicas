package com.sprint.be_java_hisp_w23_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static com.sprint.be_java_hisp_w23_g04.utils.UtilsTest.getPostDTO;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductsMeliControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("US-0005 - Saves a new post")
    void test01() throws Exception {
        PostDTO post = getPostDTO();

        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("El post para el user: "+ post.getUserId() +" se guardó exitosamente"));
    }

    @Test
    @DisplayName("US-0005 - Saves a new post with a user that not exist")
    void test02() throws Exception {
        PostDTO post = getPostDTO();
        post.setUserId(123);

        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id "+ post.getUserId() + "."));
    }

    @Test
    @DisplayName("US-0005 - Saves a new post but the post is empty BAD REQUEST")
    void test03() throws Exception {
        PostDTO post = new PostDTO();

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"))
                .andExpect(jsonPath("$.messages", hasItem("La categoría del post no puede estar vacía")))
                .andExpect(jsonPath("$.messages", hasItem("El precio no puede estar vacío")))
                .andExpect(jsonPath("$.messages", hasItem("El id del usuario no puede estar vacío")))
                .andExpect(jsonPath("$.messages", hasItem("La fecha no puede estar vacía")));
    }

    @Test
    @DisplayName("US-0006 - Returns all posts from a user that not have posts")
    void test04() throws Exception {
        mockMvc.perform(get("/products/followed/2/list"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("El usuario indicado actualmente no sigue a ningún vendedor"));
    }

    @Test
    @DisplayName("US-0006 - Returns all posts from a user")
    void test05() throws Exception {
        mockMvc.perform(get("/products/followed/4/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts", hasSize(3)))
                .andExpect(jsonPath("$.posts[0].user_id").value(3))
                .andExpect(jsonPath("$.posts[0].post_id").value(4))
                .andExpect(jsonPath("$.posts[0].date").value("23-12-2023"))
                .andExpect(jsonPath("$.posts[0].category").value(58))
                .andExpect(jsonPath("$.posts[0].price").value(800.00))
                .andExpect(jsonPath("$.posts[0].product.product_id").value(2))
                .andExpect(jsonPath("$.posts[0].product.product_name").value("Teclado"));
    }

    @Test
    @DisplayName("US-0006 - Returns all posts from a user that not exist")
    void test06() throws Exception {
        mockMvc.perform(get("/products/followed/123/list"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 123."));
    }
}
