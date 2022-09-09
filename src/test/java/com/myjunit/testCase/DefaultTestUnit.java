package com.myjunit.testCase;

import com.myjunit.core.TestResult;
import com.myjunit.core.TestUnit;
import com.myjunit.core.assertion.Assertion;
import com.myjunit.core.Test;

public class DefaultTestUnit extends TestUnit {

  public DefaultTestUnit(String name) {
    super(name);
  }

  @Test
  public void passTest() {
    Assertion.isTrue(true);
  }

  @Test
  public void failTest() {
    Assertion.isTrue(false);
  }

  public static void main(String[] args) {
    TestResult testResult = new TestResult();
    new DefaultTestUnit("passTest").execute(testResult);
    new DefaultTestUnit("failTest").execute(testResult);

    testResult.printResult();
  }

}
