package com.example.spring.gitcommitid.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author xinj.x
 */
@Entity
@Data
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(nullable = false, unique = true)
  private String title;
  @Column(nullable = false)
  private String author;
}
