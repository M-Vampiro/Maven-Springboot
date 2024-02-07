package com.vtx.bootcamp;

import com.vtx.bootcamp.Calculator.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest2 {

  private int value = 5;

  @Test
  @Order(1)
  void testAdd() {
    this.value = Calculator.add(2, 3);
    assertEquals(5, this.value);
  }

  @Test
  @Order(2)
  void testSubstract() {
    this.value = Calculator.substract(this.value, 10);
    assertEquals(-5, this.value);
  }

  public static void main(String[] args) {
    CalculatorTest2 calculatorTest2 = new CalculatorTest2();
    calculatorTest2.testAdd();
    calculatorTest2.testSubstract();
  }

}