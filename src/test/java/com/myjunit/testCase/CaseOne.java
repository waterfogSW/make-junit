package com.myjunit.testCase;

import com.myjunit.core.Test;
import com.myjunit.core.assertion.Assertion;

public class CaseOne {

  @Test
  void passTest() {
    Assertion.isTrue(true);
  }

  @Test
  void failTest() {
    Assertion.isTrue(false);
  }
}
