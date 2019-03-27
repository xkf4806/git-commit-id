package com.example.spring.gitcommitid;

import lombok.Data;

/**
 * @author xinj.x
 */
@Data
public class Person {
  String name;
  String address;

  public Person(String personName, String personAddress) {
    name = personName;
    address = personAddress;
  }
}
