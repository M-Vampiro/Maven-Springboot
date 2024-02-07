package com.vtxlab.bootcamp.demosbhelloworld.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Cat {

  private int age;
  private String name;

  
  
}
