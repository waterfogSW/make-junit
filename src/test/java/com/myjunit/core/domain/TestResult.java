package com.myjunit.core.domain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestResult {

  private static final Logger logger = LoggerFactory.getLogger(TestResult.class);

  private int runTestCount;
  private final List<TestError> errors;
  private final List<TestFailure> failures;

  public TestResult() {
    this.runTestCount = 0;
    this.errors = new ArrayList<>();
    this.failures = new ArrayList<>();
  }

  public synchronized void startTest() {
    this.runTestCount++;
  }

  public void addError(
      TestUnit testUnit,
      Exception e
  ) {
    errors.add(new TestError(testUnit, e));
  }

  public void addFailure(TestUnit testUnit) {
    failures.add(new TestFailure(testUnit));
  }

  public void printResult() {
    logger.info("Total Test Count: {}", runTestCount);
    logger.info("Total Test Success Count: {}", runTestCount - failures.size() - errors.size());
    logger.info("Total Test Failure Count: {}", failures.size());
    logger.info("Total Test Error Count: {}", errors.size());
  }

}
