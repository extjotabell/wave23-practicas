package com.mercadolibre.spring.controller;

import com.mercadolibre.spring.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        books.add(book);
        return "Book added: " + book.getTitle();
    }

    @GetMapping("/list")
    public List<Book> getBooks(){
        return books;
    }

    @PutMapping("/changeTitle/{title}")
    public String changeTitle(@PathVariable String title, @RequestParam String newTitle){
        for (Book book : books){
            if(book.getTitle().equals(title)){
                book.setTitle(newTitle);
                return "The new title is: " + newTitle;
            }
        }
        return "The book with title " + title + " not exists";
    }
}
