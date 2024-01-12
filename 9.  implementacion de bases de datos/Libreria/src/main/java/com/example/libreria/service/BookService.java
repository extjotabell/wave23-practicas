package com.example.libreria.service;

import com.example.libreria.BookRepository;
import com.example.libreria.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private BookRepository repository;

  public BookService(BookRepository repository) {
    this.repository = repository;
  }

  public Book save(Book book){
    repository.save(book);
    return book;
  }

  public Iterable<Book> getAll() {
    return repository.findAll();
  }

  public Iterable<Book> findBooksByAuthor(String author) {
    return repository.findBooksByAuthor(author);
  }

  public Iterable<Book> findBooksByPublisher(String publisher){
    return repository.findBooksByPublisher(publisher);
  }

  public Iterable<Book> findBooksByTitleContaining(String keyword){
    return repository.findBooksByTitleContaining(keyword);
  }

  public Iterable<Book> findBooksByPublicationYearAfter(int year){
    return repository.findBooksByPublicationYearAfter(year);
  }
  public Iterable<Book> findBooksByPublicationYearBefore(int year){
    return repository.findBooksByPublicationYearBefore(year);
  }
  public Iterable<Book> findBooksByPageCountGreaterThan(int pageCount){
    return repository.findBooksByPageCountGreaterThan(pageCount);
  }
}
