package meli.bootcamp.sprint1.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static <Origin,Destination> Destination map(Origin origin, Class<Destination> destination){
    return mapper.convertValue(origin, destination);
  }
}
