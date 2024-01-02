package meli.bootcamp.sprint1.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.dto.response.FollowersDto;
import meli.bootcamp.sprint1.dto.response.UserWFollowerListDto;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static meli.bootcamp.sprint1.utils.Factory.generateUserDtoList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestUserController {

    @Autowired
    private MockMvc mockMvc;

    private GeneralRepository repository = new GeneralRepository();

    private ObjectWriter objectWriter = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    private FollowersDto followers;
    private BaseResponseDto responseDto;
    private UserWFollowerListDto user = generateUserDtoList("name_asc");

    @Test
    void testGetFollowers_Ok() throws Exception{
        followers = new FollowersDto(user.getUser_id(), user.getUser_name(), user.getFollowers().size());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 4);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(), objectWriter.writeValueAsString(followers));
    }

    @Test
    void testGetFollowers_ThrowsBadRequestException() throws Exception{
        responseDto = new BaseResponseDto("User not found");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 999);

        ResultMatcher statusExpected = MockMvcResultMatchers.status()
                .isBadRequest();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content()
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(), objectWriter.writeValueAsString(responseDto));
    }

}
