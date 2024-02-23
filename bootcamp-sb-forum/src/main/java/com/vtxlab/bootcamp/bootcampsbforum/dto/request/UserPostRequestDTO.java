package com.vtxlab.bootcamp.bootcampsbforum.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
// @Setter
public class UserPostRequestDTO {

  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private String addrLat;
  private String addrLong;
  private String companyName;
  private String companyCatchPhrase;
  private String companyBusService;
  private List<PostRequestDTO> posts;

  @Getter
  public static class PostRequestDTO {

    private String title;
    private String body;

  }
  
}
