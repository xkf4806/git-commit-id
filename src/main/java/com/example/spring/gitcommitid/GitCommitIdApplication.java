package com.example.spring.gitcommitid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Michael
 */
@SpringBootApplication
public class GitCommitIdApplication {

  public static void main(String[] args) {
    SpringApplication.run(GitCommitIdApplication.class, args);
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
    PropertySourcesPlaceholderConfigurer propsConfig
            = new PropertySourcesPlaceholderConfigurer();
    propsConfig.setLocation(new ClassPathResource("git.properties"));
    propsConfig.setIgnoreResourceNotFound(true);
    propsConfig.setIgnoreUnresolvablePlaceholders(true);
    return propsConfig;
  }

}
