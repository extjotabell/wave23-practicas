package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.PostNoPromoDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.User;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import com.meli.socialmeli.services.impl.ProductServiceImpl;
import com.meli.socialmeli.services.impl.UserServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import util.UserEntityUtilsGenerator;

import java.time.LocalDate;
import java.util.List;

import static com.meli.socialmeli.utilities.Mappers.mapPostUserAndProductPromoNoPromoDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static util.UserEntityUtilsGenerator.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    UserServiceImpl userService;

    @InjectMocks
    ProductServiceImpl productService;

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
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009): " +
            "El tipo de ordenamiento 'date_asc' existe entonces retorna un PostsFromFollowsDTO sin lanzar excepción.")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoValidoDateAscTest(){
        // Arrange
        String order = "date_asc";
        User user = getUserFollwingSellersTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        // Assert
        assertDoesNotThrow(() -> productService.getAllPostsFollowsLastTwoWeeks(id, order));
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009): " +
            "El tipo de ordenamiento existe 'date_desc' entonces retorna un PostsFromFollowsDTO sin lanzar excepción.")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoValidoDateDescTest(){
        // Arrange
        String order = "date_desc";
        User user = getUserFollwingSellersTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        // Assert
        assertDoesNotThrow(() -> productService.getAllPostsFollowsLastTwoWeeks(id, order));
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009): " +
            "El tipo de ordenamiento no existe entonces lanza BadRequestException.")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoInvalidoTest(){
        // Arrange
        String order = "de_mayor_a_menor";
        User user = new User(1,"User", null, null, null);
        Integer id = user.getUser_id();
        // Act - Assert
        assertThrows(
                BadRequestException.class,
                () -> productService.getAllPostsFollowsLastTwoWeeks(id, order)
                );
    }

    @Test
    @DisplayName("T-0006: Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009): " +
            "En este caso el ordenamiento es ascendente")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoAscTest() {
        // Arrange
        String order = "date_asc";
        User user = getUserFollwingSellersOrderingTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        PostsFromFollowsDTO expected = getUserFollwingSellersOrderingAscTest();
        PostsFromFollowsDTO actual = productService.getAllPostsFollowsLastTwoWeeks(id,order);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T-0006: Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009): " +
            "En este caso el ordenamiento es descendente")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoDescTest() {
        // Arrange
        String order = "date_desc";
        User user = getUserFollwingSellersOrderingTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        PostsFromFollowsDTO expected = getUserFollwingSellersOrderingDescTest();
        PostsFromFollowsDTO actual = productService.getAllPostsFollowsLastTwoWeeks(id,order);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T-0008: Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un " +
            "determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)")
    void getAllPostsFollowsLastTwoWeeksAssertLastTwoWeeksTest() {
        // Arrange
        /*
            Se utiliza este método porque en realidad nos sirve para este caso de uso también,
            no veo necesidad de cambiar el nombre.
         */
        User user = getUserFollwingSellersOrderingTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        // No importa que se retorne de manera descendente, lo importante es revisar que existan
        List<PostNoPromoDTO> expected = getUserFollwingSellersOrderingDescTest().getPosts();
        PostNoPromoDTO notExpected =  mapPostUserAndProductPromoNoPromoDTO(
                sellers.get(1).getPosts().get(1),
                sellers.get(1)
        );
        List<PostNoPromoDTO> actual = productService.getAllPostsFollowsLastTwoWeeks(id,null).getPosts();
        // Assert
        Assertions.assertTrue(actual.containsAll(expected));
        Assertions.assertFalse(actual.contains(notExpected));
    }
}
