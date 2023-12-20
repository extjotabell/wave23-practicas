package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PromoProductCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w23_g2.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w23_g2.utils.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for handling product-related operations.
 */
@Service
public class ProductService implements IProductService {
    private final IUserRepository userRepository;
    private final Validator validator;
    private final Mapper mapper;

    public ProductService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.validator = Validator.getInstance();
        this.mapper = Mapper.getInstance();
    }

    /**
     * Adds a new post based on the provided PostDTO.
     *
     * @param postDTO The PostDTO containing post information.
     * @return MessageDTO indicating the success of the operation.
     */
    @Override
    public MessageDTO addPost(PostDTO postDTO) {
        // Check that all parameters have been sent
        if (postDTO.getUserId() == 0 || postDTO.getDate() == null ||
            postDTO.getProduct().getId() == 0 || postDTO.getProduct().getName() == null ||
            postDTO.getProduct().getType() == null || postDTO.getProduct().getBrand() == null ||
            postDTO.getProduct().getColor() == null || postDTO.getProduct().getNotes() == null ||
            postDTO.getCategory() == null || postDTO.getPrice() == 0.0 || postDTO.getDiscount() > 1 || postDTO.getDiscount() < 0) {
            throw new BadRequestException("The publication data entered is not correct.");
        }

        Post post = this.mapper.mapPostDTOToPost(postDTO);

        // Check that the user exists
        User user = userRepository.findUserById(post.getUserId());

        validator.validateUserExistence(user, post.getUserId(), "Current");

        // Check that there is no product with this id
        List<Post> postsUser = user.getPosts();
        Optional<Post> postExist = postsUser.stream()
                                    .filter(p -> p.getProduct().getId() == post.getProduct().getId()).findFirst();
        if (postExist.isPresent()) {
            throw new BadRequestException("The product id already exists.");
        }

        // In case of passing the validations, I add the post to the list
        userRepository.addPost(user, post);

        return new MessageDTO("Publication successfully added.");
    }

    @Override
    public PromoProductCountDTO countPromoProduct(int user_id) {

        User user = userRepository.findUserById(user_id);

        validator.validateUserExistence(user, user_id, "Current");

        UserDTO userDTO = mapper.mapUserDTO(user);

        int count = userRepository.countPromoProduct(user_id);

        if (count == 0){
            throw new BadRequestException("This user has not created promo post yet");
        }

        return new PromoProductCountDTO(userDTO.getId(),userDTO.getUserName(),count);
    }

    @Override
    public List<PostDTO> filterPriceProdutc(double min, double max) {
        List<Post> posts = userRepository.filterPriceProduct(min,max);

        if (posts.isEmpty()){
            throw new NotFoundException("Products between "+min+" "+max+" not found");
        }

        List<PostDTO> postDTOS = new ArrayList<>();

        for (Post aux: posts
             ) {
            postDTOS.add(mapper.mapPostToPostDTO(aux));
        }

        return postDTOS;
    }

}
