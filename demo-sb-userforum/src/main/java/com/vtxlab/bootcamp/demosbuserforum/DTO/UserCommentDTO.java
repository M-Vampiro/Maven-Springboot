package com.vtxlab.bootcamp.demosbuserforum.DTO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCommentDTO {

  private int id;

  private String username;

  private String email;

  private String phone;

  @JsonProperty(value = "comments")
  private List<CommentDTO> commentDTOs;

}