package com.vtxlab.bootcamp.demosbuserforum.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDTO {

  private int id; // comment id

  private String name;

  private String email;

  private String body;
  
}