package com.dayo.demo.controller;

import com.dayo.demo.entity.Author;
import com.dayo.demo.entity.Awards;
import com.dayo.demo.entity.Book;
import com.dayo.demo.service.AuthorService;
import com.dayo.demo.service.AwardsService;
import com.dayo.demo.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
import java.util.Optional;

public class controller {

    AuthorService authorService;

    BookService bookService;

    AwardsService awardsService;

    //Author
    @RequestMapping(value = "getAllAuthor", method = RequestMethod.GET)
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Author updateAuthor(Author author){
        return authorService.updateAuthor(author);
    }

    @RequestMapping(value = "author/{authorId}", method = RequestMethod.DELETE)
    public void deleteAuthor(Long authorId){
        authorService.deleteAuthor(authorId);
    }

    //Awards
    @RequestMapping(value = "/getAwards", method = RequestMethod.GET)
    public List<Awards> getAwards(){
        return awardsService.getAwards();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Awards creteAwards(@RequestBody Awards awards){
        return awardsService.createAwards(awards);
    }

    @RequestMapping(value = "/awards/awardsId", method = RequestMethod.DELETE)
    public void deleteAwards(@PathVariable Long awardsId){
        awardsService.delete(awardsId);
    }

    @RequestMapping(value = "/updateAward" , method = RequestMethod.POST)
    public Awards updateAwards(@RequestBody Awards awards){
        return awardsService.updateAwards(awards);
    }

    @RequestMapping(value = "/awards/{awardsId}" , method = RequestMethod.GET)
    public Optional<Awards> getAwardsById(Long awardsId){
       return awardsService.getAwardsById(awardsId);
    }

    //Book
    @RequestMapping(value = "/create", method = RequestMethod.GET )
    public Book createBook(Long authorId, Book book){
        return bookService.createBook(authorId, book);
    }

    @RequestMapping(value = "/")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    public Optional<Book> getBookById(Long bookId){
        return bookService.getBookById(bookId);
    }

    public void deleteBook(Long bookId){
        bookService.delete(bookId);
    }

    public Book updateBook(Book book){
        return bookService.updateBook(book);
    }








}
