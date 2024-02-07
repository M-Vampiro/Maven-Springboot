package com.vtxlab.bootcamp.demosbuserforum.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDTO {

  private int id;

  private String title;

  private String body;
  
}