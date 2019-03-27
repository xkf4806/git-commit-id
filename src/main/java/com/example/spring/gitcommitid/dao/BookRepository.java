package com.example.spring.gitcommitid.dao;

import com.example.spring.gitcommitid.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author xinj.x
 */
public interface BookRepository extends CrudRepository<Book, Long> {
  List<Book> findByTitle(String title);
}
