package com.sprint.be_java_hisp_w23_g04.controller;

import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.service.IProductMediaService;
import com.sprint.be_java_hisp_w23_g04.service.ProductMediaServiceImpl;
import com.sprint.be_java_hisp_w23_g04.service.IPostMediaService;
import com.sprint.be_java_hisp_w23_g04.service.PostMediaServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sprint.be_java_hisp_w23_g04.exception.NotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsMeliController {
    private final IPostMediaService postMediaService;
    private final IProductMediaService productMediaService;

    public ProductsMeliController(PostMediaServiceImpl postMediaService,
                                 ProductMediaServiceImpl productMediaService) {
        this.productMediaService = productMediaService;
        this.postMediaService = postMediaService;
    }

    /**
     * US-0005 Saves a new post
     *
     * @param post The post to be saved
     * @return A ResponseEntity containing successfully saving message
     * @throws NotFoundException If the user with de given userId does not exist
     */
    @PostMapping("/post")
    public ResponseEntity<?> savePost(@Valid @RequestBody PostDTO post) {
        return new ResponseEntity<>(postMediaService.savePost(post), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFilteredPost(
            @PathVariable @NotNull @Positive(message = "El id del usuario debe ser mayor a cero") Integer userId,
            @RequestParam(defaultValue = "date_asc") String order) {
        return new ResponseEntity<>(productMediaService.getFilteredPosts(userId, order), HttpStatus.OK);
    }
}
