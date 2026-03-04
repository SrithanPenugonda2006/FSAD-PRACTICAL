package com.klu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 2. /count
    @GetMapping("/count")
    public int count() {
        return 100;
    }

    // 3. /price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // 4. /books
    @GetMapping("/books")
    public List<String> books() {

        List<String> titles = new ArrayList<>();
        titles.add("Java Programming");
        titles.add("Spring Boot Guide");
        titles.add("Data Structures");

        return titles;
    }

    // 5. /books/{id}
    @GetMapping("/books/{id}")
    public String bookDetails(@PathVariable int id) {
        return "Details of Book ID: " + id;
    }

    // 6. /search?title=Java
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // 7. /author/{name}
    @GetMapping("/author/{name}")
    public String authorName(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 8. /addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {

        bookList.add(book);
        return "Book added successfully";
    }

    // 9. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {

        return bookList;
    }
}