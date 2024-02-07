package com.vtxlab.bootcamp.demosbfakedatabase.Service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.demosbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.demosbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.demosbfakedatabase.Service.CatDatabaseService;

// @Service
@Component
// Create an object of this class, put it into Spring context
public class CatDatabaseServiceImpl implements CatDatabaseService {

  // Objectives of Service
  // 1. Data source
  // 2. The service you are going to provide

  @Override
  public Cat getCatFromStaticMemory(int index) {
    return CatDatabase.getCat(index);
  }

  @Override
  public List<Cat> getAllCatFromStaticMemory() {
    return CatDatabase.getAllCat();
  }

  @Override
  public Cat setCatToStaticMemory(int index, Cat cat) {
    return CatDatabase.setCat(index, cat);
  }

  @Override
  public Cat createCatInStaticMemory(int index, Cat cat) {
    return CatDatabase.createCat(index, cat);
  }

  @Override
  public Boolean deleteCatFromStaticMemory(int index) {
    return CatDatabase.deleteCat(index);
  }

  @Override
  public Boolean updateCatInStaticMemory(int index, Cat cat) {
    return CatDatabase.updateCat(index, cat);
  }

  @Override
  public Cat patchCatNameInStaticMemory(int index, String name) {
    return CatDatabase.patchCatName(index, name);
  }

  @Override
  public Cat patchCatAgeInStaticMemory(int index, int age) {
    return CatDatabase.patchCatAge(index, age);
  }

}