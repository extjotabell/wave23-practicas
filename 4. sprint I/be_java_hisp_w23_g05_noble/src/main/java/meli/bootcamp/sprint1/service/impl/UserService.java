package meli.bootcamp.sprint1.service.impl;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

import meli.bootcamp.sprint1.dto.request.*;
import meli.bootcamp.sprint1.dto.response.*;
import meli.bootcamp.sprint1.exception.EmptyListException;

import meli.bootcamp.sprint1.util.Validator;
import org.springframework.stereotype.Service;

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
    Validator.validateUser(user);

    Product newProductEntity = Mapper.map(newPost.getProduct(), Product.class);

    Category category = this.repository.findCategoryById(newPost.getCategory());
    Validator.validateCategory(category);

    Post newPostEntity = new Post(newProductEntity, newPost.getDate(), category, newPost.getPrice());

    user.addPost(newPostEntity);

    return new BaseResponseDto("Post added");
  }

  @Override
  public BaseResponseDto followUser(int userId, int userIdToFollow) {
    User user = this.repository.findUserById(userId);
    User userToFollow = this.repository.findUserById(userIdToFollow);
    Validator.validateUser(user);
    Validator.validateUser(userToFollow);
    Validator.validateIsSeller(userToFollow);

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
  public List<UserDto> getAll() {
    List<User> users = this.repository.findAll();

    return users.stream()
            .map(user -> new UserDto(
                    user.getId(),
                    user.getName(),
                    user.isSeller(),
                    mapPostsToPostDto(user.getPosts(), user.getId()),
                    user.getFollowed(),
                    user.getFollowers()))
            .collect(Collectors.toList());
  }

  private List<PostDto> mapPostsToPostDto(List<Post> posts, int userId) {
    return posts.stream()
            .map(post -> new PostDto(userId, post.getId(), post.getDate(), Mapper.map(post.getProduct(), ProductDto.class), post.getCategory().getId(), post.getPrice()))
            .collect(Collectors.toList());
  }

  @Override
  public UserDtoUS0003 getFollowersById(int id, String order) {
    User user = repository.findUserById(id);
    Validator.validateUser(user);

    List<Integer> followers = user.getFollowers();

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

    return new UserDtoUS0003(user.getId(), user.getName(), followersDtoUS0003List);
  }

  public BaseResponseDto unfollowUser(int userId, int userIdToUnfollow) {
    User userFollower = repository.findUserById(userId);
    User userFollowed = repository.findUserById(userIdToUnfollow);
    Validator.validateUser(userFollower);
    Validator.validateUser(userFollowed);
    Validator.validateIsSeller(userFollowed);

    if (userFollower.getFollowed().isEmpty() && userFollowed.getFollowed().isEmpty()) {
      throw new EmptyListException("Followed list and following lists are empty");
    }

    boolean unfollowed = this.repository.unfollowUser(userFollower.getFollowed(), userFollowed.getFollowers(), userIdToUnfollow, userId);

    if (unfollowed) {
      return new BaseResponseDto("User " + userIdToUnfollow + " was unfollowed");
    } else {
      return  new BaseResponseDto("Error unfollowing user, user " + userId + " doesn't follow user " + userIdToUnfollow);
    }
  }

  public FollowersDto getFollowersByUserId(int userId) {
    User user = this.repository.findUserById(userId);
    Validator.validateUser(user);

    return new FollowersDto(user.getId(), user.getName(), user.getFollowers().size());
  }
  
  public UserFollowedDto getFollowed(Integer id, String order) {
    User user = this.repository.findUserById(id);
    Validator.validateUser(user);

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

    return new UserFollowedDto(user.getId(), user.getName(), followed);
  }

  @Override
  public LastPostsDto getLastPostsFromFollowed(int userId) {
    User user = this.repository.findUserById(userId);
    Validator.validateUser(user);

    List<Integer> followedId = user.getFollowed();
    List<User> followed = followedId.stream().map(this.repository::findUserById).toList();
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

  public LastPostsDto getLastPosts(int userId, String order) {
    if ("date_asc".equals(order) || "date_desc".equals(order)) {
      return getLastPostsOrdered(userId, order);
    } else {
      return getLastPostsFromFollowed(userId);
    }
  }

  public UserFollowedDto getFollowed(Integer id) {
    User user = this.repository.findUserById(id);
    Validator.validateUser(user);

    if (user.getFollowed().isEmpty()){
      throw new EmptyListException("The User " + id + " has no followed users");
    }

    List<FollowedDto> followed = new ArrayList<>();

    user.getFollowed().forEach((u) -> followed.add(new FollowedDto(u, this.repository.findUserById(u).getName()))
    );

    return new UserFollowedDto(user.getId(), user.getName(), followed);
  }

  /////////////////////////////////////// US 10, 11 and 12 ///////////////////////////////////////
  @Override
  public BaseResponseDto postPromo(NewPostDiscountDto newPost) {
    User user = repository.findUserById(newPost.getUser_id());
    Validator.validateUser(user);

    Category category = repository.findCategoryById(newPost.getCategory());
    Validator.validateCategory(category);

    Product product = new Product(newPost.getProduct().getProduct_id(), newPost.getProduct().getProduct_name(), newPost.getProduct().getType(), newPost.getProduct().getBrand(), newPost.getProduct().getNotes(), newPost.getProduct().getColor());

    Post newPostDiscount = new Post(product, newPost.getDate(), category, newPost.getPrice(), newPost.isHas_promo(), newPost.getDiscount());

    user.addPost(newPostDiscount);

    return new BaseResponseDto("Product added successfully");
  }

  @Override
  public ProductsWithPromoDto productsWithPromoCount(int userId) {
    User user = repository.findUserById(userId);
    Validator.validateUser(user);
    Validator.validateIsSeller(user);

    Long productsWithPromo = user.getPosts().stream()
            .filter(p -> p.isHasPromo() && p.getProduct() != null)
            .count();

    return new ProductsWithPromoDto(userId, user.getName(), productsWithPromo);
  }

  @Override
  public ProductsDto allProductsWithPromo(int userId) {
    User user = repository.findUserById(userId);
    Validator.validateUser(user);
    Validator.validateIsSeller(user);

    List<ProductDto> productDtosWithPromo = new ArrayList<>();

    for (Post p : user.getPosts()) {
      if (p.isHasPromo() && p.getProduct() != null) {
        ProductDto productDto = Mapper.map(p.getProduct(), ProductDto.class);
        productDtosWithPromo.add(productDto);
      }
    }

    return new ProductsDto(productDtosWithPromo);
  }

  @Override
  public UserPreferenceDto typesOfSellersFollowedByUser(int userId) {
    User user = repository.findUserById(userId);
    Validator.validateUser(user);
    Validator.validateIsNotSeller(user);

    if (user.getFollowed().isEmpty()) {
      throw new EmptyListException("This user doesn't follow any seller");
    }

    List<User> sellers = repository.findAll().stream().filter(User::isSeller).toList();
    int[] idsSellersFollowedByUser = user.getFollowed().stream().mapToInt(Integer::intValue).toArray();
    int sellersWithPromo = 0;
    int sellersWithoutPromo = 0;

    for (int i = 0; i < sellers.size(); i++) {
      int currentSellerId = sellers.get(i).getId();

      if (Arrays.stream(idsSellersFollowedByUser).anyMatch(id -> id == currentSellerId)) {
        List<Post> posts = sellers.get(i).getPosts();

        boolean hasPromo = false;

        if (!posts.isEmpty()) {
          for (Post p : posts) {
            if (p.isHasPromo()) {
              hasPromo = true;
              break;
            }
          }
        } else {
          throw new BadRequestException("The sellers this user follows, don't have post yet");
        }

        if (hasPromo) {
          sellersWithPromo++;
        } else {
          sellersWithoutPromo++;
        }
      }
    }

    String description = (sellersWithPromo > sellersWithoutPromo) ? "This user follows more sellers who offer promo" :
            (sellersWithPromo < sellersWithoutPromo) ? "This user follows more sellers who don't offer promo" :
                    "This user follows an equal number of sellers with and without promo";

    int sellersFollowed = sellersWithPromo + sellersWithoutPromo;

    if (sellersFollowed == 0) {
      throw new BadRequestException("This user doesn't follow any sellers");
    } else {
      return new UserPreferenceDto(
              userId,
              user.getName(),
              idsSellersFollowedByUser.length,
              sellersWithPromo,
              sellersWithoutPromo,
              (sellersWithPromo == 0 && sellersWithoutPromo == 0) ? "This user doesn't follow any seller" : description);
    }
  }
}
