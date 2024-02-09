package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder // Testing only. Not required for Deserialization.
public class User {

  private int id;

  private String name;

  private String username;

  private String email;

  private Address address;

  private String phone;

  private String website;

  private Company company;

  @Getter
  public static class Address {

    private String street;

    private String suite;

    private String city;

    private String zipcode;

    private Location geo;

    @Getter
    public static class Location {

      @JsonProperty(value = "lat")
      private String latitude;

      @JsonProperty(value = "lng")
      private String longitude;

    }

  }

  @Getter
  public static class Company {

    private String name;

    private String catchPhrase;

    @JsonProperty(value = "bs")
    private String busService;

  }

}
