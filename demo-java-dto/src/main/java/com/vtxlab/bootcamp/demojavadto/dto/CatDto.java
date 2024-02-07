package com.vtxlab.bootcamp.demojavadto.dto;

import java.util.Map;

public class CatDto {

  private String description; // "Cat Name: John, Cat Age: 1"

  private String logo;

  public CatDto(String description, String logo) {
    this.description = description;
    this.logo = logo;
  }
  
}