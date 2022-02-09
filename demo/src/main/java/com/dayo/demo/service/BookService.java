package com.dayo.demo.service;

import com.dayo.demo.dao.AuthorDao;
import com.dayo.demo.dao.BookDao;
import com.dayo.demo.entity.Author;
import com.dayo.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;



    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book createBook (Long authorId, Book book){
        Set<Book> books = new HashSet<>();
        Author author1 = new Author();

        Optional<Author> byId = authorDao.findById(authorId);
        if (!byId.isPresent()){
            throw new ResourceNotFoundException("Author with id " + author);
        }
        Author author =byId.get();

        //tie Author to book
        book.setAuthor(author);
        Book book1 = bookDao.save(book);

        //tie book to Author
        books.add(book1);
        author1.setBooks(books);

        return book1;
    }

    public Optional<Book> getBookById(Long bookId) {
        if (!bookDao.existsById(bookId)){
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }
        return bookDao.findById(bookId);
    }

    public void delete(Long bookId) {
        bookDao.deleteById(bookId);
    }

    public Book updateBook(Book book) {
        return bookDao.save(book);
    }
}
