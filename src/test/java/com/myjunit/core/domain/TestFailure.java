package com.myjunit.core.domain;

public class TestFailure {

  private final TestUnit testUnit;

  public TestFailure(TestUnit testUnit) {
    this.testUnit = testUnit;
  }

  public String getTestName() {
    return testUnit.getName();
  }

}
