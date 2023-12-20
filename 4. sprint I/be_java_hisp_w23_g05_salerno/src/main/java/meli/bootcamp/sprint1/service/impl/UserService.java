package meli.bootcamp.sprint1.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

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
    User user = this.repository.findUserById(newPost.getUser_id());
    if (user == null) {
      throw new BadRequestException("User not found");
    }

    if (newPost.isHas_promo() == true){
      throw new BadRequestException("Product has a promotion. (Use Add Promo Post instead)");
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

    if (!userToFollow.isSeller()) {
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
  public UserDto getFollowersById(int id, String order) {
    User user = repository.findUserById(id);
    if (user == null) {
      throw new BadRequestException("User not found");
    }

    List<Integer> followers = user.getFollowers();

    if (followers == null || followers.isEmpty()) {
      throw new EmptyListException("The User " + id + " has no followers users");
    }

    List<FollowerDto> followerDtoList = new ArrayList<>();

    for (Integer idFollower : followers) {
      User findFollower = repository.findUserById(idFollower);
      FollowerDto followerDto = new FollowerDto(findFollower.getId(), findFollower.getName());
      followerDtoList.add(followerDto);
    }

    if (order == null || order.equals("name_asc")) {
      followerDtoList = followerDtoList.stream()
          .sorted(Comparator.comparing(FollowerDto::getUser_name))
          .toList();
    } else if (order.equals("name_desc")) {
      followerDtoList = followerDtoList.stream()
          .sorted(Comparator.comparing(FollowerDto::getUser_name).reversed())
          .toList();
    }

    UserDto userDto = new UserDto(user.getId(), user.getName(), followerDtoList);
    return userDto;
  }

  @Override
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
      return new BaseResponseDto("Error unfollowing user, user " + userId + " doesn't follow user " + userIdToUnfollow);
    }
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
  public BaseResponseDto addPromoPost(NewPostDto NewPostDto) {
    User user = this.repository.findUserById(NewPostDto.getUser_id());
    if (user == null) {
      throw new BadRequestException("User not found");
    }

    Product newProductEntity = Mapper.map(NewPostDto.getProduct(), Product.class);

    Category category = this.repository.findCategoryById(NewPostDto.getCategory());
    if (category == null) {
      throw new BadRequestException("Category not found");
    }

    if (NewPostDto.isHas_promo() == false){
      throw new BadRequestException("Product has no promotion. (Use Add Post instead)");
    }

    Post newPostEntity = new Post(newProductEntity, NewPostDto.getDate(), category, NewPostDto.getPrice(), NewPostDto.isHas_promo(), NewPostDto.getDiscount());

    user.addPost(newPostEntity);

    return new BaseResponseDto("Post with Promotion Added");
  }

  @Override
  public ProductsPromoDTO getProductsPromoCountById(Integer id) {
    User user = this.repository.findUserById(id);
    if (user == null){
      throw new BadRequestException("User not Found");
    }

    List<Post> promoPosts = new ArrayList<>();

    user.getPosts().stream()
            .forEach((post -> {
              if (post.isHas_promo() == true) {
                promoPosts.add(post);
              }
            }));

    return new ProductsPromoDTO(user.getId(), user.getName(), promoPosts.size());
  }

  @Override
  public UserPromoPostResponseDTO getListProductsById(Integer id, String order) {
    User user = this.repository.findUserById(id);

    if(user == null){
      throw new BadRequestException("User not Found");
    }

    final List<PromoPostResponseDTO> promoPosts = new ArrayList<>();


    user.getPosts().stream()
            .forEach((post -> {
              if (post.isHas_promo() == true) {
                final ProductDto productDto = new ProductDto(post.getProduct().getId(), post.getProduct().getName(), post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(), post.getProduct().getNotes());
                final PromoPostResponseDTO promoPostResponseDTO = new PromoPostResponseDTO(user.getId(), post.getId(), post.getDate(), productDto, post.getCategory().getId(), post.getPrice(), post.isHas_promo(), post.getDiscount());
                promoPosts.add(promoPostResponseDTO);
              }
            }));

    List<PromoPostResponseDTO> promoPostOrdered = new ArrayList<>();

    if (order.equals("name_asc")) {
      promoPostOrdered = promoPosts.stream()
              .sorted(Comparator.comparing(PromoPostResponseDTO::getProduct, (p1, p2) -> p2.getProduct_name().compareTo(p1.getProduct_name())))
              .toList();
    } else if (order.equals("name_desc") || order == null || order != ("name_desc") ) {
      promoPostOrdered = promoPosts.stream()
              .sorted(Comparator.comparing(PromoPostResponseDTO::getProduct, (p1, p2) -> p2.getProduct_name().compareTo(p1.getProduct_name())).reversed())
              .toList();
    }

    return new UserPromoPostResponseDTO(user.getId(), user.getName(), promoPostOrdered);
  }
}