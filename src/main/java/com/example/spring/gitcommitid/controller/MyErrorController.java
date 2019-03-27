package com.example.spring.gitcommitid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xinj.x
 */
@Controller
@RequestMapping(value = "/math")
public class MyErrorController {
  @GetMapping(value = "/5xx")
  public void serverError() {
    int i = 1 / 0;
  }
}
