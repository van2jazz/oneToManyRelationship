package com.dayo.demo.dao;

import com.dayo.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository <Book, Long>{
}