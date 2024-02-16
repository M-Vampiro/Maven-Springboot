package com.vtxlab.bootcamp.cryptopriceboard.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coin {

  private String id;

  private String symbol;

  private String name;

  private String image;

  private long current_price;

  private long market_cap;

  private int market_cap_rank;

  private long fully_diluted_valuation;

  private long total_volume;

  private int high_24h;

  private int low_24h;

  private double price_change_24h;

  private double price_change_percentage_24h;

  private double market_cap_change_24h;

  private double market_cap_change_percentage_24h;

  private int circulating_supply;

  private int total_supply;

  private int max_supply;

  private int ath;

  private double ath_change_percentage;

  private String ath_date;

  private double atl;

  private double atl_change_percentage;

  private String atl_date;

  private Roi roi;

  private String last_updated;

  @Setter
  @Getter
  public static class Roi {

    private double times;

    private String currency;

    private double percentage;

  }

}
