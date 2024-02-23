package com.vtxlab.bootcamp.bootcampsbforum.dto.response.gov;

import lombok.Getter;
import lombok.Setter;

// User -> UserDTO (ignore some fields)
@Getter
@Setter
public class UserDTO {
  
  private int id;
  private String email;
  private String phone;

}
