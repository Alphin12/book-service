package com.example.book_service.controller;

import com.example.book_service.model.BookEntity;
import com.example.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookRepository repo;

    @GetMapping("/books")
    public List<BookEntity> getAllBooks(){
        return repo.findAll();
    }
    @GetMapping("/books/{bid}")
    public BookEntity getABook(@PathVariable Long bid){
        return repo.findById(bid).get();
    }
    @PostMapping("/books")
    public BookEntity addBook(@RequestBody BookEntity book){
        return repo.saveAndFlush(book);
    }
}
