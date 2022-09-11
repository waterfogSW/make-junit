package com.myjunit.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myjunit.core.assertion.AssertionFailedException;

public class TestUnit {

  private final Logger logger;
  private final Method method;
  private final Object instance;

  public TestUnit(Method method, Object instance) {
    this.method = method;
    this.logger = LoggerFactory.getLogger(method.getName());
    this.instance = instance;
  }

  public String getName() {
    return method.getName();
  }

  public void execute(TestResult testResult) {
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
    }
  }

  public void test() throws Exception {
    method.invoke(instance);
    logger.info("Test passed");
  }

  private boolean isAssertionFailed(InvocationTargetException ite) {
    return ite.getTargetException() instanceof AssertionFailedException;
  }

}
