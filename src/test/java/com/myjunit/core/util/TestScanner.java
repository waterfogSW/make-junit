package com.myjunit.core.util;

import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import com.myjunit.core.annotation.Test;

public class TestScanner {

  public Set<Method> scanTestMethods(String packageName) {
    Reflections reflections = new Reflections(packageName, Scanners.MethodsAnnotated);
    return reflections.getMethodsAnnotatedWith(Test.class);
  }

}
