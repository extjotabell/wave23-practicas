package meli.bootcamp.sprint1.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import meli.bootcamp.sprint1.dto.response.FollowersDto;
import meli.bootcamp.sprint1.dto.request.FollowedDto;
import meli.bootcamp.sprint1.dto.request.UserFollowedDto;
import meli.bootcamp.sprint1.exception.EmptyListException;
import meli.bootcamp.sprint1.dto.response.LastPostsDto;
import meli.bootcamp.sprint1.dto.response.PostDto;
import meli.bootcamp.sprint1.dto.response.ProductDto;
import meli.bootcamp.sprint1.dto.response.PromoPostCountDto;
import meli.bootcamp.sprint1.dto.response.FollowersDtoUS0003;
import meli.bootcamp.sprint1.dto.response.UserDtoUS0003;

import org.springframework.stereotype.Service;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.NewPromoPostDto;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.Post;
import meli.bootcamp.sprint1.entity.PromoPost;
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
    if (user == null) {
      throw new BadRequestException("User not found");
    }

    Product newProductEntity = Mapper.map(newPost.getProduct(), Product.class);

    Category category = this.repository.findCategoryById(newPost.getCategory());
    if (category == null) {
      throw new BadRequestException("Category not found");
    }

    Post newPostEntity = new Post(newProductEntity, newPost.getDate(), category, newPost.getPrice());

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

    if (userToFollow.getPosts().isEmpty()) {
      throw new BadRequestException("User must be a seller to follow");
    }

    if (userId == userIdToFollow) {
      throw new BadRequestException("You can't follow yourself!");
    }

    Optional<Integer> userFollowedId = user.getFollowed().stream().filter(id -> id == userIdToFollow).findFirst();

    if (userFollowedId.isPresent())
      return new BaseResponseDto("The user is already followed");

    user.newFollow(userIdToFollow);
    userToFollow.newFollower(userId);

    return new BaseResponseDto("User followed");
  }

  @Override
  public UserDtoUS0003 getFollowersById(int id, String order) {
    User user = repository.findUserById(id);
    if (user == null) {
      throw new BadRequestException("User not found");
    }

    Set<Integer> followers = user.getFollowers();

    if (followers == null || followers.isEmpty()) {
      throw new EmptyListException("The User " + id + " has no followers users");
    }

    List<FollowersDtoUS0003> followersDtoUS0003List = new ArrayList<>();

    for (Integer idFollower : followers) {
      User findFollower = repository.findUserById(idFollower);
      FollowersDtoUS0003 followersDtoUS0003 = new FollowersDtoUS0003(findFollower.getId(), findFollower.getName());
      followersDtoUS0003List.add(followersDtoUS0003);
    }

    if (order == null || order.equals("name_asc")) {
      followersDtoUS0003List = followersDtoUS0003List.stream()
          .sorted(Comparator.comparing(FollowersDtoUS0003::getUser_name))
          .toList();
    } else if (order.equals("name_desc")) {
      followersDtoUS0003List = followersDtoUS0003List.stream()
          .sorted(Comparator.comparing(FollowersDtoUS0003::getUser_name).reversed())
          .toList();
    }

    UserDtoUS0003 userDto = new UserDtoUS0003(user.getId(), user.getName(), followersDtoUS0003List);
    return userDto;
  }

  @Override
  public BaseResponseDto unfollowUser(int userId, int userIdToUnfollow) {
    User userFollower = repository.findUserById(userId);
    if (userFollower == null) {
      throw new BadRequestException("User not found");
    }

    User userFollowed = repository.findUserById(userIdToUnfollow);
    if (userFollowed == null) {
      throw new BadRequestException("User to unfollow not found");
    }

    if (!userFollower.getFollowed().stream().anyMatch(followedId -> followedId == userIdToUnfollow)) {
      throw new BadRequestException("User " + userId + " is not following the user " + userIdToUnfollow);
    }

    userFollower.removeFollow(userIdToUnfollow);

    userFollowed.removeFollower(userId);

    return new BaseResponseDto("User " + userIdToUnfollow + " was unfollowed");
  }

  @Override
  public FollowersDto getFollowersByUserId(int userId) {
    User user = this.repository.findUserById(userId);
    if (user == null) {
      throw new BadRequestException("User not found");
    }
    return new FollowersDto(user.getId(), user.getName(), user.getFollowers().size());
  }

  @Override
  public UserFollowedDto getFollowed(Integer id, String order) {
    User user = this.repository.findUserById(id);

    if (user == null) {
      throw new BadRequestException("User not found");
    }

    if (user.getFollowed().isEmpty()) {
      throw new EmptyListException("The User " + id + " has no followed users");
    }

    List<FollowedDto> followed = user.getFollowed().stream()
        .map(u -> new FollowedDto(u, this.repository.findUserById(u).getName()))
        .toList();

    if (order == null || order.equals("name_asc")) {
      followed = followed.stream()
          .sorted(Comparator.comparing(FollowedDto::getUser_name))
          .toList();
    } else if (order.equals("name_desc")) {
      followed = followed.stream()
          .sorted(Comparator.comparing(FollowedDto::getUser_name).reversed())
          .toList();
    }

    UserFollowedDto userFollowedDto = new UserFollowedDto(user.getId(), user.getName(), followed);

    return userFollowedDto;
  }

  @Override
  public LastPostsDto getLastPostsFromFollowed(int userId) {
    User user = this.repository.findUserById(userId);
    if (user == null) {
      throw new BadRequestException("User not found");
    }
    Set<Integer> followedId = user.getFollowed();
    List<User> followed = followedId.stream().map(id -> this.repository.findUserById(id)).toList();
    List<PostDto> postsDto = new ArrayList<PostDto>();
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

  @Override
  public LastPostsDto getLastPosts(int userId, String order) {
    if ("date_asc".equals(order) || "date_desc".equals(order)) {
      return getLastPostsOrdered(userId, order);
    } else {
      return getLastPostsFromFollowed(userId);
    }
  }

  @Override
  public UserFollowedDto getFollowed(Integer id) {
    User user = this.repository.findUserById(id);

    if (user == null) {
      throw new BadRequestException("User not found");
    }

    if (user.getFollowed().isEmpty()) {
      throw new EmptyListException("The User " + id + " has no followed users");
    }

    List<FollowedDto> followed = new ArrayList<>();

    user.getFollowed().stream()
        .forEach((u) -> followed.add(new FollowedDto(u, this.repository.findUserById(u).getName())));

    UserFollowedDto userFollowedDto = new UserFollowedDto(user.getId(), user.getName(), followed);

    return userFollowedDto;
  }

  @Override
  public BaseResponseDto addPromoPost(NewPromoPostDto newPromoPost) {
    User user = this.repository.findUserById(newPromoPost.getUser_id());
    if (user == null) {
      throw new BadRequestException("User not found");
    }

    Product newProductEntity = Mapper.map(newPromoPost.getProduct(), Product.class);

    Category category = this.repository.findCategoryById(newPromoPost.getCategory());
    if (category == null) {
      throw new BadRequestException("Category not found");
    }

    Post newPostEntity = new PromoPost(newProductEntity, newPromoPost.getDate(), category,
        newPromoPost.getPrice(), newPromoPost.getDiscount());

    user.addPost(newPostEntity);

    return new BaseResponseDto("Promo post added");
  }

  @Override
  public PromoPostCountDto countPromoPosts(int userId) {
    User user = this.repository.findUserById(userId);
    if (user == null) {
      throw new BadRequestException("User not found");
    }
    int count = (int) user.getPosts().stream().filter(p -> p instanceof PromoPost).count();
    return new PromoPostCountDto(userId, user.getName(), count);
  }

  @Override
  public BaseResponseDto remove(int userId) {
    User user = this.repository.findUserById(userId);
    if (user == null) {
      throw new BadRequestException("User not found");
    }
    user.getFollowed().forEach(followedId -> this.unfollowUser(userId, followedId));
    user.getFollowers().forEach(followerId -> this.unfollowUser(followerId, userId));

    this.repository.removeUser(user);
    return new BaseResponseDto("User deleted");
  }
}