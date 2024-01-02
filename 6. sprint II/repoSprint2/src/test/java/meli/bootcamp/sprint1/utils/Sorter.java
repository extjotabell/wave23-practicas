package meli.bootcamp.sprint1.utils;

import meli.bootcamp.sprint1.dto.response.PostDto;
import meli.bootcamp.sprint1.dto.response.UserDto;
import meli.bootcamp.sprint1.entity.Post;

import java.util.Comparator;
import java.util.List;

public class Sorter {

    public static List<UserDto> orderUserDtoList(List<UserDto> userDtoList, String order) {
        if(order.equals("name_asc")){
            return userDtoList.stream()
                    .sorted(Comparator.comparing(UserDto::getUser_name))
                    .toList();
        } else if(order.equals("name_desc")){
            return userDtoList.stream()
                    .sorted(Comparator.comparing(UserDto::getUser_name).reversed())
                    .toList();
        }else {
            return userDtoList;
        }
    }
    public static List<Post> orderPostList(List<Post> postList, String order) {
        if(order.equals("date_asc")){
            return postList.stream()
                    .sorted(Comparator.comparing(Post::getDate))
                    .toList();
        } else if(order.equals("name_desc")){
            return postList.stream()
                    .sorted(Comparator.comparing(Post::getDate).reversed())
                    .toList();
        }else {
            return postList;
        }
    }
    public static List<PostDto> orderPostDtoList(List<PostDto> postList, String order) {
        if(order.equals("date_asc")){
            return postList.stream()
                    .sorted(Comparator.comparing(PostDto::getDate))
                    .toList();
        } else if(order.equals("name_desc")){
            return postList.stream()
                    .sorted(Comparator.comparing(PostDto::getDate).reversed())
                    .toList();
        }else {
            return postList;
        }
    }
}
