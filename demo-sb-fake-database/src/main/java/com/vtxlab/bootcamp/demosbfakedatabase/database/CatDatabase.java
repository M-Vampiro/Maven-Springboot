package com.vtxlab.bootcamp.demosbfakedatabase.database;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.vtxlab.bootcamp.demosbfakedatabase.model.Cat;

public class CatDatabase {

  private static Cat[] cats;

  private static final int dbLength = 10;

  static {
    cats = new Cat[dbLength];
    cats[0] = new Cat("John", 2);
    cats[1] = new Cat("Mary", 1);
  }

  public static Cat getCat(int index) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    return cats[index];
  }

  public static List<Cat> getAllCat() {
    // return Arrays.asList(cats);
    return Arrays.stream(cats).collect(Collectors.toList());
  }

  public static synchronized Cat setCat(int index, Cat cat) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    cats[index] = cat;
    return getCat(index);
  }

  public static Cat createCat(int index, Cat cat) {
    if (cats[index] != null)
      throw new IllegalArgumentException("The Space is Not Empty");
    cats[index] = cat;
    return getCat(index);
  }

  public static Boolean deleteCat(int index) {
    if (cats[index] == null)
      return false;
    cats[index] = null;
    return true;
  }

  public static Boolean updateCat(int index, Cat cat) {
    if (cats[index] == null || cats[index].equals(cat))
      return false;
    cats[index] = cat;
    return true;
  }

  public static Cat patchCatName(int index, String name) {
    if (cats[index] == null)
      throw new NullPointerException();
    cats[index].setName(name);
    return getCat(index);
  }

  public static Cat patchCatAge(int index, int age) {
    if (cats[index] == null)
      throw new NullPointerException();
    cats[index].setAge(age);
    return getCat(index);
  }

}