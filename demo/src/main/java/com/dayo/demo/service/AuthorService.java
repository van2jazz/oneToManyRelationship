package com.dayo.demo.service;

import com.dayo.demo.dao.AuthorDao;
import com.dayo.demo.entity.Author;

import java.util.List;

public class AuthorService {

    AuthorDao authorDao;

    public void deleteAuthor(Long authorId){
        authorDao.deleteById(authorId);
    }

    public List<Author> getAuthors() {
        return authorDao.findAll();
    }


    public Author createAuthor(Author author) {
        return authorDao.save(author);
    }

    public Author updateAuthor(Author author){
        return authorDao.save(author);
    }
}
