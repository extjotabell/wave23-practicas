package com.meli.socialmeli.services.impl;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.request.PromoPostDTO;
import com.meli.socialmeli.dtos.response.*;
import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.User;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import com.meli.socialmeli.exceptions.custom.NotFoundException;
import com.meli.socialmeli.repositories.IProductRepository;
import com.meli.socialmeli.repositories.IUserRepository;
import com.meli.socialmeli.repositories.impl.ProductRepositoryImpl;
import com.meli.socialmeli.services.IProductService;
import com.meli.socialmeli.services.IUserService;
import com.meli.socialmeli.utilities.Mappers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final IUserRepository userRepository ;
    private final IUserService userService;

    public ProductServiceImpl(ProductRepositoryImpl productRepository, IUserRepository userRepository, UserServiceImpl userService) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    private List<PostNoPromoDTO> getAllPostFollowsLastTwoWeeks(Integer userId) {
        List<User> follows = userService.findFollowsByIdProductService(userId);
        if (follows == null || follows.isEmpty()) throw new NotFoundException("The user with id: " + userId + " does not follow anyone");

        List<PostNoPromoDTO> postNoPromoDTOList = new ArrayList<>();

        follows.forEach(f -> {
            f.getPosts().forEach(post -> {
                if(!post.isHas_promo()){
                    postNoPromoDTOList.add(new PostNoPromoDTO(
                            f.getUser_id(),
                            post.getPost_id(),
                            post.getDate().toString(),
                            new ProductDTO(
                                    post.getProduct().getProduct_id(),
                                    post.getProduct().getProduct_name(),
                                    post.getProduct().getType(),
                                    post.getProduct().getBrand(),
                                    post.getProduct().getColor(),
                                    post.getProduct().getNotes()
                            ),
                            post.getCategory(),
                            post.getPrice()
                    ));
                }
            });
        });
        return postNoPromoDTOList;
    }
    @Override
    public PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Integer userId, String order) {
        Stream<PostNoPromoDTO> temp = this.getAllPostFollowsLastTwoWeeks(userId).stream();

        Comparator<PostNoPromoDTO> comparator = Comparator.comparing(PostNoPromoDTO::getDate);

        List<PostNoPromoDTO> posts;

        if (order.equals("date_asc")) {
            posts = temp.sorted(comparator).toList();
        } else if (order.equals("date_desc")) {
            posts = temp.sorted(comparator.reversed()).toList();
        } else {
            posts = temp.toList();
        }

        return new PostsFromFollowsDTO(userId, posts);
    }

    @Override
    public MessageDTO newPost(PostDTO post){
        List<Post> posts = new ArrayList<>();
        User user = userRepository.finById(post.getUserId());
        if(user == null){
            throw new NotFoundException("Invalid user");
        }

        if (user.getPosts().isEmpty()){
            user.getPosts().add(Mappers.mapNewPost(post,100));
        } else {
            int numberPosts = user.getPosts().size();
            user.addPost(Mappers.mapNewPost(post, user.getPosts().get(numberPosts - 1).getPost_id() + 1000));
        }
        return new MessageDTO("The User "+ user.getUser_id() + " has created new post.");
    }

    @Override
    public MessageDTO createPromoPost(PromoPostDTO promoPostDTO) {
        User user = userRepository.finById(promoPostDTO.getUserId());
        if(user == null) throw new NotFoundException("Invalid user");

        if(promoPostDTO.isHasPromo() && promoPostDTO.getDiscount() <= 0.0){
            throw new BadRequestException("Invalid discount");
        }

        if(user.getPosts().isEmpty()){
            user.getPosts().add(Mappers.mapNewPromoPost(promoPostDTO, 100));
        }else {
            int numberPosts = user.getPosts().size();
            user.addPost(Mappers.mapNewPromoPost(promoPostDTO, user.getPosts().get(numberPosts - 1).getPost_id() + 1000));
        }

        return new MessageDTO("Promo post created");
    }

    @Override
    public PromoProductsCountDTO getCountPromoPosts(Integer userId) {

        if(userId == null){ throw new BadRequestException("user_id must be send"); }

        User user = userRepository.finById(userId);
        if(user == null){ throw new NotFoundException("Invalid user"); }
        int promoPostsCount = (int) user.getPosts()
                .stream()
                .filter(Post::isHas_promo)
                .count();
        return new PromoProductsCountDTO(user.getUser_id(), user.getUser_name(), promoPostsCount);
    }
}
