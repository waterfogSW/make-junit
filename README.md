# make-junit

## 구현한 주요 기능

-   Assert
-   단위 테스트
-   어노테이션

## Dependency

- Java 17
- slf4j-api:2.0.0
- logback-classic:1.4.0
- reflections:0.10.2

## 사용방법

- java/com/myjunit/testCase 패키지에 테스트할 메서드를 `@Test`어노테이션을 붙여 작성한다.

```java
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

```
