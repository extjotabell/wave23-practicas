package com.meli.socialmeli.controllers;

import com.meli.socialmeli.dtos.response.UserFollowedDTO;
import com.meli.socialmeli.dtos.response.UserFollowersDTO;
import com.meli.socialmeli.services.IUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    /*
        US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
    */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow){
        return ResponseEntity.ok(userService.followSeller(userId, userIdToFollow));
    }

    /*
        US-0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
        US-0008: Ordenamiento alfabético ascendente y descendente.
    */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getFollowersById(@PathVariable int userId, @RequestParam(defaultValue = "empty") String order){
        return ResponseEntity.ok(userService.findFollowersById(userId, order));
    }

    /*
        US-0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable int userId){
        return ResponseEntity.ok(userService.getFollowersCount(userId));
    }

    /*
        US-0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
        US-0008: Ordenamiento alfabético ascendente y descendente.
    */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowedById(@PathVariable int userId, @RequestParam(defaultValue = "empty") String order){
        return ResponseEntity.ok(userService.findFollowedById(userId, order));
    }
    /*
        US-0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }


}