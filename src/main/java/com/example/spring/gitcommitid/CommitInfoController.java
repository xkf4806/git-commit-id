package com.example.spring.gitcommitid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author xinj.x
 */
@RestController
public class CommitInfoController {
  @Value("${git.commit.message.short}")
  private String commitMessage;

  @Value("${git.branch}")
  private String branch;

  @Value("${git.commit.id}")
  private String commitId;

  @GetMapping(value = "/version")
  public String versionInformation() {
    return readGitProperties();
  }

  private String readGitProperties() {
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream("git.properties");
    try {
      return readFromInputStream(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
      return "Version information could not be retrieved";
    }
  }

  private String readFromInputStream(InputStream inputStream) throws IOException {
    StringBuilder resultStringBuilder = new StringBuilder();
    try (BufferedReader br
                 = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        resultStringBuilder.append(line).append("\n");
      }
    }
    return resultStringBuilder.toString();
  }
}
