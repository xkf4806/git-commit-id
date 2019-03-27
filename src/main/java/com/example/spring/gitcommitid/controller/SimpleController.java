package com.example.spring.gitcommitid.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xinj.x
 */
@Controller
public class SimpleController {
  @Value("${spring.application.name}")
  private String appName;

  @GetMapping(value = "/home")
  public String homePage(Model model) {
    model.addAttribute("appName", appName);
    return "home";
  }
}
