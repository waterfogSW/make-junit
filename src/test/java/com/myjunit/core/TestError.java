package com.myjunit.core;

public class TestError extends TestFailure {

  private final Exception exception;

  public TestError(
      TestUnit testUnit,
      Exception exception
  ) {
    super(testUnit);
    this.exception = exception;
  }

  public Exception getException() {
    return exception;
  }

}
