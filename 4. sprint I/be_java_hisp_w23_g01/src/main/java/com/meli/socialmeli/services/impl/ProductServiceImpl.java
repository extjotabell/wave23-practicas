package com.meli.socialmeli.services.impl;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.response.PostNoPromoDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.User;
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

    private Stream<PostNoPromoDTO> getAllPostFollowsLastTwoWeeks(Integer userId) {
        List<User> follows = userService.findFollowsByIdProductService(userId);
        if (follows == null || follows.isEmpty()) throw new NotFoundException("The user with id: " + userId + " does not follow anyone");
        List<Post> posts = productRepository.getPostsFollowersLastTwoWeeks(follows);
        if (posts == null || posts.isEmpty()) throw new NotFoundException("The sellers of the user with id: " + userId +
                " do not have any publications in the last two weeks");
        return posts.stream()
                .map(p -> new PostNoPromoDTO(
                        p.getPost_id(),
                        p.getDate().toString(),
                        new ProductDTO(
                                p.getProduct().getProduct_id(),
                                p.getProduct().getProduct_name(),
                                p.getProduct().getType(),
                                p.getProduct().getBrand(),
                                p.getProduct().getColor(),
                                p.getProduct().getNotes()
                        ),
                        p.getCategory(),
                        p.getPrice()
                ));
    }
    @Override
    public PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Integer userId, String order) {
        Stream<PostNoPromoDTO> temp = this.getAllPostFollowsLastTwoWeeks(userId);

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
        }
        else {
            int numberPosts = user.getPosts().size();
            user.addPost(Mappers.mapNewPost(post, user.getPosts().get(numberPosts - 1).getPost_id() + 1000));
        }
        return new MessageDTO("The User "+ user.getUser_id() + " has created new post.");
    }
}
