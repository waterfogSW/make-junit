package com.myjunit.core.assertion;

public class Assertion {

  private Assertion() {}

  public static void isTrue(boolean expression, String message) {
    if (!expression) {
      throw new AssertionFailedException(message);
    }
  }

  public static void isTrue(boolean expression) {
    isTrue(expression, "[Assertion failed] - this expression must be true");
  }

}
