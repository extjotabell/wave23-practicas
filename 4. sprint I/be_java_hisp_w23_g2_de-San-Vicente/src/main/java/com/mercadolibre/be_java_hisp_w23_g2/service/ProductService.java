package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PromoCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w23_g2.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Mapper;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Validator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
     * @param postRequestDTO The PostDTO containing post information.
     * @return MessageDTO indicating the success of the operation.
     */
    private MessageDTO addPost(PostDTO postRequestDTO) {
        // Check that all parameters have been sent
        if (postRequestDTO.getUserId() == 0 || postRequestDTO.getDate() == null ||
            postRequestDTO.getProduct().getId() == 0 || postRequestDTO.getProduct().getName() == null ||
            postRequestDTO.getProduct().getType() == null || postRequestDTO.getProduct().getBrand() == null ||
            postRequestDTO.getProduct().getColor() == null || postRequestDTO.getProduct().getNotes() == null ||
            postRequestDTO.getCategory() == null || postRequestDTO.getPrice() == 0.0) {
            throw new BadRequestException("The publication data entered is not correct.");
        }

        Post post = this.mapper.mapPostDTOToPost(postRequestDTO);

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
    public MessageDTO addNormalPost(PostDTO postRequestDTO) {
        return addPost(postRequestDTO);
    }

    @Override
    public MessageDTO addPromoPost(PostDTO postRequestDTO) {
        validator.validatePromoPost(postRequestDTO);
        return addPost(postRequestDTO);
    }

    @Override
    public PromoCountDTO getPromoCount(int userId){
        User user = userRepository.findUserById(userId);
        validator.validateUserExistence(user, userId, "Current");
        int count = (int)user.getPosts().stream().filter(Post::isHasPromo).count();

        return new PromoCountDTO(""+user.getId(), user.getUserName(), count);
    }

    @Override
    public PostFollowedDTO getFilteredPosts(int userId, LocalDate minDate, LocalDate maxDate, Double minPrice, Double maxPrice, String name, String brand) {
        User user = userRepository.findUserById(userId);
        validator.validateUserExistence(user, userId, "Current");
        List<Post> posts = user.getFollowed().stream().map(User::getPosts).flatMap(List::stream).toList();

        if(minDate != null){
            System.out.println("Filtro de minDate encontrado!");
            posts = posts.stream().filter(post -> post.getDate().isAfter(minDate)).toList();
        }
        if(maxDate != null){
            System.out.println("Filtro de maxDate encontrado!");
            posts = posts.stream().filter(post -> post.getDate().isBefore(maxDate)).toList();
        }
        if(minPrice != null){
            System.out.println("Filtro de minPrice encontrado!");
            posts = posts.stream().filter(post -> post.getPrice() >= minPrice).toList();
        }
        if(maxPrice != null){
            System.out.println("Filtro de maxPrice encontrado!");
            posts = posts.stream().filter(post -> post.getPrice() <= maxPrice).toList();
        }
        if(name != null){
            System.out.println("Filtro de name encontrado!");
            posts = posts.stream().filter(post -> post.getProduct().getName().toLowerCase().contains(name.toLowerCase())).toList();
        }
        if(brand != null){
            System.out.println("Filtro de brand encontrado!");
            posts = posts.stream().filter(post -> post.getProduct().getBrand().toLowerCase().contains(brand.toLowerCase())).toList();
        }

        if(posts.isEmpty()){
            throw new NotFoundException("There's not product that suits those filters");
        }

        return new PostFollowedDTO(userId, posts.stream().map(mapper::mapPostToPostDTO).toList());
    }
}
