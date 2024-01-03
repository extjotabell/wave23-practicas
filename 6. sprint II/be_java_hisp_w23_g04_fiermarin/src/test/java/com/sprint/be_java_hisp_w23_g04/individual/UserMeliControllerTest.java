package com.sprint.be_java_hisp_w23_g04.individual;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserMeliControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test for getAllUsers")
    void test01() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(8)));
    }

    @Test
    @DisplayName("US-0001 - Test for followSellerUser")
    void test02() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("El usuario con id:1 ahora sigue a vendedor con id:2"));
    }

    @Test
    @DisplayName("US-0001 - Test for followSellerUser with a user that not exist")
    void test03() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/123/follow/2"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 123."));
    }

    @Test
    @DisplayName("US-0001 - Test for followSellerUser with a seller that not exist")
    void test04() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/123"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 123."));
    }

    @Test
    @DisplayName("US-0001 - Test for followSellerUser with a seller is a same user")
    void test05() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/1"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("El usuario y vendedor con id:1 no pueden ser el mismo."));
    }

    @Test
    @DisplayName("US-0002 - Test for followersCount with a user that not exist")
    void test06() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/123/followers/count"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 123."));
    }

    @Test
    @DisplayName("US-0002 - Test for followersCount with a user that exist")
    void test07() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/count"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }

    @Test
    @DisplayName("US-0003 - Test for followers with user id is cero")
    void test08() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/0/followers/list"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"))
                .andExpect(jsonPath("$.messages", hasItem("El id del usuario debe ser mayor a cero")));
    }

    @Test
    @DisplayName("US-0003 - Test for followers by user id and order by name asc")
    void test09() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[0].user_id").value(6))
                .andExpect(jsonPath("$.followed[0].user_name").value("Diego Lopez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(4))
                .andExpect(jsonPath("$.followed[1].user_name").value("Sofia Gomez"));
    }

    @Test
    @DisplayName("US-0003 - Test for followers by user id and order by name desc")
    void test10() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/list?order=name_dsc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[0].user_id").value(4))
                .andExpect(jsonPath("$.followed[0].user_name").value("Sofia Gomez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(6))
                .andExpect(jsonPath("$.followed[1].user_name").value("Diego Lopez"));
    }

    @Test
    @DisplayName("US-0004 - Test for follow sellers with user id and id seller is cero")
    void test11() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/0/followed/list"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"))
                .andExpect(jsonPath("$.messages", hasItem("El id del usuario debe ser mayor a cero")));
    }

    @Test
    @DisplayName("US-0004 - Test for follow sellers with user is OK and order by name asc")
    void test12() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/4/followed/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[0].user_id").value(1))
                .andExpect(jsonPath("$.followed[0].user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(3))
                .andExpect(jsonPath("$.followed[1].user_name").value("Pablo Gonzalez"));
    }

    @Test
    @DisplayName("US-0004 - Test for follow sellers with user is OK and order by name desc")
    void test13() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/4/followed/list?order=name_dsc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[0].user_id").value(3))
                .andExpect(jsonPath("$.followed[0].user_name").value("Pablo Gonzalez"))
                .andExpect(jsonPath("$.followed[1].user_id").value(1))
                .andExpect(jsonPath("$.followed[1].user_name").value("Juan Perez"));
    }

    @Test
    @DisplayName("Test for unfollow seller by user id and seller id")
    void test14() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/4/unfollow/1"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.description").value("El usuario Juan Perez Id: 1 ya no es seguido por el usuario Sofia Gomez Id: 4"));
    }

    @Test
    @DisplayName("Test for unfollow seller by user id and seller id with user id not exist")
    void test15() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/123/unfollow/2"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 123."));
    }

    @Test
    @DisplayName("Test for unfollow seller by user id and seller id with seller id not exist")
    void test16() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/unfollow/123"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("No se encontró usuario con el id 123."));
    }

    @Test
    @DisplayName("Test for unfollow seller by user id and seller id with user id and seller id is cero")
    void test17() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/0/unfollow/0"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"))
                .andExpect(jsonPath("$.messages", hasItem("El id del usuario debe ser mayor a cero")));
    }


}
