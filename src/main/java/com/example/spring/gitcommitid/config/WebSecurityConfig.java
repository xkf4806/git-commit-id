package com.example.spring.gitcommitid.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author xinj.x
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .permitAll()
            .and()
            .csrf().disable();
  }
}
