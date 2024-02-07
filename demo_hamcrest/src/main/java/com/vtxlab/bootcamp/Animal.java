package com.vtxlab.bootcamp;

public interface Animal {

  static Animal get(int idx) {
    return idx % 2 == 0 ? new Cat() : new Dog();
  }

}
