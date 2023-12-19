package meli.bootcamp.sprint1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Mapper {
  private static ObjectMapper mapper = new ObjectMapper();

  public Mapper() {
    mapper.registerModule(new JavaTimeModule());
  }
  public static <Origin,Destination> Destination map(Origin origin, Class<Destination> destination){
    return mapper.convertValue(origin, destination);
  }
}
