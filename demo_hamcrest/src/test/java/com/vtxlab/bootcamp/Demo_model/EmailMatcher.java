package com.vtxlab.bootcamp.Demo_model;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class EmailMatcher extends TypeSafeMatcher<String> {
  // Acceptable email prefix formats
  // Allowed characters: letters (a-z), numbers, underscores, periods, and dashes.
  // An underscore, period, or dash must be followed by one or more letter or number.

  // Acceptable email domain formats
  // Allowed characters: letters, numbers, dashes.
  // The last portion of the domain must be at least two characters, for example: .com, .org, .cc
  @Override
  public boolean matchesSafely(String item) {
    // regular expression - email address pattern description
    return item.matches(
        "^[A-Za-z0-9._-]+[A-Za-z0-9]\\@[A-Za-z0-9-]+\\.[A-Z|a-z]{2,}$");
  }

  @Override
  public void describeTo(Description description) { // pass by reference
    description.appendText("The email address format is invalid.");
  }

  public static Matcher<String> validEmailAddress() {
    return new EmailMatcher();
  }
}