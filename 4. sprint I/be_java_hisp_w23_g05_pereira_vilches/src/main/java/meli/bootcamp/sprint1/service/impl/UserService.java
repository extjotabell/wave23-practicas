package meli.bootcamp.sprint1.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

import meli.bootcamp.sprint1.dto.response.*;
import meli.bootcamp.sprint1.dto.request.UserFollowedDto;
import meli.bootcamp.sprint1.exception.EmptyListException;

import org.springframework.stereotype.Service;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.Post;
import meli.bootcamp.sprint1.entity.Product;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.exception.BadRequestException;
import meli.bootcamp.sprint1.repository.IGeneralRepository;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import meli.bootcamp.sprint1.service.IUserService;
import meli.bootcamp.sprint1.util.Mapper;

@Service
public class UserService implements IUserService {
  private final IGeneralRepository repository;

  public UserService(GeneralRepository repository) {
    this.repository = repository;
  }

  @Override
  public BaseResponseDto addPost(NewPostDto newPost) {
    User user = this.repository.findUserById(newPost.getUser_id());
    verifyUserExists(user);

    Product newProductEntity = Mapper.map(newPost.getProduct(), Product.class);

    Category category = this.repository.findCategoryById(newPost.getCategory());
    if (category == null) {
      throw new BadRequestException("Category not found");
    }

    Post newPostEntity = new Post(newProductEntity, newPost.getDate(), category, newPost.getPrice(), newPost.isHas_promo(), newPost.getDiscount());

    user.addPost(newPostEntity);

    return new BaseResponseDto("Post added");
  }

  @Override
  public BaseResponseDto followUser(int userId, int userIdToFollow) {
    User user = this.repository.findUserById(userId);
    User userToFollow = this.repository.findUserById(userIdToFollow);

    if (user == null) {
      throw new BadRequestException("User with id " + userId + " not found");
    } else if (userToFollow == null) {
      throw new BadRequestException("User with id " + userIdToFollow + " not found");
    }

    if(!userToFollow.isSeller()){
      throw new BadRequestException("User must be a seller to follow");
    }

    if(userId == userIdToFollow){
      throw new BadRequestException("You can't follow yourself!");
    }

    Optional<Integer> userFollowedId = user.getFollowed().stream().filter(id -> id == userIdToFollow).findFirst();

    if(userFollowedId.isPresent())
      return new BaseResponseDto("The user is already followed");

    user.newFollow(userIdToFollow);
    userToFollow.newFollower(userId);

    return new BaseResponseDto("User followed");

  }

  @Override
  public List<UserInfoDto> getAll() {
    return this.repository.findAll().stream().map(u -> Mapper.map(u,UserInfoDto.class)).toList();
  }

  @Override
  public UserFollowersDto getFollowersById(int id, String order) {
    User user = repository.findUserById(id);
    verifyUserExists(user);

    if (user.getFollowers().isEmpty()) {
      throw new EmptyListException("The User " + id + " has no followers users");
    }

    List<UserDto> followers = user.getFollowers().stream()
            .map(u -> new UserDto(u, this.repository.findUserById(u).getName()))
            .toList();

    if (order == null || order.equals("name_asc")) {
      followers = sortedAscByName(followers);
    } else if (order.equals("name_desc")) {
      followers = sortedDescByName(followers);
    }

    return new UserFollowersDto(user.getId(), user.getName(), followers);
  }
  public BaseResponseDto unfollowUser(int userId, int userIdToUnfollow) {
    User userFollower = repository.findUserById(userId);
    User userFollowed = repository.findUserById(userIdToUnfollow);

    if (userFollower == null || userFollowed == null) {
      throw new BadRequestException("User/s not found");
    }

    if (userFollower.getFollowed().isEmpty() && userFollowed.getFollowed().isEmpty()) {
      throw new BadRequestException("Followed list and following lists are empty");
    }

    if (!userFollowed.isSeller()) {
      throw new BadRequestException("User " + userId + " is not a seller");
    }

    boolean unfollowed = this.repository.unfollowUser(userFollower.getFollowed(), userFollowed.getFollowers(), userIdToUnfollow, userId);

    if (unfollowed) {
      return new BaseResponseDto("User " + userIdToUnfollow + " was unfollowed");
    } else {
      return  new BaseResponseDto("Error unfollowing user, user " + userId + " doesn't follow user " + userIdToUnfollow);
    }
  }

  public FollowersCountDto getFollowersByUserId(int userId) {
    User user = this.repository.findUserById(userId);
    verifyUserExists(user);
    return new FollowersCountDto(user.getId(), user.getName(), user.getFollowers().size());
  }
  
  public UserFollowedDto getFollowed(Integer id, String order) {
    User user = this.repository.findUserById(id);

    verifyUserExists(user);

    if (user.getFollowed().isEmpty()) {
      throw new EmptyListException("The User " + id + " has no followed users");
    }

    List<UserDto> followed = user.getFollowed().stream()
            .map(u -> new UserDto(u, this.repository.findUserById(u).getName()))
            .toList();

    if (order == null || order.equals("name_asc")) {
      followed = sortedAscByName(followed);
    } else if (order.equals("name_desc")) {
      followed = sortedDescByName(followed);
    }

    return new UserFollowedDto(user.getId(), user.getName(), followed);
  }

  @Override
  public LastPostsDto getLastPostsFromFollowed(int userId) {
    User user = this.repository.findUserById(userId);
    verifyUserExists(user);
    List<Integer> followedId = user.getFollowed();
    List<User> followed = followedId.stream().map(this.repository::findUserById).toList();
    List<PostDto> postsDto = new ArrayList<>();
    for (User follow : followed) {
      List<PostDto> postsToAdd = follow.getPosts().stream()
          .filter(post -> isFromLastTwoWeeks(post.getDate()))
          .map(post -> {
            Product product = post.getProduct();
            ProductDto productDto = new ProductDto(product.getId(), product.getName(), product.getType(),
                product.getBrand(), product.getColor(), product.getNotes());
            return new PostDto(follow.getId(), post.getId(), post.getDate(), productDto, post.getCategory().getId(),
                post.getPrice());
          })
          .toList();
      postsDto.addAll(postsToAdd);
    }
    return new LastPostsDto(userId, postsDto);
  }

  private boolean isFromLastTwoWeeks(LocalDate date) {
    return date.isAfter(LocalDate.now().minusWeeks(2)) ||
        date.equals(LocalDate.now().minusWeeks(2));
  }


  @Override
    public LastPostsDto getLastPostsOrdered(int userId, String order) {
      LastPostsDto lastPostsDto = getLastPostsFromFollowed(userId);
      List<PostDto> postsDto = lastPostsDto.getPosts();

      if ("date_asc".equals(order)) {
        postsDto.sort(Comparator.comparing(PostDto::getDate));
      } else if ("date_desc".equals(order)) {
        postsDto.sort(Comparator.comparing(PostDto::getDate).reversed());
      }

      return new LastPostsDto(userId, postsDto);
    }

  public LastPostsDto getLastPosts(int userId, String order) {
    if ("date_asc".equals(order) || "date_desc".equals(order)) {
      return getLastPostsOrdered(userId, order);
    } else {
      return getLastPostsFromFollowed(userId);
    }
  }

  @Override
  public PromoProductsDto getPostWithPromo(int userId) {
    User user = this.repository.findUserById(userId);

    verifyUserExists(user);

    if (user.getPosts().isEmpty()){
      throw new EmptyListException("The User " + userId + " has no promo posts yet");
    }

    long posts = user.getPosts().stream()
            .filter(Post::isHas_promo).count();

    return new PromoProductsDto(user.getId(), user.getName(), posts);
  }

  private void verifyUserExists(User user) {
    if (user == null) {
      throw new BadRequestException("User not found");
    }
  }

  private List<UserDto> sortedAscByName(List<UserDto> listUsers) {
    return listUsers.stream()
            .sorted(Comparator.comparing(UserDto::getUser_name))
            .toList();
  }

  private List<UserDto> sortedDescByName(List<UserDto> listUsers) {
    return listUsers.stream()
            .sorted(Comparator.comparing(UserDto::getUser_name).reversed())
            .toList();
  }

}
