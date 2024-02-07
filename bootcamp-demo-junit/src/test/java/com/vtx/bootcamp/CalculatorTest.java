package com.vtx.bootcamp;

import com.vtx.bootcamp.Calculator.Calculator;
import com.vtx.bootcamp.Lombok.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

// Unit Test
// Test Environment:
// @TestInstance(Test)

public class CalculatorTest {

  private int x = 10;

  @Test // maven trigger this method during "test" phase
  void testAdd() {
    int actualResult = Calculator.add(3, 2);
    int expectResult = 5;
    assertEquals(expectResult, actualResult);
    assertNotEquals(6, Calculator.add(3, 2));
    assertNotEquals(4, Calculator.add(3, 2));

    // Refer to Lark Notes - Chapter40-JUnit5-Jupiter
    // 40-JUnit5-Jupiter
    // assertTrue
    Person person = new Person("Sally", 65);
    assertTrue(person.isElderly());
    assertTrue(new Person("Sally", 66).isElderly());
    // assertFalse
    assertFalse(new Person("Sally", 64).isElderly());

    // assertNull
    assertNull(Person.of("John", -3));
    assertNull(Person.of(null, 0));
    // assertNotNull
    assertNotNull(Person.of("John", 40));

    // assertArrayEquals
    // assertSame, what is different between assertSame and assertEquals
    String s1 = "hello";
    String s2 = "hello";
    assertSame(s1, s2); // check if they are same object

    // assertNotSame
    String s3 = new String("hello");
    assertNotSame(s2, s3); // check if they are not same object

    // Person equals()
    Person x1 = new Person("Jason", 30);
    Person x2 = new Person("Jason", 30);
    assertNotSame(x1, x2);
    assertEquals(x1, x2);

    // assertThrows
    assertThrows(IllegalArgumentException.class,
        () -> Person.concat(null, null));
    // assertDoesNotThrow
    assertDoesNotThrow(() -> Person.concat("abc", "def"));
    assertDoesNotThrow(() -> Person.concat(null, "def"));
    assertDoesNotThrow(() -> Person.concat("abc", null));
    // assertAll

    Order order = new Order();
    assertAll(() -> assertTrue(order.order()),
        () -> assertTrue(order.payment()),
        () -> assertTrue(order.lockInventory()));

    // assertTimeout
    List<String> items = new ArrayList<>();
    for (int i = 0; i < 10_000_000; i++) {
      items.add(String.valueOf(i));
    }
    assertTimeout(Duration.ofMillis(60), //
        () -> order.placeOrder(items));

    x++;
  }

  @Test
  void testOther() {
    assertTrue(5 > 3);
    x++;
    System.out.println("this.x = " + this.x);// 11
  }

  public static void main(String[] args) {
    CalculatorTest calculator1 = new CalculatorTest();
    calculator1.testAdd();
    CalculatorTest calculator2 = new CalculatorTest();
    calculator2.testOther();
    System.out.println(calculator2.x);// 11

  }

}
