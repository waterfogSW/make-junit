package com.myjunit.core.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myjunit.core.assertion.AssertionFailedException;

public class TestUnit implements Test {

  private final Logger logger;
  private final Method method;

  public TestUnit(Method method) {
    this.method = method;
    this.logger = LoggerFactory.getLogger(method.getName());
  }

  @Override
  public void execute(TestResult testResult) {
    testResult.startTest();
    try {
      invoke();
      logger.info("Test passed");
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

  private void invoke() throws Exception {
    Object newInstance = getNewInstanceOfDeclaringClass(method);
    method.setAccessible(true);
    method.invoke(newInstance);
  }

  private boolean isAssertionFailed(InvocationTargetException ite) {
    return ite.getTargetException() instanceof AssertionFailedException;
  }

  private Object getNewInstanceOfDeclaringClass(Method method) throws Exception {
    return method
        .getDeclaringClass()
        .getDeclaredConstructor()
        .newInstance();
  }

}
