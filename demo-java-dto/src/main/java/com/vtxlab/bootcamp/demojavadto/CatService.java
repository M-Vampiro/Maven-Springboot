package com.vtxlab.bootcamp.demojavadto;

import java.util.ArrayList;
import java.util.List;

import com.vtxlab.bootcamp.demojavadto.model.Cat;


public class CatService {

  public Cat getCat() {
    // call api, read database
    return new Cat("John", 1);
  }

  public List<Cat> getCats() {
    List<Cat> cats = new ArrayList<>();
    Cat cat1 = new Cat("John", 2);
    Cat cat2 = new Cat("Peter", 3);
    cats.add(cat1);
    cats.add(cat2);
    return cats;
  }

  public List<Cat> getCatList() throws Exception {
    List<Cat> cats = new ArrayList<>();
    try {
      cats = callJPH();
    } catch (Exception e) {
      throw new Exception();
    }
    return cats;
  }

  public Cat getCatList2(int index) throws Exception {
    if (index < 0)
      throw new IllegalArgumentException();
    List<Cat> cats = new ArrayList<>();
    try {
      cats = callJPH();
      if (index < cats.size())
        throw new IllegalArgumentException();
      if (cats != null && cats.size() != 0)
        return cats.get(index);
      throw new Exception();
    } catch (Exception e) {
      throw new Exception();
    }
  }

  public List<Cat> callJPH() throws Exception {
    return List.of(new Cat("John", 3), new Cat("Sally", 10));
  }



}