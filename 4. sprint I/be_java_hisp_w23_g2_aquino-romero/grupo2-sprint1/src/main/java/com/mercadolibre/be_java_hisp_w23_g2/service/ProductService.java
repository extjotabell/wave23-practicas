package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostPromoDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PromoProductCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Mapper;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Validator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

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
        this.validator.validatePost(postDTO);

        Post post = this.mapper.mapPostDTOToPost(postDTO);

        // Check that the user exists
        User user = userRepository.findUserById(post.getUserId());
        validator.validateUserExistence(user, post.getUserId(), "Current");

        // Check that there is no product with this id
        this.validator.validatePostExistence(user.getPosts(), post);

        // In case of passing the validations, I add the post to the list
        userRepository.addPost(user, post);

        return new MessageDTO("Publication successfully added.");
    }

    /**
     * Adds a new promotional post based on the provided PostPromoDTO.
     *
     * @param postPromoDTO The PostPromoDTO containing information about the promotional post to be added.
     * @return MessageDTO indicating the success of the addPostPromo operation.
     */
    @Override
    public MessageDTO addPostPromo(PostPromoDTO postPromoDTO) {
        this.validator.validatePostPromo(postPromoDTO);

        Post postPromo = this.mapper.mapPostPromoDTOToPostPromo(postPromoDTO);

        User user = userRepository.findUserById(postPromo.getUserId());
        this.validator.validateUserExistence(user, postPromo.getUserId(), "Current");

        this.validator.validatePostExistence(user.getPosts(), postPromo);
        // In case of passing the validations, I add the post to the list
        userRepository.addPost(user, postPromo);

        return new MessageDTO("Publication successfully added.");
    }

    /**
     * Retrieves the count of promotional products for a specified user.
     *
     * @param userId The ID of the user.
     * @return PromoProductCountDTO containing the count of promotional products.
     */
    @Override
    public PromoProductCountDTO getPromoProductCountByUser(int userId) {
        User user = userRepository.findUserById(userId);
        validator.validateUserExistence(user, userId, "Seller");

        int promoProductCount = (int) user.getPosts().stream()
                .filter(Post::isPromo)
                .count();
        validator.validatePromoProductCount(promoProductCount);

        return new PromoProductCountDTO(userId, user.getUserName(), promoProductCount);
    }

    /**
     * Retrieves posts based on a keyword in the category.
     *
     * @param keyword The keyword to search for in post category's.
     * @return List of posts matching the keyword or all posts if the keyword is empty.
     */
    @Override
    public List<PostPromoDTO> searchPostsByCategory(String keyword) {
        List<Post> allPosts = userRepository.getAllPosts();
        validator.validateKeyword(keyword);

        List<Post> matchingPosts = allPosts.stream()
                .filter(post -> post.getCategory().toLowerCase().contains(keyword.trim().toLowerCase()))
                .toList();

        return matchingPosts.stream().map(mapper::mapPostPromoToPostPromoDTO).toList();
    }


}
