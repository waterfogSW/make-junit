package com.myjunit.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myjunit.core.assertion.AssertionFailedException;

public abstract class TestUnit {

  private final Logger logger;
  private final String name;

  public TestUnit(String name) {
    this.name = name;
    this.logger = LoggerFactory.getLogger(name);
  }

  public String getName() {
    return name;
  }

  public void execute(TestResult testResult) {
    before();
    testResult.startTest();
    try {
      test();
    } catch (InvocationTargetException e) {
      if (isAssertionFailed(e)) {
        logger.info("Test failed");
        testResult.addFailure(this);
      } else {
        logger.info("Test error occur");
        testResult.addError(this, e);
      }
    } catch (Exception e) {
      logger.info("Test failed");
      testResult.addError(this, e);
    } finally {
      after();
    }
  }

  protected void before() {}

  protected void after() {}

  public void test() throws Exception {
    Method method = this
        .getClass()
        .getMethod(name);
    method.invoke(this);
    logger.info("Test passed");
  }

  private boolean isAssertionFailed(InvocationTargetException ite) {
    return ite.getTargetException() instanceof AssertionFailedException;
  }

}
