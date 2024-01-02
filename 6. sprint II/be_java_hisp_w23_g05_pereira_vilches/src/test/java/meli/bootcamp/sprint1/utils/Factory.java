package meli.bootcamp.sprint1.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.NewProductDto;
import meli.bootcamp.sprint1.dto.response.*;
import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.Post;
import meli.bootcamp.sprint1.entity.Product;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.exception.CustomException;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static meli.bootcamp.sprint1.utils.Sorter.*;

public class Factory {

    public static LastPostsDto generateLastPostDto(){
        LocalDate today = LocalDate.now();
        return new LastPostsDto(2,List.of(
                new PostDto(  1,  1,  LocalDate.now(),
                    new ProductDto( 1,
                            "Tele",
                            "Gamer",
                            "Razer",
                            "Red Black",
                            "Special Edition"),1,100.00),
                new PostDto(  1,  2,  today.minusDays(2),
                    new ProductDto( 1,
                            "Tele",
                            "Gamer",
                            "Razer",
                            "Red Black",
                            "Special Edition"),1,100.00),
                        new PostDto(  1,  3,  today.minusDays(11),
                                new ProductDto( 1,
                                        "Tele",
                                        "Gamer",
                                        "Razer",
                                        "Red Black",
                                        "Special Edition"),1,100.00)));

    }
    public static LastPostsDto generateLastPostDtoOrdered(String order){
        LocalDate today = LocalDate.now();

        List<PostDto> postDtoList = List.of(new PostDto(  1,  1,  LocalDate.now(),
                        new ProductDto( 1,
                                "Tele",
                                "Gamer",
                                "Razer",
                                "Red Black",
                                "Special Edition"),1,100.00),
                new PostDto(  1,  2,  today.minusDays(2),
                        new ProductDto( 1,
                                "Tele",
                                "Gamer",
                                "Razer",
                                "Red Black",
                                "Special Edition"),1,100.00),
                new PostDto(  1,  3,  today.minusDays(11),
                        new ProductDto( 1,
                                "Tele",
                                "Gamer",
                                "Razer",
                                "Red Black",
                                "Special Edition"),1,100.00));

        return new LastPostsDto(2,orderPostDtoList(postDtoList,order));

    }

    public static List<Post> generatePost(){
        LocalDate today = LocalDate.now();
        Product product = new Product(1,"Tele","Gamer","Razer","Special Edition","Red Black");
        return List.of(
                new Post(product, LocalDate.now(),new Category(1,"Electronic"),100.00),
                new Post(product, today.minusDays(2),new Category(1,"Electronic"),100.00),
                new Post(product, today.minusDays(11),new Category(1,"Electronic"),100.00),
                new Post(product, today.minusYears(1) ,new Category(1,"Electronic"),100.00),
                new Post(product, today.minusYears(2),new Category(1,"Electronic"),100.00)
                );
    }
    public static User generateSeller() {
        return new User(1, "Nico", true, generatePost(), Collections.emptyList(), List.of(2));
    }
    public static User generateSeller(String order){
        List<Post> orderedList = orderPostList(generatePost(),order);
        return new User(1,"Nico",true, orderedList, Collections.emptyList(),List.of(2));
    }

    public static User generateUser(){
        return new User(2,"Marco",false, Collections.emptyList(),List.of(1),Collections.emptyList());
    }

    public static User generateSellerNoFollowers(){
        return new User(3,"Tiago",true, generatePost(), Collections.emptyList(), Collections.emptyList());
    }

    public static User generateUser2() {
        return new User(4, "Fatima", false, Collections.emptyList(), List.of(1), List.of(1, 2));
    }
    public static UserWFollowerListDto generateUserDtoList(String order){
        List<UserDto> userDtoList =  new ArrayList<>();
        userDtoList.add(new UserDto(3,"Fatima Noble"));
        userDtoList.add(new UserDto(2,"Brenda Torrico"));
        userDtoList.add(new UserDto(1,"Ailen Pereira"));

        return new UserWFollowerListDto(4,"Geronimo Schmidt",orderUserDtoList(userDtoList,order));
    }

    public static List<User> generateUsersList(){
        return List.of(new User(1,"Ailen Pereira",true, Collections.emptyList(),Collections.emptyList(),Collections.emptyList())
                ,new User(2,"Brenda Torrico",true, Collections.emptyList(),Collections.emptyList(),Collections.emptyList())
                ,new User(3,"Fatima Noble",true, Collections.emptyList(),Collections.emptyList(),Collections.emptyList())
                ,new User(4,"Geronimo Schmidt",true, Collections.emptyList(),Collections.emptyList(),List.of(1,2,3)));
    }

    public static NewPostDto generateNewPostDto(){
        return new NewPostDto(
                 1,
                LocalDate.of(2023,12,20),
                        new NewProductDto( 1,
                                "Tele",
                                "Gamer",
                                "Razer",
                                "Red Black",
                                "Special Edition")
                ,1,
                100.00);
    }

    public static NewPostDto generateNewPostDtoCase1() {
        NewPostDto newPostDto = generateNewPostDto();
        newPostDto.setCategory(100);
        return newPostDto;
    }

    public static NewPostDto generateNewPostDtoCase2() {
        NewPostDto newPostDto = generateNewPostDto();
        newPostDto.setUser_id(100);
        return newPostDto;
    }

    public static NewPostDto generateNewPostDtoWErrors(){
        return new NewPostDto();
    }

    public static NewPostDto generateNewPostDtoWErrors2(){
        return new NewPostDto(
                1,
                LocalDate.of(2023,12,20),
                new NewProductDto( 1,
                        "Tele",
                        "Gamer",
                        "Razer&",
                        "Red Black",
                        "Special Edition")
                ,1,
                150000000.00);
    }

    public static BaseResponseDto generateBaseResponseDto(String message){
        return new BaseResponseDto(message);
    }

    private List<User> loadTestUsers() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/usersTest.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

}
