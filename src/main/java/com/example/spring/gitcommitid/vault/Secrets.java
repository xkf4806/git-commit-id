package com.example.spring.gitcommitid.vault;

import lombok.Data;

/**
 * @author xinj.x
 */
@Data
public class Secrets {
  String username;
  String password;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
