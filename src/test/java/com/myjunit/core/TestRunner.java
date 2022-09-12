package com.myjunit.core;

import java.lang.reflect.Method;
import java.util.Set;

import com.myjunit.core.domain.TestResult;
import com.myjunit.core.domain.TestSuit;
import com.myjunit.core.util.TestScanner;

public class TestRunner {

  private static final String testPackage = "com.myjunit.testCase";

  public static void main(String[] args) {
    TestResult testResult = new TestResult();

    TestScanner testScanner = new TestScanner();
    Set<Method> methods = testScanner.scanTestMethods(testPackage);

    TestSuit testSuit = new TestSuit(methods);
    testSuit.execute(testResult);

    testResult.printResult();
  }

}
