package com.example.spring.gitcommitid.analyzer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

/**
 * @author xinj.x
 */
@Slf4j
public class MyFailureAnalyzer implements FailureAnalyzer {
  @Override
  public FailureAnalysis analyze(Throwable failure) {
    log.error("发生异常了，具体原因如下：{}", failure);
    return null;
  }
}
