package com.meli.socialmeli.services.impl;

import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.response.UserInfoDTO;
import com.meli.socialmeli.dtos.response.UserUnfollowDTO;
import com.meli.socialmeli.dtos.response.UserFollowersDTO;
import com.meli.socialmeli.dtos.response.UserFollowedDTO;
import com.meli.socialmeli.dtos.response.UserResponseDTO;
import com.meli.socialmeli.dtos.response.FollowersCountDTO;

import com.meli.socialmeli.entities.User;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import com.meli.socialmeli.repositories.IUserRepository;
import com.meli.socialmeli.exceptions.custom.NotFoundException;
import com.meli.socialmeli.services.IUserService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /*
        US-0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
        US-0008: Ordenamiento alfabético ascendente y descendente.
     */
    @Override
    public UserFollowersDTO findFollowersById(int userId, String order) {
        Optional<User> userFound = Optional.ofNullable(userRepository.finById(userId));
        if (userFound.isEmpty()) throw new NotFoundException("No existe usuario con el id: " + userId);

        if (!List.of("name_asc","name_desc").contains(order))
            throw  new BadRequestException("Debe indicar un parámetro de orden válido: 'name_asc' o 'name_desc'");

        List<UserInfoDTO> followers = userFound.get().getFollowers()
                                                     .stream()
                                                     .sorted(order.equals("name_asc")
                                                        ? Comparator.comparing(User::getUser_name)
                                                        : Comparator.comparing(User::getUser_name).reversed())
                                                    .map(f -> new UserInfoDTO(f.getUser_id(), f.getUser_name()))
                                                    .toList();
        return new UserFollowersDTO(userFound.get().getUser_id(), userFound.get().getUser_name(), followers);
    }

    @Override
    public List<User> findFollowsByIdProductService(int id) {
        Optional<User> user = Optional.ofNullable(userRepository.finById(id));
        if (user.isEmpty()) throw new NotFoundException("No existe usuario con id: " + id);

        return userRepository.getUserFollowed(user.get());
    }
    @Override
    public List<UserResponseDTO> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDTO> userResponseDtoList = new ArrayList<>();
        userList.forEach(u ->  {
            UserResponseDTO userResponseDto = new UserResponseDTO();

            userResponseDto.setUser_id(u.getUser_id());
            userResponseDto.setUser_name(u.getUser_name());

            List<String> followers = u.getFollowers().stream()
                    .map(User::getUser_name)
                    .toList();
            userResponseDto.setFollowers(followers);

            List<String> followed = u.getFollowed().stream()
                    .map(User::getUser_name)
                    .toList();
            userResponseDto.setFollowed(followed);

            userResponseDtoList.add(userResponseDto);
        });
        return userResponseDtoList;
    }

    /*
        US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
     */
    @Override
    public MessageDTO followSeller(int userId, int userIdToFollow) {
        User followerUser = userRepository.findAll()
                .stream()
                .filter(u -> userId == u.getUser_id())
                .findFirst()
                .orElse(null);
        if(followerUser == null){
            throw new BadRequestException("Usuario seguidor no encontrado");
        }

        User followedUser = userRepository.findAll()
                .stream()
                .filter(u -> userIdToFollow == u.getUser_id())
                .findFirst()
                .orElse(null);
        if(followedUser == null){
            throw new BadRequestException("Usuario a seguir no encontrado");
        }

        if(followedUser.getFollowers().contains(followerUser)){
            throw new BadRequestException("El usuario ya sigue al usuario deseado");
        }

        if(followedUser.getPosts().isEmpty() || userId == userIdToFollow){
            throw new BadRequestException("Usuario inválido para seguir");
        }

        followerUser.addFollowed(followedUser);
        followedUser.addFollower(followerUser);

        return new MessageDTO("Usuario seguido agregado");

    }

    /*
        US-0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    */
    @Override
    public FollowersCountDTO getFollowersCount(int userId) {
        User user = userRepository.finById(userId);
        if(user == null){
            throw new NotFoundException("Usuario no encontrado");
        }
        FollowersCountDTO followersCountDto = new FollowersCountDTO();
        followersCountDto.setUser_id(user.getUser_id());
        followersCountDto.setUser_name(user.getUser_name());
        followersCountDto.setFollowers_count(user.getFollowers().size());
        return followersCountDto;
    }
    /*
        US-0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
        US-0008: Ordenamiento alfabético ascendente y descendente.
    */
    @Override
    public UserFollowedDTO findFollowedById(int userId, String order) {
        Optional<User> userFound = Optional.ofNullable(userRepository.finById(userId));
        if (userFound.isEmpty()) throw new NotFoundException("No existe usuario con el id: " + userId);

        if (!List.of("name_asc","name_desc").contains(order))
            throw  new BadRequestException("Debe indicar un parámetro de orden válido: 'name_asc' o 'name_desc'");

        List<UserInfoDTO> followed = userFound.get().getFollowed()
                                                    .stream()
                                                    .sorted(order.equals("name_asc")
                                                            ? Comparator.comparing(User::getUser_name)
                                                            : Comparator.comparing(User::getUser_name).reversed())
                                                    .map(f -> new UserInfoDTO(f.getUser_id(), f.getUser_name()))
                                                    .toList();
        return new UserFollowedDTO(userFound.get().getUser_id(), userFound.get().getUser_name(), followed);
    }
    /*
        US-0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     */
    @Override
    public UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow) {
        User user = this.userRepository.finById(userId);
        User userToUnfollow = this.userRepository.finById(userIdToUnfollow);

        if (user == null || userToUnfollow == null) {
            throw new NotFoundException("Usuario no encontrado");
        }

        boolean removedFromFollowed = user.getFollowed().remove(userToUnfollow);
        boolean removedFromFollowers = userToUnfollow.getFollowers().remove(user);

        if (!removedFromFollowed || !removedFromFollowers) {
            throw new NotFoundException("Usuario seguido no encontrado");
        }

        return new UserUnfollowDTO(userId, userIdToUnfollow);
    }
}