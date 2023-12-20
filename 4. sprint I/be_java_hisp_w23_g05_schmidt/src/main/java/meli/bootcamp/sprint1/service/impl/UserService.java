package meli.bootcamp.sprint1.service.impl;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

import meli.bootcamp.sprint1.dto.response.*;
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
    User user = Optional.ofNullable(this.repository.findUserById(newPost.getUser_id()))
            .orElseThrow(()-> new BadRequestException("User not found"));

    Product newProductEntity = Mapper.map(newPost.getProduct(), Product.class);

    Category category = Optional.ofNullable(this.repository.findCategoryById(newPost.getCategory()))
            .orElseThrow(()->new BadRequestException("Category not found"));

    Post newPostEntity = createPost(newPost, newProductEntity, category);

    user.addPost(newPostEntity);

    return new BaseResponseDto("Post added");
  }

  @Override
  public BaseResponseDto followUser(int userId, int userIdToFollow) {
    User user = Optional.ofNullable(this.repository.findUserById(userId))
            .orElseThrow(()-> new BadRequestException("User with id " + userId + " not found"));
    User userToFollow = Optional.ofNullable(this.repository.findUserById(userIdToFollow))
            .orElseThrow(()->new BadRequestException("User with id " + userIdToFollow + " not found"));

    validateIsSeller(userToFollow);
    validateEqualsId(userId, userIdToFollow);

    Optional<Integer> userFollowedId = user.getFollowed().stream().filter(id -> id == userIdToFollow).findFirst();

    if (userFollowedId.isPresent())
      return new BaseResponseDto("The user is already followed");

    user.newFollow(userIdToFollow);
    userToFollow.newFollower(userId);

    return new BaseResponseDto("User followed");
  }

  @Override
  public UserDto getFollowersById(int id, String order) {
    User user = Optional.ofNullable(this.repository.findUserById(id))
            .orElseThrow(()-> new BadRequestException("User not found"));

    List<Integer> followers = Optional.ofNullable(user.getFollowers())
            .filter(follower -> !follower.isEmpty())
            .orElseThrow(()-> new EmptyListException("The User " + id + " has no followers users"));

    List<FollowerDto> followerDtoList = followers.stream()
            .map(idFollower -> repository.findUserById(idFollower))
            .map(findFollower -> new FollowerDto(findFollower.getId(), findFollower.getName()))
            .collect(Collectors.toList());

    followerDtoList = getOrderFollowerDtos(order, followerDtoList);

    UserDto userDto = new UserDto(user.getId(), user.getName(), followerDtoList);
    return userDto;
  }

  @Override
  public BaseResponseDto unfollowUser(int userId, int userIdToUnfollow) {
    User userFollower = Optional.ofNullable(this.repository.findUserById(userId))
            .orElseThrow(()-> new BadRequestException("User not found"));

    User userFollowed = Optional.ofNullable(this.repository.findUserById(userId))
            .orElseThrow(()-> new BadRequestException("Followed list and following lists are empty"));

    validateIsSeller(userFollowed);

    boolean unfollowed = this.repository.unfollowUser(userFollower.getFollowed(), userFollowed.getFollowers(), userIdToUnfollow, userId);

    if (unfollowed) {
      return new BaseResponseDto("User " + userIdToUnfollow + " was unfollowed");
    } else {
      return new BaseResponseDto("Error unfollowing user, user " + userId + " doesn't follow user " + userIdToUnfollow);
    }
  }

  @Override
  public FollowersDto getFollowersByUserId(int userId) {
    User user = Optional.ofNullable(this.repository.findUserById(userId))
            .orElseThrow(()-> new BadRequestException("User not found"));
    return new FollowersDto(user.getId(), user.getName(), user.getFollowers().size());
  }

  @Override
  public UserFollowedDto getFollowed(Integer id, String order) {
    User user = Optional.ofNullable(this.repository.findUserById(id))
            .orElseThrow(()-> new BadRequestException("User not found"));

    if (user.getFollowed().isEmpty()) {
      throw new EmptyListException("The User " + id + " has no followed users");
    }

    List<FollowedDto> followed = user.getFollowed().stream()
        .map(u -> new FollowedDto(u, this.repository.findUserById(u).getName()))
        .toList();

    followed = getOrderFollowedDtos(order, followed);

    return new UserFollowedDto(user.getId(), user.getName(), followed);
  }

  @Override
  public LastPostsDto getLastPostsFromFollowed(int userId) {
    User user = Optional.ofNullable(this.repository.findUserById(userId))
                    .orElseThrow(()-> new BadRequestException("User not found"));

    List<Integer> followedId = user.getFollowed();
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
                post.getPrice(),post.isHas_promo(),post.getDiscount());
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
  public US0011Dto countPromoPostByUserId(int userId) {
    User user = Optional.ofNullable(this.repository.findUserById(userId))
                        .orElseThrow(()-> new BadRequestException("User not found"));

    List<Post> postList = Optional.ofNullable(user.getPosts())
                                  .filter(posts -> !posts.isEmpty())
                                  .orElseThrow(()-> new BadRequestException("User has not post added."));

    int has_promo_count = (int) postList.stream()
            .filter(Post::isHas_promo)
            .count();

    return new US0011Dto(userId,user.getName(),has_promo_count);
  }

  @Override
  public US0012Dto getProductsByPrice(Double since, Double to, int user_id) {
    User user = Optional.ofNullable(this.repository.findUserById(user_id))
            .orElseThrow(() -> new BadRequestException("User not found."));

    ValidateInputsUS0012(since,to);

    List<Post> postList = Optional.ofNullable(user.getPosts())
                                  .filter(posts -> !posts.isEmpty())
                                  .orElseThrow(() -> new BadRequestException("User's posts list empty."));

    List<PostDto> posts = postList.stream()
                                  .filter(post -> post.getPrice() >= since && post.getPrice() <= to)
                                  .map(post-> createPostDto(user,post))
                                  .collect(Collectors.toList());

    return new US0012Dto(user.getName(),posts);
  }
  private void ValidateInputsUS0012(Double since, Double to){
    Objects.requireNonNull(since,"Since must be not null");
    Objects.requireNonNull(to,"To must be not null");

    if(since < 0) throw new BadRequestException("Since can't be negative");
    if(to <= 0) throw new BadRequestException("To must be greater than 0.");
  }
  private PostDto createPostDto(User user, Post post) {
    return new PostDto(user.getId(), post.getId(), post.getDate(),
            new ProductDto(post.getProduct().getId(), post.getProduct().getName(), post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(), post.getProduct().getNotes()),
            post.getCategory().getId(), post.getPrice(), post.isHas_promo(),post.getDiscount());
  }
  private Post createPost(NewPostDto newPost, Product newProductEntity, Category category) {
    Post newPostEntity = new Post(newProductEntity, newPost.getDate(), category, newPost.getPrice(), newPost.isHas_promo(), newPost.getDiscount());
    return newPostEntity;
  }
  private void validateEqualsId(int userId, int userIdToFollow) {
    if (userId == userIdToFollow) {
      throw new BadRequestException("You can't follow yourself!");
    }
  }
  private void validateIsSeller(User userToFollow) {
    if (!userToFollow.isSeller()) {
      throw new BadRequestException("User must be a seller to follow");
    }
  }
  private List<FollowedDto> getOrderFollowedDtos(String order, List<FollowedDto> followed) {
    if (order == null || order.equals("name_asc")) {
      followed = followed.stream()
              .sorted(Comparator.comparing(FollowedDto::getUser_name))
              .toList();
    } else if (order.equals("name_desc")) {
      followed = followed.stream()
              .sorted(Comparator.comparing(FollowedDto::getUser_name).reversed())
              .toList();
    }
    return followed;
  }
  private List<FollowerDto> getOrderFollowerDtos(String order, List<FollowerDto> followerDtoList) {
    if (order == null || order.equals("name_asc")) {
      followerDtoList = followerDtoList.stream()
              .sorted(Comparator.comparing(FollowerDto::getUser_name))
              .toList();
    } else if (order.equals("name_desc")) {
      followerDtoList = followerDtoList.stream()
              .sorted(Comparator.comparing(FollowerDto::getUser_name).reversed())
              .toList();
    }
    return followerDtoList;
  }
}