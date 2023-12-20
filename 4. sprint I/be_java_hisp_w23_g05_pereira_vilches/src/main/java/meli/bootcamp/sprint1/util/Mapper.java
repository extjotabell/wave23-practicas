package meli.bootcamp.sprint1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import meli.bootcamp.sprint1.dto.response.PostDto;
import meli.bootcamp.sprint1.dto.response.ProductDto;
import meli.bootcamp.sprint1.entity.Post;

public class Mapper {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static <Origin,Destination> Destination map(Origin origin, Class<Destination> destination){
    mapper.registerModule(new JavaTimeModule());
    return mapper.convertValue(origin, destination);
  }

  public static PostDto mapToPostDto(Post post){
    ProductDto productDto = new ProductDto(post.getProduct().getId(),post.getProduct().getName(),post.getProduct().getType(),post.getProduct().getBrand(),post.getProduct().getColor(),post.getProduct().getNotes());
    return new PostDto(post.getUser_id(), post.getId(), post.getDate(), productDto,post.getCategory().getId(),post.getPrice());
  }
}
