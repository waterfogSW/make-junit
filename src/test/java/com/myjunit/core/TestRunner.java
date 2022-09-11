package com.myjunit.core;

import java.lang.reflect.Method;
import java.util.Set;

public class TestRunner {

  private static final String testPackage = "com.myjunit.testCase";

  public static void main(String[] args) throws Exception {
    TestResult testResult = new TestResult();
    TestScanner testScanner = new TestScanner();
    Set<Method> methods = testScanner.scanTestMethods(testPackage);

    for (Method method : methods) {
      Object instance = method
          .getDeclaringClass()
          .getDeclaredConstructor()
          .newInstance();

      method.setAccessible(true);
      new TestUnit(method, instance).execute(testResult);
    }

    testResult.printResult();
  }

}
