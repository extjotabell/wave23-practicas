package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w23_g2.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Mapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Service class for handling product-related operations.
 */
@Service
public class ProductService implements IProductService {

  private final IUserRepository userRepository;

  public ProductService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Adds a new post based on the provided PostDTO.
   *
   * @param postDTO The PostDTO containing post information.
   * @return MessageDTO indicating the success of the operation.
   */
  @Override
  public MessageDTO addPost(PostDTO postDTO) {
    Post post = Mapper.mapPostDTOToPost(postDTO);

    // Check that the user exists
    User user = userRepository.findUserById(post.getUserId());

    validateUserExistence(user, post.getUserId(), "Current");

    // Check that there is no product with this id
    List<Post> postsUser = user.getPosts();
    Optional<Post> postExist = postsUser.stream()
        .filter(p -> p.getProduct().getId().equals(post.getProduct().getId())).findFirst();
    if (postExist.isPresent()) {
      throw new BadRequestException("The product id already exists.");
    }

    // In case of passing the validations, I add the post to the list
    userRepository.addPost(user, post);

    return new MessageDTO("Publication successfully added.");
  }

  private void validateUserExistence(User user, int userId, String userType) {
    if (user == null) {
      throw new NotFoundException(
          String.format("%s user with id = %d not exists.", userType, userId));
    }
  }

}
