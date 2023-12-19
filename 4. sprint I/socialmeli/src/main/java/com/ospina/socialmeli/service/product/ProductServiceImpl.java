package com.ospina.socialmeli.service.product;

import com.ospina.socialmeli.dto.request.PostPromoRequestDTO;
import com.ospina.socialmeli.dto.request.PostRequestDTO;
import com.ospina.socialmeli.dto.response.FollowedPostsListDTO;
import com.ospina.socialmeli.dto.response.PostResponseDTO;
import com.ospina.socialmeli.dto.response.PromoCountResponseDTO;
import com.ospina.socialmeli.dto.response.PromoPostsFromSellerListDTO;
import com.ospina.socialmeli.entity.Post;
import com.ospina.socialmeli.entity.Seller;
import com.ospina.socialmeli.entity.User;
import com.ospina.socialmeli.exception.AlreadyExistsException;
import com.ospina.socialmeli.exception.NotFoundException;
import com.ospina.socialmeli.repository.product.ProductRepository;
import com.ospina.socialmeli.repository.seller.SellerRepository;
import com.ospina.socialmeli.repository.user.UserRepository;
import com.ospina.socialmeli.util.DTOMapper;
import com.ospina.socialmeli.util.PostMapper;
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
        Long productId = postRequestDTO.getProduct().getProductId();

        checkIfProductAlreadyPosted(productId);

        Long id = productRepository.getNextId();
        Post post = PostMapper.toPost(postRequestDTO, seller, id);

        productRepository.create(post);
        seller.getPosts().put(id, post);

        return PostMapper.toPostResponseDTO(post);
    }

    @Override
    public PostResponseDTO postPromoProduct(PostPromoRequestDTO postPromoRequestDTO) {
        Seller seller = getSeller(postPromoRequestDTO.getUserId());
        Long productId = postPromoRequestDTO.getProduct().getProductId();

        checkIfProductAlreadyPosted(productId);

        Long id = productRepository.getNextId();
        Post post = PostMapper.toPostPromo(postPromoRequestDTO, seller, id);

        productRepository.create(post);
        seller.getPosts().put(id, post);

        return PostMapper.toPostResponseDTO(post);
    }

    @Override
    public FollowedPostsListDTO followedPostsList(Long userId, String order) {
        User user = userRepository.read(userId)
                .or(() -> sellerRepository.read(userId))
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));

        List<Long> followedSellersIds = user.getFollowing().stream().map(Seller::getId).toList();

        List<Post> allFollowedByUser = productRepository.readBatchBySellerIds(followedSellersIds).stream()
                .filter(post -> !post.getDate().isBefore(LocalDate.now().minusWeeks(2))).toList();

        return PostMapper.mapToFollowedPostsListDTO(allFollowedByUser, userId, order);
    }

    @Override
    public PromoPostsFromSellerListDTO promoPostsList(Long userId) {
        Seller seller = getOnlySeller(userId);
        List<Post> promoPosts = seller.getPosts().values().stream()
                .filter(Post::isHasDiscount)
                .toList();

        return PostMapper.mapToPromoPostsFromSellerListDTO(promoPosts, userId, seller.getUsername());
    }

    @Override
    public PromoCountResponseDTO promoPostCount(Long userId) {
        Seller seller = getOnlySeller(userId);
        Long promoCount = seller.getPosts().values().stream()
                .filter(Post::isHasDiscount)
                .count();

        return DTOMapper.mapToPromoCountResponseDTO(seller, promoCount);

    }

    private Seller getSeller(Long userId) {
        return sellerRepository.read(userId)
                .or(() -> userRepository.read(userId).map(user -> {
                    Seller newSeller = Seller.build(user);
                    sellerRepository.create(newSeller);
                    userRepository.delete(user.getId());
                    return newSeller;
                }))
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));
    }

    private Seller getOnlySeller(Long userId) {
        return sellerRepository.read(userId)
                .orElseThrow(() -> new NotFoundException("Seller with id " + userId + " not found"));
    }

    private void checkIfProductAlreadyPosted(Long productId) {
        boolean isProductAlreadyPosted = productRepository.findAll().stream()
                .anyMatch(post -> post.getProduct().getId().equals(productId));

        if (isProductAlreadyPosted) {
            throw new AlreadyExistsException(
                    "Product with id " + productId + " already posted"
            );
        }
    }
}
