package com.vtxlab.bootcamp.Demo_model;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class UppercaseStringMatcher extends TypeSafeMatcher<String> {

  @Override
  public boolean matchesSafely(String item) {
    // regular expression - string pattern description
    return item.matches("[A-Z]+");
  }

  @Override
  public void describeTo(Description description) { // pass by reference
    description.appendText("The string should contain upper case only.");
  }

  public static Matcher<String> containsUppercaseOnly() {
    return new UppercaseStringMatcher();
  }
}
