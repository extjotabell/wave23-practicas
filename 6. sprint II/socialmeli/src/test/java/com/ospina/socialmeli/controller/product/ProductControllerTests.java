package com.ospina.socialmeli.controller.product;

import com.ospina.socialmeli.controller.ProductController;
import com.ospina.socialmeli.dto.request.PostRequestDTO;
import com.ospina.socialmeli.dto.response.FollowedPostsListDTO;
import com.ospina.socialmeli.dto.response.PostResponseDTO;
import com.ospina.socialmeli.exception.exceptions.AlreadyExistsException;
import com.ospina.socialmeli.exception.exceptions.NotFoundException;
import com.ospina.socialmeli.service.product.ProductService;
import com.ospina.socialmeli.util.FollowedPostsListDTOTestDataBuilder;
import com.ospina.socialmeli.util.PostRequestDTOTestDataBuilder;
import com.ospina.socialmeli.util.PostResponseDTOTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTests {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController controller;

    @Test
    void followedPostsList_ReturnsCorrectResponseWithValidOrder() {
        Long userId = 1L;
        String order = "DATE_ASC";
        FollowedPostsListDTO followedPostsListDTO = new FollowedPostsListDTOTestDataBuilder().followedPostsListDTOWithPosts().build();
        when(productService.followedPostsList(userId, order)).thenReturn(followedPostsListDTO);

        ResponseEntity<?> response = controller.followedPostsList(userId, order);

        assertEquals(ResponseEntity.ok().body(followedPostsListDTO), response);
        verify(productService, times(1)).followedPostsList(userId, order);
    }

    @Test
    void followedPostsList_ReturnsCorrectResponseWithNullOrder() {
        Long userId = 1L;
        FollowedPostsListDTO followedPostsListDTO = new FollowedPostsListDTOTestDataBuilder().followedPostsListDTOWithPosts().build();
        when(productService.followedPostsList(userId, null)).thenReturn(followedPostsListDTO);

        ResponseEntity<?> response = controller.followedPostsList(userId, null);

        assertEquals(ResponseEntity.ok().body(followedPostsListDTO), response);
        verify(productService, times(1)).followedPostsList(userId, null);
    }

    @Test
    void followedPostsList_ThrowsExceptionWithInvalidOrder() {
        Long userId = 1L;
        String order = "INVALID_ORDER";
        when(productService.followedPostsList(userId, order)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> controller.followedPostsList(userId, order));
        verify(productService, times(1)).followedPostsList(userId, order);
    }

    @Test
    void postProduct_sholudReturnCorrectResponse() {
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder().postRequestDTOByDefault().build();
        PostResponseDTO postResponseDTO = new PostResponseDTOTestDataBuilder().postResponseDTOByDefault().build();
        when(productService.postProduct(postRequestDTO)).thenReturn(postResponseDTO);

        ResponseEntity<PostResponseDTO> response = controller.postProduct(postRequestDTO);

        assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(postResponseDTO), response);
    }

    @Test
    void postProduct_shouldThrowNotFoundExceptionWhenUserDoesNotExist() {
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder().postRequestDTOByDefault().build();
        when(productService.postProduct(postRequestDTO)).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> controller.postProduct(postRequestDTO));
    }

    @Test
    void postProduct_shouldThrowAlreadyExistsExceptionWhenProductAlreadyExists() {
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder().postRequestDTOByDefault().build();
        when(productService.postProduct(postRequestDTO)).thenThrow(AlreadyExistsException.class);

        assertThrows(AlreadyExistsException.class, () -> controller.postProduct(postRequestDTO));
    }
}
