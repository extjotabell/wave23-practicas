package meli.bootcamp.spring.learning.ej11.repository;

import meli.bootcamp.spring.learning.ej11.entity.Link;

public interface ILinkRepository {

  void save(Link newLink);

  Link findById(int id);

  int returnCounter(String linkId);

  void invalidateLink(String linkId);

}
