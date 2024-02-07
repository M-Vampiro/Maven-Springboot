package com.vtxlab.bootcamp.demosbuserforum.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// User -> UserDTO ( ignores some fields)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  private int id;
  private String name;
  private String userName;
  
}
