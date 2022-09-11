package com.myjunit.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestSuit {

  private final List<TestUnit> testUnits;

  public TestSuit(Set<Method> methods) {
    this.testUnits = new ArrayList<>();
    methods
        .stream()
        .map(TestUnit::new)
        .forEach(testUnits::add);
  }

  public void execute(TestResult testResult) {

    testUnits.forEach(o -> o.execute(testResult));
  }

}
