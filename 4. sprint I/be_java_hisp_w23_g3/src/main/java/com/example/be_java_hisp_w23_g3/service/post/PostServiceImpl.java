package com.example.be_java_hisp_w23_g3.service.post;

import com.example.be_java_hisp_w23_g3.dto.request.post.RequestPostDTO;
import com.example.be_java_hisp_w23_g3.dto.request.post.RequestPromoPostDTO;
import com.example.be_java_hisp_w23_g3.dto.response.post.FollowedPostsListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.post.PromoPostCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.post.PromoPostsListDTO;
import com.example.be_java_hisp_w23_g3.entity.Post;
import com.example.be_java_hisp_w23_g3.entity.PromoPost;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import com.example.be_java_hisp_w23_g3.exception.NotFoundException;
import com.example.be_java_hisp_w23_g3.repository.post.PostRepository;
import com.example.be_java_hisp_w23_g3.repository.post.PostRepositoryImpl;
import com.example.be_java_hisp_w23_g3.repository.user.SellerRepository;
import com.example.be_java_hisp_w23_g3.repository.user.SellerRepositoryImpl;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepository;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepositoryImpl;
import com.example.be_java_hisp_w23_g3.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;

    public PostServiceImpl(PostRepositoryImpl postRepository, UserRepositoryImpl userRepository,
                           SellerRepositoryImpl sellerRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    private Seller findSellerToPost(Long userId) {
        return sellerRepository.read(userId)
                .or(() -> userRepository.read(userId).map(user -> {
                    Seller newSeller = Seller.build(user);
                    sellerRepository.create(newSeller);
                    userRepository.delete(user.getId());
                    return newSeller;
                }))
                .orElseThrow(
                        () -> new NotFoundException("No se ha encontrado un vendedor con el ID: " + userId));
    }

    @Override
    public void setNewPost(RequestPostDTO postDTO) {
        Seller seller = findSellerToPost(postDTO.getUserId());
        postRepository.create(DTOMapper.mapToPost(postDTO, seller));
    }

    @Override
    public FollowedPostsListDTO getFollowedPosts(Long userId, String order) {
        User user = userRepository.read(userId)
                .or(() -> sellerRepository.read(userId))
                .orElseThrow(() -> new NotFoundException("No se ha encontrado un usuario con el ID: " + userId));

        List<Long> followedSellersIds = user.getFollowing().stream().map(Seller::getId).toList();

        List<Post> allFollowedByUser = postRepository.readBatchBySellerIds(followedSellersIds).stream()
                .filter(post -> !post.getDate().isBefore(LocalDate.now().minusWeeks(2))).toList();

        return DTOMapper.mapToFollowedPostsListDTO(allFollowedByUser, userId, order);
    }

    @Override
    public void setNewPromoPost(RequestPromoPostDTO promoPostDTO) {
        Seller seller = findSellerToPost(promoPostDTO.getUserId());
        postRepository.create(DTOMapper.mapToPromoPost(promoPostDTO, seller));
    }

    @Override
    public PromoPostCountDTO getPromoPostCount(Long userId) {
        Seller seller = sellerRepository.read(userId).orElseThrow(
                () -> new NotFoundException("No se ha encontrado un vendedor con el ID: " + userId));

        List<Post> promoPosts = postRepository
                .readBatchBySellerId(seller.getId()).stream().filter(post -> post instanceof PromoPost).toList();

        return DTOMapper.mapToPromoPostCountDTO(promoPosts, seller.getId(), seller.getUsername());
    }

    @Override
    public PromoPostsListDTO getPromoPostsList(Long userId) {
        Seller seller = sellerRepository.read(userId).orElseThrow(
                () -> new NotFoundException("No se ha encontrado un vendedor con el ID: " + userId));

        List<PromoPost> promoPosts = postRepository
                .readBatchBySellerId(seller.getId()).stream().filter(post -> post instanceof PromoPost)
                .map(post -> (PromoPost) post)
                .toList();

        return DTOMapper.mapToPromoPostsListDTO(promoPosts, seller.getId(), seller.getUsername());
    }
}
