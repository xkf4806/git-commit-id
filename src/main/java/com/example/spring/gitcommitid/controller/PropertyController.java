package com.example.spring.gitcommitid.controller;

import com.example.spring.gitcommitid.config.AcmeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinj.x
 */
@RestController
public class PropertyController {
  @Autowired
  private final AcmeProperties acmeProperties;

  public PropertyController(AcmeProperties acmeProperties) {
    this.acmeProperties = acmeProperties;
  }

  @GetMapping(value = "/props")
  public AcmeProperties.Security getProps() {
    return acmeProperties.getSecurity();
  }
}
