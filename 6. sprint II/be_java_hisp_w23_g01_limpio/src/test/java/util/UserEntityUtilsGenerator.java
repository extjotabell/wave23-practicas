package util;

import com.meli.socialmeli.dtos.response.PostNoPromoDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.Product;
import com.meli.socialmeli.entities.User;

import static com.meli.socialmeli.utilities.Mappers.mapPostUserAndProductPromoNoPromoDTO;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class UserEntityUtilsGenerator {

    public static User getUserWithThreeFollowers(){
        User userFollowerOne = new User(200000,"A-Follower One", null, null, null);
        User userFollowerTwo = new User(300000,"B-Follower Two",null, null, null);
        User userFollowerThree = new User(400000,"Z-Follower Three",null, null, null);
        User user =  new User(100000, "User with followers",
                List.of(userFollowerTwo,userFollowerOne, userFollowerThree), null, null);
        userFollowerOne.setFollowed(List.of(user));
        userFollowerTwo.setFollowed(List.of(user));
        userFollowerThree.setFollowed(List.of(user));
        return user;
    }
    public static User getUserWithThreeFollowed(){
        User userFollowerOne = new User(200000,"A-Follower One", null, null, null);
        User userFollowerTwo = new User(300000,"B-Follower Two",null, null, null);
        User userFollowerThree = new User(400000,"Z-Follower Three",null, null, null);
        User user =  new User(100000, "User with followers",
                null, List.of(userFollowerTwo,userFollowerOne, userFollowerThree), null);
        userFollowerOne.setFollowers(List.of(user));
        userFollowerTwo.setFollowers(List.of(user));
        userFollowerThree.setFollowers(List.of(user));
        return user;
    }

    public static User userStaticTest(){
        User user = new User();
        user.setFollowed(new ArrayList<>());
        user.setFollowers(new ArrayList<>());
        return user;
    }

    public static User userToUnfollowStaticTest(){
        User userToUnfollow = new User();
        userToUnfollow.setFollowed(new ArrayList<>());
        userToUnfollow.setFollowers(new ArrayList<>());
        return userToUnfollow;
    }

    public static User getUserFollwingSellersTest() {
        User seller1 = new User(2, "seller1", List.of(), List.of(), List.of());
        User seller2 = new User(3, "seller2", List.of(), List.of(), null);
        List<User> sellers = List.of(seller1, seller2);

        Post post1 = new Post(
                LocalDate.of(2023, 12, 20),
                new Product(
                        1,
                        "Compu Gamer",
                        "Compu",
                        "MSI",
                        "Black",
                        "Compu buena"
                ),
                1,
                10000.0,
                1
        );

        Post post2 = new Post(
                LocalDate.of(2023, 12, 11),
                new Product(
                        2,
                        "Silla Ergonomica",
                        "Silla",
                        "Coleman",
                        "Azul",
                        "Buena silla"
                ),
                2,
                154454.4,
                2
        );

        List<Post> posts = List.of(post1, post2);

        seller2.setPosts(posts);

        return new User(1,"User", List.of(), sellers, List.of());
    }

    public static User getUserFollwingSellersOrderingTest() {
        User seller1 = new User(2, "seller1", List.of(), List.of(), List.of());
        User seller2 = new User(3, "seller2", List.of(), List.of(), null);
        List<User> sellers = List.of(seller1, seller2);

        Post post1 = new Post(
                LocalDate.of(2023, 12, 20),
                new Product(
                        1,
                        "Compu Gamer",
                        "Compu",
                        "MSI",
                        "Black",
                        "Compu buena"
                ),
                1,
                10000.0,
                1
        );

        Post post2 = new Post(
                LocalDate.of(2023, 12, 11),
                new Product(
                        2,
                        "Silla Ergonomica",
                        "Silla",
                        "Coleman",
                        "Azul",
                        "Buena silla"
                ),
                2,
                154454.4,
                2
        );

        List<Post> postsSeller2 = List.of(post1, post2);

        Post post3 = new Post(
                LocalDate.of(2023, 12, 26),
                new Product(
                        1,
                        "Compu Gamer 2",
                        "Compu",
                        "MSI",
                        "Black",
                        "Compu buena 2"
                ),
                1,
                5000.0,
                1
        );

        Post post4 = new Post(
                LocalDate.of(2023, 12, 18),
                new Product(
                        2,
                        "Silla Ergonomica 2",
                        "Silla",
                        "Coleman",
                        "Azul",
                        "Buena silla 2"
                ),
                2,
                154454.4,
                2
        );

        List<Post> postsSeller1 = List.of(post3, post4);

        seller1.setPosts(postsSeller1);
        seller2.setPosts(postsSeller2);

        return new User(1,"User", List.of(), sellers, List.of());
    }

    public static PostsFromFollowsDTO getUserFollwingSellersOrderingAscTest(){
        User user = getUserFollwingSellersOrderingTest();
        List<User> sellers =  user.getFollowed();

        User seller1 = sellers.get(0);
        User seller2 = sellers.get(1);

        List<PostNoPromoDTO> postsAscSorted = List.of(
                mapPostUserAndProductPromoNoPromoDTO(
                            seller1.getPosts().get(1),
                            seller1
                        ),
                mapPostUserAndProductPromoNoPromoDTO(
                        seller2.getPosts().get(0),
                            seller2),
                mapPostUserAndProductPromoNoPromoDTO(
                            seller1.getPosts().get(0),
                        seller1)
        );

        return new PostsFromFollowsDTO(user.getUser_id(), postsAscSorted);
    }

    public static PostsFromFollowsDTO getUserFollwingSellersOrderingDescTest(){
        User user = getUserFollwingSellersOrderingTest();
        List<User> sellers =  user.getFollowed();

        User seller1 = sellers.get(0);
        User seller2 = sellers.get(1);

        List<PostNoPromoDTO> postsDescSorted = List.of(
                mapPostUserAndProductPromoNoPromoDTO(
                        seller1.getPosts().get(0),
                        seller1),
                mapPostUserAndProductPromoNoPromoDTO(
                        seller2.getPosts().get(0),
                        seller2),
                mapPostUserAndProductPromoNoPromoDTO(
                        seller1.getPosts().get(1),
                        seller1
                )
        );

        return new PostsFromFollowsDTO(user.getUser_id(), postsDescSorted);
    }

    public static User getNewPostAdd(){

        User user = new User(3, "usurioPost1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        return user;
    }
}