package com.meli.socialmeli.services.impl;

import com.meli.socialmeli.dtos.request.PostDTO;
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
import java.util.stream.Stream;

import static com.meli.socialmeli.utilities.Mappers.mapPostUserAndProductPromoNoPromoDTO;

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
        if (follows == null || follows.isEmpty()) throw new NotFoundException("El usuario con id: " + userId + " no sigue a nadie");

        List<PostNoPromoDTO> postNoPromoDTOList = new ArrayList<>();

        follows.forEach(f -> f.getPosts().stream()
                .filter(post -> !post.isHas_promo())
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .map(post -> mapPostUserAndProductPromoNoPromoDTO(post,f))
                .forEach(postNoPromoDTOList::add));
        if(postNoPromoDTOList.isEmpty()){
            throw new NotFoundException("Los vendedores que sigue el usuario con id: " + userId +
                    " no tienen ninguna publicación en las últimas dos semanas.");
        }
        return postNoPromoDTOList;
    }

    /*
        US-0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas
        dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
        US-0009: Ordenamiento por fecha ascendente y descendente.
     */
    @Override
    public PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Integer userId, String order) {
        if (order != null && !List.of("date_asc", "date_desc").contains(order))
            throw new BadRequestException("El valor " + order + " del query parameter 'order' es incorrecto.");
        Stream<PostNoPromoDTO> temp = this.getAllPostFollowsLastTwoWeeks(userId).stream();

        Comparator<PostNoPromoDTO> comparator = Comparator.comparing(PostNoPromoDTO::getDate);

        List<PostNoPromoDTO> posts;

        if (order != null && order.equals("date_asc")) {
            posts = temp.sorted(comparator).toList();
        } else if (order != null && order.equals("date_desc")) {
            posts = temp.sorted(comparator.reversed()).toList();
        } else {
            posts = temp.toList();
        }

        return new PostsFromFollowsDTO(userId, posts);
    }
    /*
        US-0005: Dar de alta una nueva publicación.
     */
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
}
