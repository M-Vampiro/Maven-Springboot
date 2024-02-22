package com.vtxlab.bootcamp.bootcampsbforum.poly;

public class Cat implements Flyable, Swimable {

  @Override
  public void swim() {

  }

  @Override 
  public void fly() {

  }

  public static void main(String[] args) {
    Cat cat = new Cat();

    Swimable swimableCat = cat;
    Flyable flyableCat = cat;


  }
  
}
