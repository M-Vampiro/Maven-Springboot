package com.vtxlab.bootcamp.bootcampsbforum.poly;

public interface Driver {

  public static final Integer MONTHLY_SALARY = 20000; // constant

  String hello3(); //

  default String hello() { // instance method
    return "hello";
  }

  static String concat(String x, String y) {
    return x.concat(y);
  }

  public static void main(String[] args) {
    Driver.concat("A", "v");
  }

}
