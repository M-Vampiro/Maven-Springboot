package com.vtxlab.bootcamp.bootcampsbforum.dto.response.gov;

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
