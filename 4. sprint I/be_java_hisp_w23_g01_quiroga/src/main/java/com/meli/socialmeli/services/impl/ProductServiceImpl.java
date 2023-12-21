package com.meli.socialmeli.services.impl;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.request.PostPromoDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.response.PostNoPromoDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.entities.User;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import com.meli.socialmeli.exceptions.custom.NotFoundException;
import com.meli.socialmeli.repositories.IUserRepository;
import com.meli.socialmeli.services.IProductService;
import com.meli.socialmeli.services.IUserService;
import com.meli.socialmeli.utilities.Mappers;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements IProductService {
    private final IUserRepository userRepository ;
    private final IUserService userService;

    public ProductServiceImpl(IUserRepository userRepository, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    private List<PostNoPromoDTO> getAllPostFollowsLastTwoWeeks(Integer userId) {
        List<User> follows = userService.findFollowsByIdProductService(userId);
        if (follows == null || follows.isEmpty()) throw new NotFoundException("The user with id: " + userId + " does not follow anyone");

        List<PostNoPromoDTO> postNoPromoDTOList = new ArrayList<>();

        follows.forEach(f -> f.getPosts().stream()
                .filter(post -> !post.isHas_promo())
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .map(post -> new PostNoPromoDTO(
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
                ))
                .forEach(postNoPromoDTOList::add));
        if(postNoPromoDTOList.isEmpty()){
            throw new NotFoundException("The sellers of the user with id: " + userId +
                    " do not have any publications in the last two weeks");
        }
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

    @Override
    public MessageDTO newPostPromo(PostPromoDTO postPromo){
        User user = userRepository.finById(postPromo.getUserId());
        if(user == null){
            throw new NotFoundException("Invalid user");
        }
        if(!postPromo.isHas_promo()){
            throw new BadRequestException("The product is not on discount.");
        }
        if(postPromo.getDiscount() <= 0 ){
            throw new BadRequestException("The product is not on discount.");
        }
        if(user.getPosts().isEmpty()){
            int numberPosts = user.getPosts().size();
            user.addPostPromo(Mappers.mapNewPostPromo(postPromo, user.getPosts().get(numberPosts - 1).getPost_id() + 1000));
        }

        return new MessageDTO("The user "+ user.getUser_id() + " has created new post with discount.");
    }
}
