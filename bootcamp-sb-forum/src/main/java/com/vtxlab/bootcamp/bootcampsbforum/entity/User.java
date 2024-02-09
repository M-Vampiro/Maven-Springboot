package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generated
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  @Column(name = "ADDRESS_LAT")
  private String addrLat;
  @Column(name = "ADDRESS_LNG")
  private String addrLong;
  @Column(name = "COMPANY_NAME")
  private String cName;
  @Column(name = "COMPANY_CATCH_PHRASE")
  private String cCatchPhrase;
  @Column(name = "COMPANY_BUSINESS_SERVICE")
  private String cBusService;

}
