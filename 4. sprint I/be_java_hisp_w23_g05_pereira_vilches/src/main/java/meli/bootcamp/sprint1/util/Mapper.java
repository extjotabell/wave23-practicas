package meli.bootcamp.sprint1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Mapper {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static <Origin,Destination> Destination map(Origin origin, Class<Destination> destination){
    mapper.registerModule(new JavaTimeModule());
    return mapper.convertValue(origin, destination);
  }
}
