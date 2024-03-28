package com.vtxlab.bootcamp.stockprofilefetcher.DTO.JPH;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Profile2DTO {

  private String country;

  private String currency;

  private String exchange;

  private String finnhubindustry;

  private String ipo;

  private String logo;

  private Long marketCapitalization;

  private String name;

  private String phone;

  private Double shareOutstanding;

  private String ticker;

  private String weburl;

}
