package com.example.libreria.controller;

import com.example.libreria.model.Book;
import com.example.libreria.service.BookService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
  private BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @PostMapping
  public Book save(@RequestBody Book book){
    return service.save(book);
  }

  @GetMapping()
  public Iterable<Book> getAll(){
    return service.getAll();
  }
  @GetMapping("/author/{author}")
  public Iterable<Book> findBooksByAuthor(@PathVariable String author){
    return service.findBooksByAuthor(author);
  }

  @GetMapping("/publisher/{publisher}")
  public Iterable<Book> findBooksByPublisher(@PathVariable String publisher){
    return service.findBooksByPublisher(publisher);
  }

  @GetMapping("/contains/{keyword}")
  public Iterable<Book> findBooksByTitleContaining(@PathVariable String keyword){
    return service.findBooksByTitleContaining(keyword);
  }

  @GetMapping("/pages/greater/{pageCount}")
  public Iterable<Book> findBooksByPageCountGreaterThan(@PathVariable int pageCount){
    return service.findBooksByPageCountGreaterThan(pageCount);
  }

  @GetMapping("/publication-year/after/{year}")
  public Iterable<Book> findBooksByPublicationYearAfter(@PathVariable int year){
    return service.findBooksByPublicationYearAfter(year);
  }

  @GetMapping("/publication-year/before/{year}")
  public Iterable<Book> findBooksByPublicationYearBefore(@PathVariable int year){
    return service.findBooksByPublicationYearBefore(year);
  }

}
