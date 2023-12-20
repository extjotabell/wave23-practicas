package com.example.be_java_hisp_w23_g3.service.product;

import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.FollowedPostsListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;
import com.example.be_java_hisp_w23_g3.entity.Post;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import com.example.be_java_hisp_w23_g3.exception.AlreadyExistsException;
import com.example.be_java_hisp_w23_g3.exception.NotFoundException;
import com.example.be_java_hisp_w23_g3.repository.product.ProductRepository;
import com.example.be_java_hisp_w23_g3.repository.seller.SellerRepository;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepository;
import com.example.be_java_hisp_w23_g3.util.PostMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository, SellerRepository sellerRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostResponseDTO postProduct(PostRequestDTO postRequestDTO) {
        Seller seller = getSeller(postRequestDTO.getUserId());
        validateProduct(postRequestDTO.getProduct().getProductId());

        Post post = createPost(postRequestDTO, seller);
        return PostMapper.toPostResponseDTO(post);
    }

    @Override
    public FollowedPostsListDTO followedPostsList(Long userId, String order) {
        User user = getUser(userId);
        List<Long> followedSellersIds = user.getFollowing().stream().map(Seller::getId).toList();
        List<Post> allFollowedByUser = getFollowedPosts(followedSellersIds);

        return PostMapper.mapToFollowedPostsListDTO(allFollowedByUser, userId, order);
    }

    private Seller getSeller(Long userId) {
        return sellerRepository.read(userId)
                .or(() -> userRepository.read(userId).map(this::convertUserToSeller))
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));
    }

    private Seller convertUserToSeller(User user) {
        Seller newSeller = Seller.build(user);
        sellerRepository.create(newSeller);
        userRepository.delete(user.getId());
        return newSeller;
    }

    private void validateProduct(Long productId) {
        if (productRepository.findAll().stream().anyMatch(post -> post.getProduct().getId().equals(productId))) {
            throw new AlreadyExistsException("Product with id " + productId + " already posted");
        }
    }

    private Post createPost(PostRequestDTO postRequestDTO, Seller seller) {
        Long id = productRepository.getNextId();
        Post post = PostMapper.toPost(postRequestDTO, seller, id);
        productRepository.create(post);
        seller.getPosts().put(id, post);
        return post;
    }

    private User getUser(Long userId) {
        return userRepository.read(userId)
                .or(() -> sellerRepository.read(userId))
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));
    }

    private List<Post> getFollowedPosts(List<Long> followedSellersIds) {
        return productRepository.readBatchBySellerIds(followedSellersIds).stream()
                .filter(post -> !post.getDate().isBefore(LocalDate.now().minusWeeks(2))).toList();
    }
}