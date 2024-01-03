package com.sprint.be_java_hisp_w23_g04.individualIntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint.be_java_hisp_w23_g04.dto.response.SellerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static com.sprint.be_java_hisp_w23_g04.utils.UtilsTest.getSellerDTO;
import static com.sprint.be_java_hisp_w23_g04.utils.UtilsTest.getSimpleMessageDTOUserNotExist;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserMeliControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @DisplayName("INDIVIDUAL: Integration test getFollowersCount OK")
    void test3() throws Exception {
        Integer userId = 1;
        SellerDTO response = getSellerDTO();
        String responseJson = objectMapper.writeValueAsString(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson))
                .andReturn();
    }

    @Test
    @DisplayName("INDIVIDUAL: Integration test getFollowersCount but user NOT FOUND")
    void test4() throws Exception {
        Integer userId = 99;
        SimpleMessageDTO response = getSimpleMessageDTOUserNotExist();
        String responseJson = objectMapper.writeValueAsString(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson))
                .andReturn();
    }
}
