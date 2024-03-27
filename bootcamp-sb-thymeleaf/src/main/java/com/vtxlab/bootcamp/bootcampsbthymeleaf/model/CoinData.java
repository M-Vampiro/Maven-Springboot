package com.vtxlab.bootcamp.bootcampsbthymeleaf.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CoinData {

  private String id;
  private String image;
  @JsonProperty(value = "current_price")
  private Double currentPrice;

}
