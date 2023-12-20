package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostPromoDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostPromoListDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserPromoCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w23_g2.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Mapper;
import com.mercadolibre.be_java_hisp_w23_g2.utils.TiposCategoria;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Validator;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    private final IUserRepository userRepository;
    private final Validator validator;
    private final Mapper mapper;

    public PostService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.validator = Validator.getInstance();
        this.mapper = Mapper.getInstance();
    }

    /**
     * Adds a new promotion post based on the provided PostPromoDTO.
     *
     * @param postPromoDTO The PostPromoDTO containing promotion post information.
     * @return MessageDTO indicating the success of the operation.
     */
    @Override
    public MessageDTO addPostPromo(PostPromoDTO postPromoDTO) {

        // Check that all parameters have been sent
        if (postPromoDTO.getUserId() == 0 || postPromoDTO.getDate() == null ||
                postPromoDTO.getProduct().getId() == 0 || postPromoDTO.getProduct().getName() == null ||
                postPromoDTO.getProduct().getType() == null || postPromoDTO.getProduct().getBrand() == null ||
                postPromoDTO.getProduct().getColor() == null || postPromoDTO.getProduct().getNotes() == null ||
                postPromoDTO.getCategory() == null || postPromoDTO.getPrice() == 0.0 || !postPromoDTO.isHas_promo() ||
                postPromoDTO.getDiscount() == 0) {
            throw new BadRequestException("The publication promo data entered is not correct.");
        }

        Post post = this.mapper.mapPostPromoDTOToPost(postPromoDTO);

        // Check that the user exists
        User user = userRepository.findUserById(post.getUserId());

        validator.validateUserExistence(user, post.getUserId(), "Current");

        // Check that there is no promotion product with this id
        List<Post> postsUser = user.getPosts();
        Optional<Post> postExist = postsUser.stream()
                .filter(p -> p.getProduct().getId() == post.getProduct().getId() && p.isHas_promo()).findFirst();
        if (postExist.isPresent()) {
            throw new BadRequestException("The product id already exists.");
        }
        // In case of passing the validations, I add the post to the list
        userRepository.addPost(user, post);

        return new MessageDTO("Publication promo successfully added.");
    }

     /**
     * Retrieves the count of products in promotion for a specified user.
     *
     * @param userId The ID of the user.
     * @return UserPromoCountDTO containing the count products in promotion.
     */
    @Override
    public UserPromoCountDTO getPromoCountSeller(int userId) {
        User user = userRepository.findUserById(userId);
        // Check that the user exists
        validator.validateUserExistence(user, userId, "Current");

        return mapper.mapUserPromoCountDTO(user);
    }

    /**
     * Retrieves the count of products in promotion for a specified category.
     *
     * @param category The category of the post.
     * @return PostPromoListDTO containing the list of products in promotion by category.
     */
    @Override
    public PostPromoListDTO getPostsPromoByCategory(String category) {
        List<User> users = userRepository.getAll();
        List<Post> listPromoByCategory = new ArrayList<>();

        // Check category exists
        TiposCategoria[] categorias = TiposCategoria.values();
        if (Arrays.stream(categorias).noneMatch(c -> c.name().equalsIgnoreCase(category))) {
            throw new NotFoundException("Category "  + category + " not found ");
        }

        for (User user : users){
            if (!user.getPosts().isEmpty()){
                for (Post post : user.getPosts()) {
                    if (post.getCategory().equalsIgnoreCase(category) && post.isHas_promo()) {
                        listPromoByCategory.add(post);
                    }
                }
            }
        }

        List<PostPromoDTO> promoDTOList = listPromoByCategory.stream()
                .map(mapper::mapPostToPostPromoDTO)
                .collect(Collectors.toList());

        return new PostPromoListDTO(promoDTOList);
    }
}
