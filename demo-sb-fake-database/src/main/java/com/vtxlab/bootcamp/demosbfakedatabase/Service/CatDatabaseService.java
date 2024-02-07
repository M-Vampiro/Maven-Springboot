package com.vtxlab.bootcamp.demosbfakedatabase.Service;

import java.util.List;

import com.vtxlab.bootcamp.demosbfakedatabase.model.Cat;

public interface CatDatabaseService {

  Cat getCatFromStaticMemory(int index);

  List<Cat> getAllCatFromStaticMemory();

  Cat setCatToStaticMemory(int index, Cat cat);

  Cat createCatInStaticMemory(int index, Cat cat);

  Boolean deleteCatFromStaticMemory(int index);

  Boolean updateCatInStaticMemory(int index, Cat cat);

  Cat patchCatNameInStaticMemory(int index, String name);

  Cat patchCatAgeInStaticMemory(int index, int age);

}