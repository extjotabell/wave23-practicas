package com.example.libreria;

import com.example.libreria.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
  Iterable<Book> findBooksByAuthor(String author);
  Iterable<Book> findBooksByTitleContaining(String keyword);
  Iterable<Book> findBooksByPageCountGreaterThan(int pageCount);
  Iterable<Book> findBooksByPublicationYearAfter(int year);
  Iterable<Book> findBooksByPublicationYearBefore(int year);
  Iterable<Book> findBooksByPublisher(String publisher);

}
