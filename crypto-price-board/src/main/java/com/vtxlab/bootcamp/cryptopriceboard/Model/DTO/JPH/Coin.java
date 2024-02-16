package com.vtxlab.bootcamp.cryptopriceboard.Model.DTO.JPH;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coin {

  @JsonProperty(value = "id")
  private String id;

  @JsonProperty(value = "symbol")
  private String symbol;

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "image")
  private String image;

  @JsonProperty(value = "current_price")
  private long current_price;

  @JsonProperty(value = "market_cap")
  private long market_cap;

  @JsonProperty(value = "market_cap_rank")
  private int market_cap_rank;

  @JsonProperty(value = "fully_diluted_valuation")
  private long fully_diluted_valuation;

  @JsonProperty(value = "total_volume")
  private long total_volume;

  @JsonProperty(value = "high_24h")
  private int high_24h;

  @JsonProperty(value = "low_24h")
  private int low_24h;

  @JsonProperty(value = "price_change_24h")
  private double price_change_24h;

  @JsonProperty(value = "price_change_percentage_24h")
  private double price_change_percentage_24h;

  @JsonProperty(value = "market_cap_change_24h")
  private double market_cap_change_24h;

  @JsonProperty(value = "market_cap_change_percentage_24h")
  private double market_cap_change_percentage_24h;

  @JsonProperty(value = "circulating_supply")
  private int circulating_supply;

  @JsonProperty(value = "total_supply")
  private int total_supply;

  @JsonProperty(value = "max_supply")
  private int max_supply;

  @JsonProperty(value = "ath")
  private int ath;

  @JsonProperty(value = "ath_change_percentage")
  private double ath_change_percentage;

  @JsonProperty(value = "ath_date")
  private String ath_date;

  @JsonProperty(value = "atl")
  private double atl;

  @JsonProperty(value = "atl_change_percentage")
  private double atl_change_percentage;

  @JsonProperty(value = "atl_date")
  private String atl_date;

  @JsonProperty(value = "roi")
  private Roi roi;

  @JsonProperty(value = "last_updated")
  private String last_updated;

  @Setter
  @Getter
  public static class Roi {

    @JsonProperty(value = "times")
    private double times;

    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "percentage")
    private double percentage;

  }

}
