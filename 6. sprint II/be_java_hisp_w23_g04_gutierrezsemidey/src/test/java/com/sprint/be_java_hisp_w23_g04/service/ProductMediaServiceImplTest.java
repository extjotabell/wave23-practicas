package com.sprint.be_java_hisp_w23_g04.service;

import com.sprint.be_java_hisp_w23_g04.dto.response.PostListDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.PostResponseDTO;
import com.sprint.be_java_hisp_w23_g04.entity.Post;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import com.sprint.be_java_hisp_w23_g04.exception.BadRequestException;
import com.sprint.be_java_hisp_w23_g04.gateway.PostGatewayImpl;
import com.sprint.be_java_hisp_w23_g04.gateway.ProductGatewayImpl;
import com.sprint.be_java_hisp_w23_g04.gateway.UserGatewayImpl;
import com.sprint.be_java_hisp_w23_g04.utils.UtilsTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductMediaServiceImplTest {
    @Mock
    ProductGatewayImpl productGateway;

    @Mock
    UserGatewayImpl userGateway;

    @Mock
    PostGatewayImpl postGateway;

    @InjectMocks
    ProductMediaServiceImpl productService;

    private static MockedStatic<LocalDate> localDateNowMock;

    @BeforeAll
    public static void init() {
        localDateNowMock = mockStatic(
                LocalDate.class,
                Mockito.CALLS_REAL_METHODS
        );
        LocalDate time = LocalDate.of(2023, 12, 28);
        localDateNowMock.when(LocalDate::now).thenReturn(time);
    }

    @AfterAll
    public static void close() {
        localDateNowMock.close();
    }

    @Test
    @DisplayName("T-0005: Should return BadRequestException because the date sorting type not exists")
    public void getFilteredPostsOrderByDateWithIncorrectSorting() {
        int userId = 99;
        String order = "test";

        Assertions.assertThrows(BadRequestException.class,
                () -> productService.getFilteredPosts(userId, order));
    }

    @Test
    @DisplayName("T-0006: Should return published posts in the last 2 weeks of the sellers followed by the given user ordered by date ASC.")
    public void getFilteredPostsOrderByDateAsc(){
        int userId = 99;
        String order = "date_asc";
        User userTest = UtilsTest.getUserTest(99);
        List<User> sellers = UtilsTest.getSellers();
        List<Post> postsSellerId2 = UtilsTest.generatePostListBySeller(2);
        List<Post> postsSellerId3 = UtilsTest.generatePostListBySeller(3);
        PostListDTO expectedResponse = UtilsTest.generateExpectedResponse(userId,order);

        when(userGateway.findUser(userId)).thenReturn(userTest);
        when(userGateway.getByIds(any())).thenReturn(sellers);
        when(postGateway.getByIds(UtilsTest.getPostListBySeller(2))).thenReturn(postsSellerId2);
        when(postGateway.getByIds(UtilsTest.getPostListBySeller(3))).thenReturn(postsSellerId3);
        when(productGateway.getById(1)).thenReturn(UtilsTest.getProductTest());

        PostListDTO actualResponse = productService.getFilteredPosts(userId,order);

        Assertions.assertEquals(expectedResponse,actualResponse);
    }

    @Test
    @DisplayName("T-0006: Should return published posts in the last 2 weeks of the sellers followed by the given user ordered by date DESC.")
    public void getFilteredPostsOrderByDateDesc(){
        int userId = 99;
        String order = "date_desc";
        User userTest = UtilsTest.getUserTest(99);
        List<User> sellers = UtilsTest.getSellers();
        List<Post> postsSellerId2 = UtilsTest.generatePostListBySeller(2);
        List<Post> postsSellerId3 = UtilsTest.generatePostListBySeller(3);
        PostListDTO expectedResponse = UtilsTest.generateExpectedResponse(userId,order);

        when(userGateway.findUser(userId)).thenReturn(userTest);
        when(userGateway.getByIds(any())).thenReturn(sellers);
        when(postGateway.getByIds(UtilsTest.getPostListBySeller(2))).thenReturn(postsSellerId2);
        when(postGateway.getByIds(UtilsTest.getPostListBySeller(3))).thenReturn(postsSellerId3);
        when(productGateway.getById(1)).thenReturn(UtilsTest.getProductTest());

        PostListDTO actualResponse = productService.getFilteredPosts(userId,order);

        Assertions.assertEquals(expectedResponse,actualResponse);
    }

    @Test
    @DisplayName("T-0008: Should return published posts in the last 2 weeks of the sellers followed by the given user.")
    public void getFilteredPostsVerifyDate(){
        int userId = 99;
        String order = "date_asc";
        User userTest = UtilsTest.getUserTest(99);
        List<User> sellers = UtilsTest.getSellers();
        List<Post> postsSellerId2 = UtilsTest.generatePostListBySeller(2);
        List<Post> postsSellerId3 = UtilsTest.generatePostListBySeller(3);
        PostListDTO expectedResponse = UtilsTest.generateExpectedResponse(userId,order);
        PostResponseDTO excludedPost = UtilsTest.getExcludedPost();

        when(userGateway.findUser(userId)).thenReturn(userTest);
        when(userGateway.getByIds(any())).thenReturn(sellers);
        when(postGateway.getByIds(UtilsTest.getPostListBySeller(2))).thenReturn(postsSellerId2);
        when(postGateway.getByIds(UtilsTest.getPostListBySeller(3))).thenReturn(postsSellerId3);
        when(productGateway.getById(1)).thenReturn(UtilsTest.getProductTest());

        PostListDTO actualResponse = productService.getFilteredPosts(userId,order);

        //Count post older than 2 weeks. Should be 0
        Long olderThan2weeks = actualResponse.getPosts().stream().filter(post -> post.getDate().isBefore(LocalDate.now().minusWeeks(2))).count();

        Assertions.assertEquals(0,olderThan2weeks);
        Assertions.assertEquals(expectedResponse,actualResponse);
        Assertions.assertNull(actualResponse.getPosts().stream().filter(p -> p.getPostId() == excludedPost.getPostId()).findFirst().orElse(null));
    }

}
