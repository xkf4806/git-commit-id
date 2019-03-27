package com.example.spring.gitcommitid.controller;

import com.example.spring.gitcommitid.dao.BookRepository;
import com.example.spring.gitcommitid.domain.Book;
import com.example.spring.gitcommitid.exception.BookIdMismatchException;
import com.example.spring.gitcommitid.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinj.x
 */
@RestController
@RequestMapping(value = "/api/book")
public class BookController {
  @Autowired
  private BookRepository bookRepository;

  @GetMapping(value = "")
  public Iterable getAll() {
    return bookRepository.findAll();
  }

  @GetMapping(value = "/title/{title}")
  public List<Book> books(@PathVariable String title) {
    return bookRepository.findByTitle(title);
  }

  @GetMapping(value = "/{id}")
  public Book findOne(@PathVariable Long id) {
    return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Book create(@RequestBody Book book) {
    return bookRepository.save(book);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    bookRepository.findById(id)
            .orElseThrow(BookNotFoundException::new);
    bookRepository.deleteById(id);
  }

  @PutMapping("/{id}")
  public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
    if (book.getId() != id) {
      throw new BookIdMismatchException();
    }
    bookRepository.findById(id)
            .orElseThrow(BookNotFoundException::new);
    return bookRepository.save(book);
  }
}
