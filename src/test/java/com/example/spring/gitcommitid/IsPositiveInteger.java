package com.example.spring.gitcommitid;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * 自定义matcher
 * @author xinj.x
 */
public class IsPositiveInteger extends TypeSafeMatcher<Integer> {

  @Override
  protected boolean matchesSafely(Integer item) {
    return item > 0;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("a positive integer");
  }

  @Factory
  public static Matcher<Integer> isAPositiveInteger() {
    return new IsPositiveInteger();
  }
}
